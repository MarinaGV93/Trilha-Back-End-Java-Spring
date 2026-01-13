package com.ada.aula_todo_list.controller;

import com.ada.aula_todo_list.domain.Action;
import com.ada.aula_todo_list.domain.dto.request.ActionCreateRequest;
import com.ada.aula_todo_list.service.ActionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actions")
public class ActionController {

    private final ActionService service;

    public ActionController(ActionService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Action create(@RequestBody ActionCreateRequest request) {
        return service.create(request);
    }
}