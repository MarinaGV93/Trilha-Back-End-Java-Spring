package com.ada.aula_todo_list.domain.dto.external;

import lombok.Data;

@Data
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String email;
}
