package com.ada.aula_todo_list.controller;

import com.ada.aula_todo_list.dto.ShareRequest;
import com.ada.aula_todo_list.dto.TaskDTO;
import com.ada.aula_todo_list.dto.TaskResponse;
import com.ada.aula_todo_list.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//API REST
//GET, POST, PUT/PATCH, DELETE

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    //Controller chama o services (regras de negocio) que chama o repository

    private final TaskService taskService;

    //Lista de task visivel para o usuário
    @GetMapping
    public List<TaskResponse> list(@RequestParam Long userId) {
        return taskService.listVisible(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse create(@Validated @RequestBody TaskDTO dto) {
        return taskService.create(dto);
    }

    @GetMapping("/{id}")
    public TaskResponse getById(@PathVariable Long id, @RequestParam Long userId) {
        return taskService.getById(id, userId);
    }

    @PutMapping("/{id}")
    public TaskResponse update(@PathVariable Long id, @RequestParam Long userId, @Validated @RequestBody TaskDTO dto) {
        return taskService.update(id, userId, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id, @RequestParam Long userId) {
        taskService.delete(id, userId);
    }

    @PostMapping("/{id}/share")
    public TaskResponse share(@PathVariable Long id, @RequestParam Long userId, @RequestBody ShareRequest req) {
        return taskService.share(id, userId, req.getParticipantIds());
    }
}
