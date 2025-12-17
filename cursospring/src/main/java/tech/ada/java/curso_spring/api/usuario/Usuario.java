package tech.ada.java.curso_spring.api.usuario;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity //Entidade
@Table(name = "usuarios")
public class Usuario {


    @Id //Toda entidade tem que ter a sua chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerado automaticamente. Precisa definir a estratégia de criação (IDENTITY = tem a ver com o schema)
    private Long id;

    private UUID uuid;
    //Validações
    @NotBlank //não pode ser nulo ou vazio
    private String nome;
    @Email
    private String email;
    @Past //Que seja uma data do passado
    private LocalDate dob;

    public Usuario(UUID uuid, @NotNull String nome, @Email String email, @Past LocalDate dob) {
        this.uuid = uuid;
        this.nome = nome;
        this.email = email;
        this.dob = dob;
    }
}
