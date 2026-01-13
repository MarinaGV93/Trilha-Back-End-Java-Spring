package com.ada.aula_todo_list.repository;

import com.ada.aula_todo_list.domain.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Long> {
}