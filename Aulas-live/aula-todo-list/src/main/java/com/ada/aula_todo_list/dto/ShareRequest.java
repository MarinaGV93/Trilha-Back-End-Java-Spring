package com.ada.aula_todo_list.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShareRequest {
    private List<Long> participantIds;
}
