package com.ada.aula_todo_list.repository;

import com.ada.aula_todo_list.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
