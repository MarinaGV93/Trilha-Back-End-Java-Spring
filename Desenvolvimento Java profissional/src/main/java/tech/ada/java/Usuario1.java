package tech.ada.java;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

//Lombok
//Coloca sempre em cima de onde quer aplicar
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Usuario1 {
    // Criar dominio
    private UUID uuid;
    private String nome;
    private String email;

    //Data de nascimento
    private LocalDate  dob;

}
