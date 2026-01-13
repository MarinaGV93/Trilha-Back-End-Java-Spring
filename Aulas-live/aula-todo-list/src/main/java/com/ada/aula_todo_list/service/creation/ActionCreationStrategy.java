//Responsavel por saber qual o codigo de criação deve mandar

package com.ada.aula_todo_list.service.creation;


import com.ada.aula_todo_list.domain.Action;
import com.ada.aula_todo_list.domain.dto.request.ActionCreateRequest;

public interface ActionCreationStrategy {

    //Met odo que vai receber o request
    boolean supports(ActionCreateRequest request);

    //Cria uma ação, independente se for fase ou nao
    Action create(ActionCreateRequest request);
}
