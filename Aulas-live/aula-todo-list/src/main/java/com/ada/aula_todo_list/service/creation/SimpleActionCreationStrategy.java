package com.ada.aula_todo_list.service.creation;

import com.ada.aula_todo_list.domain.Action;
import com.ada.aula_todo_list.domain.dto.request.ActionCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class SimpleActionCreationStrategy implements ActionCreationStrategy {
    //Met odo para saber se tem fases ou nao
    @Override
    public boolean supports(ActionCreateRequest request) {
        return request.getPhases() == null || request.getPhases().isEmpty();
    }

    @Override
    public Action create(ActionCreateRequest request) {
        Action action = new Action();
        action.setName(request.getName());
        action.setResponsible(request.getResponsible());
        action.setStartDate(request.getStartDate());
        action.setPlannedEndDate(request.getPlannedEndDate());
        action.setEffectiveEndDate(request.getEffectiveEndDate());
        action.setTotalCost(request.getTotalCost());
        action.setParticipants(request.getParticipants());

        return action;
    }
}

