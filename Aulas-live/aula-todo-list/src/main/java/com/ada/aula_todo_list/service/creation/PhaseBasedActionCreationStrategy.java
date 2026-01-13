package com.ada.aula_todo_list.service.creation;

import com.ada.aula_todo_list.domain.Action;
import com.ada.aula_todo_list.domain.Phase;
import com.ada.aula_todo_list.domain.dto.request.ActionCreateRequest;
import com.ada.aula_todo_list.domain.dto.request.PhaseCreateRequest;
import com.ada.aula_todo_list.service.ActionAggregationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class PhaseBasedActionCreationStrategy implements ActionCreationStrategy {

    private final ActionAggregationService aggregationService;

    @Override
    public boolean supports(ActionCreateRequest request) {
        return request.getPhases() != null && !request.getPhases().isEmpty();
    }

    @Override
    public Action create(ActionCreateRequest request) {

        //Cria um objeto
        Action action = new Action();
        //Seta o nome do objeto
        action.setName(request.getName());

        //Varre quando tem fases
        var phases = request.getPhases().stream()
                .map(phaseCreateRequest -> toPhase(phaseCreateRequest, action))
                .toList();

        //Seta as fases nesse action
        action.setPhases(phases);

        //Total do action
        aggregationService.aggregate(action);

        //Retorna o action
        return action;
    }

    //Cria a fase
    private Phase toPhase(PhaseCreateRequest request, Action action) {

        Phase phase = new Phase();
        phase.setPhaseName(request.getName());
        phase.setResponsible(request.getResponsible());
        phase.setStartDate(request.getStartDate());
        phase.setPlannedEndDate(request.getPlannedEndDate());
        phase.setEffectiveEndDate(request.getEffectiveEndDate());
        phase.setCost(request.getCost());
        phase.setParticipants(request.getParticipants());
        phase.setAction(action);

        return phase;
    }

}
