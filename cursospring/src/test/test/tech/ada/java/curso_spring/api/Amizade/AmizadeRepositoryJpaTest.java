package tech.ada.java.curso_spring.api.Amizade;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import tech.ada.java.curso_spring.api.usuario.Usuario;
import tech.ada.java.curso_spring.api.usuario.UsuarioRepository;

@DataJpaTest
@ActiveProfiles("postgres")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AmizadeRepositoryJpaTest {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AmizadeRepository amizadeRepository;

    @Test
    void findAmizade() {
        // cenário
        UUID uuidA = UUID.fromString("550e8400-e29b-41d4-a716-446655440001");
        UUID uuidB = UUID.fromString("550e8400-e29b-41d4-a716-446655440002");

        // ação
        Usuario usuarioA = usuarioRepository.findByUuid(uuidA)
                .orElseThrow(
                        () -> new IllegalStateException("Usuario A com uuid " + uuidA + " nao encontrado no banco"));

        Usuario usuarioB = usuarioRepository.findByUuid(uuidB)
                .orElseThrow(
                        () -> new IllegalStateException("Usuario B com uuid " + uuidB + " nao encontrado no banco"));

        boolean exists = amizadeRepository.existsByUsuarioAAndUsuarioB(usuarioA, usuarioB);

        Assertions.assertTrue(exists, String.format("Deve existir amizade entre %s e %s", uuidA, uuidB));
    }
}

