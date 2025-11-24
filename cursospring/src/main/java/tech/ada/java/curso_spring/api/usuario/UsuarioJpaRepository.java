package tech.ada.java.curso_spring.api.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

//Fazer a comunicação

@Repository
public interface UsuarioJpaRepository extends JpaRepository<
        //Entidade
        Usuario,
        //Tipo
        Long
        > {

    //Opcional
    Optional<Usuario> findAllByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);
}
