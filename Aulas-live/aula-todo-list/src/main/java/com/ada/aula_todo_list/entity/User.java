package com.ada.aula_todo_list.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity //Mostra que isso vai ser uma classe de banco de dados
@Table(name = "users") //Virar uma tabela. Pode passar o nome da tabela (se for diferente do nome da classe)
@Data //Getters e Setters. Funciona melhor, mas pode ter um bug se colocar testes unitários
public class User {

    @Id //Precisa de uma chave única
    //Esses atributos vão virar colunas no banco de dados
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
