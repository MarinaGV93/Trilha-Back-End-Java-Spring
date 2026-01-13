package com.ada.aula_todo_list.domain.dto.external;

import lombok.Data;

import java.util.List;

@Data
public class TodoListResponse {

    private List<TodoItem> todos;
    private int total;
    private int skip;
    private int limit;
}
