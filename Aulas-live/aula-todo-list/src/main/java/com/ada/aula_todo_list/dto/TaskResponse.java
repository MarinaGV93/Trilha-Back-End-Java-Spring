package com.ada.aula_todo_list.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TaskResponse {

    //Coloca os atributos da forma simples que vai receber os dados
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private String status;
    private boolean isPublic;
    private Long ownerId;
    private List<Long> participantIds;
}
