package com.ada.aula_todo_list.controller;

import com.ada.aula_todo_list.dto.TodoItemDTO;
import com.ada.aula_todo_list.dto.TodoListResponseDTO;
import com.ada.aula_todo_list.service.ExternalTodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/external/todos")
@RequiredArgsConstructor
public class ExternalTodoController {

    private final ExternalTodoService externalTodoService;

    @GetMapping
    public TodoListResponseDTO all() {
        return externalTodoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public TodoItemDTO getById(@PathVariable Long id) {
        return externalTodoService.getTodoById(id);
    }
}
