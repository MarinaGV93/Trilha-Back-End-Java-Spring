package tech.ada.java.curso_spring.api.Amizade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.ada.java.curso_spring.api.usuario.Usuario;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmizadeDTO {

    private Long id;
    private Usuario usuarioA;
    private Usuario usuarioB;
}
