package tech.ada.java.curso_spring.api.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.ada.java.curso_spring.api.exception.NaoEncontradoException;

import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    void buscarPorUuid() {
        UUID uuid = UUID.fromString("1234");
        this.usuarioService.buscarPorUuid(uuid);
        //Verificar se eh verdade que esse usuario é um objeto nao nulo
        Assertions.assertTrue(Objects.nonNull(usuario));

        @Test
        @DisplayName("buscarPorUuid - falha")
        void falha(){
            UUID uuid = UUID.fromString("123");
            Assertions.assertTrue(NaoEncontradoException.class, () -> this.usuarioService.buscarPorUuid(uuid));
        }
    }
}