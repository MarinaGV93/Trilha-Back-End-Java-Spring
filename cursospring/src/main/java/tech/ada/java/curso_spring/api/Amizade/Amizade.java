package tech.ada.java.curso_spring.api.Amizade;

import jakarta.persistence.*;
import lombok.*;
import tech.ada.java.curso_spring.api.usuario.Usuario;

//Representa um relacionamento entre 2 usuarios
//A amizade só pode existir desde que os usuarios A e B sejam diferentes

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Amizade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario a")
    private Usuario usuarioA;

    @ManyToOne
    @JoinColumn(name = "usuario b")
    private Usuario usuarioB;

    public Amizade(Usuario usuarioA, Usuario usuarioB) {
        this.usuarioA = usuarioA;
        this.usuarioB = usuarioB;
    }
}
