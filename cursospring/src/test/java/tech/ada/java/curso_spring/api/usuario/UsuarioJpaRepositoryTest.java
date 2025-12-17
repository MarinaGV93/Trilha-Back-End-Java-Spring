package tech.ada.java.curso_spring.api.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

//Testar apenas a camada de dados
@DataJpaTest
//Teste somente de web
//@WebMvcTest
class UsuarioJpaRepositoryTest {

    @Autowired
    private UsuarioJpaRepository repository;

    @Test
    void findByUuid() {
        //Cenário
        UUID uuid = UUID.fromString("1234");

        //Ação
        //Chamar o findByUuid que retorna o Optional usuario
        Optional<Usuario> usuario = this.repository.findByUuid(uuid);

        //Validação
        //Verifica se o usuario esta presente
        Assertions.assertTrue(usuario.isPresent());

        //Verificar se o nome esperado (""), é de fato o nome desse usuario retornado
        Assertions.assertEquals("Marina", usuario.get().getNome());
    }
}