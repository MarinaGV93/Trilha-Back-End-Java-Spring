package tech.ada.java.curso_spring.api.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Fazer a comunicação

@Repository
public interface UsuarioRepository extends JpaRepository<
        //Entidade
        Usuario,
        //Tipo
        Long
        > {

    //Opcional
    Optional<Usuario> findByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);

    //Consulta personalizada (de modificação). Linguagem JPQL (linguagem para fazer consulta de dados ja Orientada ao Java), permite que trabalhe com os objetos mapeados
    @Modifying
    @Query("UPDATE Usuario u SET u.nome = :nome WHERE u.uuid = :uuid"
            //Para usar uma SQL nativa
//            , nativeQuery = true
    )
    void updateNome(@Param("uuid") UUID uuid, @Param("nome") String nome);
}
