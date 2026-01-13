package com.ada.aula_todo_list.domain.dto.external;

import lombok.Data;

@Data
public class TodoItem {

    private Long id;
    private String todo;
    private boolean completed;
    private Long userId;
}
