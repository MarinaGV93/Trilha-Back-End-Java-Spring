package com.ada.aula_todo_list.service;

import com.ada.aula_todo_list.dto.external.TodoListResponse;
import com.ada.aula_todo_list.dto.external.UserListResponse;
import com.ada.aula_todo_list.entity.Task;
import com.ada.aula_todo_list.entity.User;
import com.ada.aula_todo_list.enums.Status;
import com.ada.aula_todo_list.repository.TaskRepository;
import com.ada.aula_todo_list.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeedService {

    private final WebClient webClient;
    private final UserRepository userRepo;
    private final TaskRepository taskRepo;

    @PostConstruct
    public void seed() {
        try {

            //Buscar usuários
            UserListResponse users = webClient.get()
                    .uri("/users")
                    .retrieve()
                    .bodyToMono(UserListResponse.class)
                    .block();

            if (users != null && users.getUsers() != null) {
                List<User> list = users.getUsers().stream().map(u -> {
                    User user = new User();
                    user.setId(u.getId());
                    user.setFirstName(u.getFirstName());
                    user.setLastName(u.getLastName());
                    user.setEmail(u.getEmail());
                    return user;
                }).collect(Collectors.toList());
                userRepo.saveAll(list);
            }

            //Obter listas de tarefas a cumprir e convertê-las em tarefas (mapeamento básico)
            TodoListResponse todos = webClient.get().uri("/todos").retrieve().bodyToMono(TodoListResponse.class).block();

            if (todos != null && todos.getTodos() != null){
                List<Task> tasks = todos.getTodos().stream().map(t -> {
                    Task task = new Task();
                    task.setTitle(t.getTodo());
                    task.setDescription(null);
                    task.setStatus(t.isCompleted() ? Status.DONE : Status.TODO);
                    task.setPublic(false);

                    //Tente definir o proprietário se o usuário existir.
                    userRepo.findById(t.getUserId()).ifPresent(task::setOwner);
                    return task;
                }).collect(Collectors.toList());
                taskRepo.saveAll(tasks);
            }
        } catch (Exception ex) {
            System.out.println("Errro: " + ex.getMessage());
        }
    }
}
