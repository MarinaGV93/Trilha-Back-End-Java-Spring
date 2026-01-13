package com.ada.aula_todo_list.service;

import com.ada.aula_todo_list.domain.dto.TodoItemDTO;
import com.ada.aula_todo_list.domain.dto.response.TodoListResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ExternalTodoService {

    private final WebClient webClient;

    public ExternalTodoService(WebClient webClient) {
        this.webClient = webClient;
    }

    public TodoListResponseDTO getAllTodos() {
        return webClient.get().uri("/todos").retrieve().bodyToMono(TodoListResponseDTO.class).block();
    }

    public TodoItemDTO getTodoById(Long id) {
        return webClient.get().uri("/todos/{id}", id).retrieve().bodyToMono(TodoItemDTO.class).block();
    }
}
