package tech.ada.java.curso_spring.api.usuario;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import tech.ada.java.cursospring.api.usuario.UsuarioDTO;

@ExtendWith(MockitoExtension.class)

public class UsuarioRestControllerTest {

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioRestController controller;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new tech.ada.java.curso_spring.api.exception.ApplicationControllerAdvice())
                .build();
    }

    @Test
    void getUsuarioByUuid_returnsUsuarioDto() throws Exception {
        UUID uuid = UUID.fromString("550e8400-e29b-41d4-a716-446655440001");
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUuid(uuid);
        dto.setNome("João Silva");
        dto.setEmail("joao.silva@email.com");
        dto.setDob(LocalDate.of(1990, 1, 1).toString());

        when(usuarioService.buscarPorUuidDTO(uuid)).thenReturn(dto);

        mockMvc.perform(get("/usuarios/{uuid}", uuid))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("João Silva"));
    }

    @SuppressWarnings("null")
    @Test
    void postCreateUsuario_returnsUsuarioEntity() throws Exception {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome("Criar");
        dto.setEmail("c@example.com");
        dto.setDob("1990-01-01");

        Usuario created = new Usuario(UUID.randomUUID(), "Criar", "c@example.com", LocalDate.of(1990, 1, 1));
        when(usuarioService.criarUsuario(any())).thenReturn(created);

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Criar"));
    }

}
