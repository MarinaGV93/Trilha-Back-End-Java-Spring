package tech.ada.java.curso_spring.api.usuario;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

//@WebMvcTest //Teste somente de web
//Testar apenas a camada de dados
@DataJpaTest
@ActiveProfiles("postgres")
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UsuarioRepositoryJpaTest {

    @Autowired
    private UsuarioRepository repository;

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