package tech.ada.java.curso_spring.api.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity //Entidade
public class Usuario {


    @Id //Toda entidade tem que ter a sua chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerado automaticamente. Precisa definir a estratégia de criação (IDENTITY = tem a ver com o schema)
    private Long id;

    private UUID uuid;

    //Validações
    //Que nao seja branco
    @NotBlank
    private String nome;
    @Email
    private String email;

    //Que seja uma data do passado
    @Past
    private LocalDate dob;

    public Usuario(UUID uuid, String nome, String email, LocalDate dob) {
        this.uuid = uuid;
        this.nome = nome;
        this.email = email;
        this.dob = dob;
    }
}
