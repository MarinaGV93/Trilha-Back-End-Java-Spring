//Classe de componente
//Depois de passar pela analise do request, ele vai dizer para qual codigo deve ir

package com.ada.aula_todo_list.service.creation;

import com.ada.aula_todo_list.domain.Action;
import com.ada.aula_todo_list.domain.dto.request.ActionCreateRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionCreationFactory {

    //Lista de estrategias
    private final List<ActionCreationStrategy> strategies;

    public ActionCreationFactory(List<ActionCreationStrategy> strategies) {
        this.strategies = strategies;
    }

    public Action create(ActionCreateRequest request) {
        return strategies.stream()
                .filter(strategy
                        //Verifica se tem fase ou nao
                        -> strategy.supports(request))
                //Pega o primeiro que passou
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "No ActionCreationStrategy found for request"
                ))
                //Chama o create
                .create(request);
    }
}
