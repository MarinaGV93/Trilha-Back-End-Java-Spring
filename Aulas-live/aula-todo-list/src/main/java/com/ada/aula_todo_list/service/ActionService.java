package com.ada.aula_todo_list.service;

import com.ada.aula_todo_list.domain.Action;
import com.ada.aula_todo_list.domain.dto.request.ActionCreateRequest;
import com.ada.aula_todo_list.repository.ActionRepository;
import com.ada.aula_todo_list.service.creation.ActionCreationFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActionService {

    private final ActionRepository actionRepository;
    private final ActionCreationFactory actionCreationFactory;

    public Action create(ActionCreateRequest request) {
        Action action = actionCreationFactory.create(request);
        return actionRepository.save(action);

    }


}

