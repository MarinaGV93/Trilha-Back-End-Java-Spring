package com.ada.aula_todo_list.dto;

import lombok.Data;

import java.util.List;

@Data
public class TodoListResponseDTO {
    private List<TodoItemDTO> todos;
    private int total;
    private int skip;
    private int limit;
}
