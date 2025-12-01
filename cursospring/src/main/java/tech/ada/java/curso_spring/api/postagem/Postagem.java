package tech.ada.java.curso_spring.api.postagem;

import jakarta.persistence.*;
import lombok.*;
import tech.ada.java.curso_spring.api.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity //Entidade
public class Postagem {


    @Id //Toda entidade tem que ter a sua chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerado automaticamente. Precisa definir a estratégia de criação (IDENTITY = tem a ver com o schema)

    private UUID uuid;
    private String titulo;
    private String corpo;
    private LocalDateTime dataCriacao;

    //Muitos para um (muitas postagens para um autor. Banco de dados)
    @ManyToOne
    //Valor que irá definir a ligação (foreing key)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;
}
