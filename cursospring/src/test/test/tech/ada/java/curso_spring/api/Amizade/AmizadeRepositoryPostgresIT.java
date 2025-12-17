package tech.ada.java.curso_spring.api.Amizade;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tech.ada.java.curso_spring.api.usuario.Usuario;
import tech.ada.java.curso_spring.api.usuario.UsuarioRepository;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("postgres")
public class AmizadeRepositoryPostgresIT {

    @Autowired
    private AmizadeRepository aRepository;

    @Autowired
    private UsuarioRepository uRepository;

    @Test
    void findAmizadeExists() {
        // cenário: João (uuid ...001) e Maria (...002) devem existir e ter amizade
        // (1,2)
        UUID uuidA = UUID.fromString("550e8400-e29b-41d4-a716-446655440001");
        UUID uuidB = UUID.fromString("550e8400-e29b-41d4-a716-446655440002");

        Optional<Usuario> a = this.uRepository.findByUuid(uuidA);
        Optional<Usuario> b = this.uRepository.findByUuid(uuidB);

        assertTrue(a.isPresent() && b.isPresent(), "Usuários de teste devem existir");

        boolean exists = this.aRepository.existsByUsuarioAAndUsuarioB(a.get(), b.get());
        assertTrue(exists, "Amizade entre João e Maria deve existir");
    }
}
