package tech.ada.java.curso_spring.api.Amizade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmizadeRepository extends JpaRepository<Amizade, Long> {

    boolean existsByUsuarioAAndUsuarioB(tech.ada.java.curso_spring.api.usuario.Usuario usuarioA, tech.ada.java.curso_spring.api.usuario.Usuario usuarioB);
}
