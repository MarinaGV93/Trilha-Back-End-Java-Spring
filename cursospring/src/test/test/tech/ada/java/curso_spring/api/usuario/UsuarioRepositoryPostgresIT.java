package tech.ada.java.curso_spring.api.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tech.ada.java.curso_spring.api.exception.NaoEncontradoException;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("postgres")
public class UsuarioRepositoryPostgresIT {

    @Autowired
    private UsuarioService service;

    @Test
    @DisplayName("Buscar por UUID - sucesso")
    void buscarPorUuid() {
        // Criar e persistir um usuário com UUID fixo, então buscar via serviço
        UUID uuid = UUID.fromString("550e8400-e29b-41d4-a716-446655440001");
        UsuarioDTO usuario = this.service.buscarPorUuid(uuid);
        assertNotNull(usuario);
        assertEquals("João Silva", usuario.getNome());
        assertEquals("joao.silva@email.com", usuario.getEmail());
    }

    @Test
    @DisplayName("Buscar por UUID - não encontrado")
    void buscarPorUuidNaoEncontrado_deveLancarNaoEncontradoException() {
        UUID uuidNaoExistente = UUID.randomUUID();

        Assertions.assertThrows(
                NaoEncontradoException.class,
                () -> this.service.buscarPorUuidDTO(uuidNaoExistente));
    }
}

