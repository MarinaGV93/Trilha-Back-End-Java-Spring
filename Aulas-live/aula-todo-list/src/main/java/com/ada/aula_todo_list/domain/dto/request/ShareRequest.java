package com.ada.aula_todo_list.domain.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class ShareRequest {
    private List<Long> participantIds;
}
