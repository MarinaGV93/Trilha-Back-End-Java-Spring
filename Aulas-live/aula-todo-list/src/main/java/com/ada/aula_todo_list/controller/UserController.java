package com.ada.aula_todo_list.controller;

import com.ada.aula_todo_list.entity.User;
import com.ada.aula_todo_list.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    //localhost:8080/api/users
    @GetMapping
    public List<User> all() {
        return userRepository.findAll();
    }
}
