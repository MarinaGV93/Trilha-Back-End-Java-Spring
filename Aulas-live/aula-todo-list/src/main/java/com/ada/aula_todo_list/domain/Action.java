//Ações
//Vai controlar 'mini projetos'

package com.ada.aula_todo_list.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private Employee responsible;

    private LocalDate startDate;
    private LocalDate plannedEndDate;
    private LocalDate effectiveEndDate;
    //Total do custo
    private BigDecimal totalCost = BigDecimal.ZERO;

    //Lista participantes
    @ManyToMany
    private Set<Employee> participants = new HashSet<>();

    //Lista de fases
    @OneToMany(mappedBy = "action", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Phase> phases = new ArrayList<>();
}