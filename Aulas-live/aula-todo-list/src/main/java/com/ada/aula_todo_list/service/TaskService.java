package com.ada.aula_todo_list.service;

import com.ada.aula_todo_list.domain.dto.TaskDTO;
import com.ada.aula_todo_list.domain.dto.response.TaskResponse;
import com.ada.aula_todo_list.domain.Task;
import com.ada.aula_todo_list.domain.User;
import com.ada.aula_todo_list.enums.Status;
import com.ada.aula_todo_list.repository.TaskRepository;
import com.ada.aula_todo_list.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    private LocalDateTime parseDueDate(String s) {
        if (s == null) return null;

        try {
            return LocalDateTime.parse(s);
        }catch (DateTimeParseException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data de vencimento deve estar no formato ISO-8601, por exemplo, 2025-12-01T15:30.");
        }
    }

    private TaskResponse toResponse(Task t) {
        TaskResponse r = new TaskResponse();
        r.setId(t.getId());
        r.setTitle(t.getTitle());
        r.setDescription(t.getDescription());
        r.setDueDate(t.getDueDate());
        r.setStatus(t.getStatus().name());
        r.setPublic(t.isPublic());
        r.setOwnerId(t.getOwner() != null ? t.getOwner().getId() : null);
        r.setParticipantIds(t.getParticipants().stream().map(User::getId).collect(Collectors.toList()));
        return r;
    }

    //Listar tarefas visíveis ao usuário: públicas + tarefas do proprietário + tarefas em que o usuário participa
    public List<TaskResponse> listVisible(Long userId) {
        List<Task> all = taskRepository.findAll();
        return  all.stream().filter(t -> {
            if (t.isPublic()) return true;
            if (t.getOwner() != null && t.getOwner().getId().equals(userId)) return true;
            return t.getParticipants().stream().anyMatch(u -> u.getId().equals(userId));
        }).map(this::toResponse).collect(Collectors.toList());
    }

    public TaskResponse create(TaskDTO dto) {

        //validar se o proprietário existe
        User owner = userRepository.findById(dto.getOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Proprietário não encontrado"));

        Task t = new Task();
        t.setTitle(dto.getTitle());
        t.setDescription(dto.getDescription());
        t.setDueDate(parseDueDate(dto.getDueDate()));
        t.setStatus(Status.valueOf(dto.getStatus()));
        t.setPublic(dto.isPublic());
        t.setOwner(owner);

        //Adicionar participantes, se fornecidos.
        if (dto.getParticipantIds() != null) {
            for (Long pid : dto.getParticipantIds()) {
                userRepository.findById(pid).ifPresent(t.getParticipants()::add);
            }
        }

        //verificar conflitos
        if (t.getDueDate() != null) {
            for (Long pid : t.getParticipants().stream().map(User::getId).toList()) {
                List<Task> userTasks = taskRepository.findByOwnerIdOrParticipantsId(pid, pid);
                for (Task existing : userTasks) {
                    if (existing.getDueDate() != null && existing.getDueDate().equals(t.getDueDate())) {
                        throw new ResponseStatusException(HttpStatus.CONFLICT, "Conflito de agenda para usuário " + pid);
                    }
                }
            }

            //Verifique também o proprietário.
            List<Task> ownerTasks = taskRepository.findByOwnerIdOrParticipantsId(owner.getId(), owner.getId());
            for (Task existing : ownerTasks) {
                if (existing.getDueDate() != null && existing.getDueDate().equals(t.getDueDate())) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Conflito de agenda para owner");
                }
            }
        }

        Task saved = taskRepository.save(t);
        return toResponse(saved);
    }

    public TaskResponse getById(Long id, Long requesterId) {
        Task t = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "tarefa não encontrada"));

        //verificação de visibilidade
        if (!t.isPublic()) {
            boolean ok = (t.getOwner() != null && t.getOwner().getId().equals(requesterId))
                    || t.getParticipants().stream().anyMatch(u -> u.getId().equals(requesterId));
            if (!ok) throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Não é permitido visualizar a tarefa.k");
        }
        return toResponse(t);
    }

    public TaskResponse update(Long id, Long requesterId, TaskDTO dto) {
        Task t = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "tarefa não encontrada"));

        // Somente o proprietário pode atualizar.
        if (t.getOwner() == null || !t.getOwner().getId().equals(requesterId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Somente o proprietário pode atualizar.");
        }

        t.setTitle(dto.getTitle());
        t.setDescription(dto.getDescription());
        t.setDueDate(parseDueDate(dto.getDueDate()));
        t.setStatus(Status.valueOf(dto.getStatus()));
        t.setPublic(dto.isPublic());

        // substituir participantes
        t.getParticipants().clear();
        if (dto.getParticipantIds() != null) {
            for (Long pid : dto.getParticipantIds()) {
                userRepository.findById(pid).ifPresent(t.getParticipants()::add);
            }
        }

        // verificação de conflito semelhante a criar
        if (t.getDueDate() != null) {
            for (Long pid : t.getParticipants().stream().map(User::getId).toList()) {
                List<Task> userTasks = taskRepository.findByOwnerIdOrParticipantsId(pid, pid);
                for (Task existing : userTasks) {
                    if (!existing.getId().equals(t.getId()) && existing.getDueDate() != null && existing.getDueDate().equals(t.getDueDate())) {
                        throw new ResponseStatusException(HttpStatus.CONFLICT, "Conflito de agenda para usuário " + pid);
                    }
                }
            }
            // proprietário
            List<Task> ownerTasks = taskRepository.findByOwnerIdOrParticipantsId(t.getOwner().getId(), t.getOwner().getId());
            for (Task existing : ownerTasks) {
                if (!existing.getId().equals(t.getId()) && existing.getDueDate() != null && existing.getDueDate().equals(t.getDueDate())) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Conflito de agenda para owner");
                }
            }
        }

        Task saved = taskRepository.save(t);
        return toResponse(saved);
    }

    public void delete(Long id, Long requesterId) {
        Task t = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "task not found"));
        if (t.getOwner() == null || !t.getOwner().getId().equals(requesterId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Somente o proprietário pode excluir");
        }
        taskRepository.delete(t);
    }

    public TaskResponse share(Long id, Long requesterId, java.util.List<Long> participantIds) {
        Task t = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "task not found"));
        if (t.getOwner() == null || !t.getOwner().getId().equals(requesterId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "only owner can share");
        }
        for (Long pid : participantIds) {
            userRepository.findById(pid).ifPresent(u -> {
                if (!t.getParticipants().contains(u)) t.getParticipants().add(u);
            });
        }
        Task saved = taskRepository.save(t);
        return toResponse(saved);
    }




}
