package com.ada.aula_todo_list.domain;

import com.ada.aula_todo_list.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Vai dizer que o Id da task vai ser gerado automaticamente
    private Long id; //Vao virar colunas da tabela
    private String title;
    @Column(length = 2000) //O tamanho do campo
    private String description;
//    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING) //Para salvar no tipo string
    private Status status;
    private boolean isPublic; //Ve se é pública ou privada. As privadas só são visualizadas pelo dono (que criou a task)

    @ManyToOne //Muitos (tasks) para 1 (usuario)
    private User owner; //O dono da task

    @ManyToMany //Muitos (usuarios) para muitos (tasks)
    @JoinTable(name = "task_participants", //Nome da tabela
            joinColumns =
            //Uma coluna com nome task_id
            @JoinColumn(name = "task_id"),
    inverseJoinColumns =
    //Uma coluna com nome user_id
    @JoinColumn(name = "user_id")) //Cria outra tabela só para ter os participantes. Tabela de relacionamento
    private List<User> participants = new ArrayList<>(); //Lista de participantes. Pode compartilhar com outros participantes

}