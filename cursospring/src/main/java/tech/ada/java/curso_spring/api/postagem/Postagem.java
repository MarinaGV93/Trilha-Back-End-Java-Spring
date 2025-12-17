package tech.ada.java.curso_spring.api.postagem;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.ada.java.curso_spring.api.usuario.Usuario;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity //Entidade
@Table(name = "postagens")
public class Postagem {


    @Id //Toda entidade tem que ter a sua chave primaria
    @GeneratedValue //Gerado automaticamente. Precisa definir a estratégia de criação (IDENTITY = tem a ver com o schema)

    private UUID uuid;
    private String titulo;
    private String corpo;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    //Muitos para um (muitas postagens para um autor. Banco de dados)
    @ManyToOne
    @JoinColumn(name = "usuario_id") //Valor que irá definir a ligação (foreing key)
    private Usuario autor;
}
