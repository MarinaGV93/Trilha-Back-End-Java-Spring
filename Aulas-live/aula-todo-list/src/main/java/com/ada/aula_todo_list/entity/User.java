package com.ada.aula_todo_list.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
