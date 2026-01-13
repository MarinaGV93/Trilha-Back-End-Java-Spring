package com.ada.aula_todo_list.domain.dto.request;

import com.ada.aula_todo_list.domain.Employee;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
public class PhaseCreateRequest {

    private String name;
    private Employee responsible;
    private LocalDate startDate;
    private LocalDate plannedEndDate;
    private LocalDate effectiveEndDate;
    private BigDecimal cost;
    private Set<Employee> participants;

}
