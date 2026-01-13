package com.ada.aula_todo_list.repository;

import com.ada.aula_todo_list.domain.Phase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhaseRepository extends JpaRepository<Phase, Long> {
}