package com.ada.aula_todo_list.repository;

import com.ada.aula_todo_list.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
