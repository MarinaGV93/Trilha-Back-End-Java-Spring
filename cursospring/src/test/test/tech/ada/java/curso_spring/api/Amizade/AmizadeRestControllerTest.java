package tech.ada.java.curso_spring.api.Amizade;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class AmizadeRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AmizadeService amizadeService;

    @InjectMocks
    private AmizadeRestController amizadeRestController;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(amizadeRestController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setControllerAdvice(new tech.ada.java.curso_spring.api.exception.ApplicationControllerAdvice())
                .build();
    }

    @Test
    void postCriarAmizade_returnsAmizadeDTO() throws Exception {
        UUID a = UUID.randomUUID();
        UUID b = UUID.randomUUID();

        AmizadeDTO dto = new AmizadeDTO();
        dto.setiD(1L);

        when(amizadeService.criarAmizade(a, b)).thenReturn(dto);

        mockMvc.perform(post("/amizades/{a}/{b}", a, b))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @SuppressWarnings("null")
    @Test
    void getListarAmizades_returnsPage() throws Exception {
        AmizadeDTO dto = new AmizadeDTO();
        dto.setId(1L);
        when(amizadeService.listarTodos(any())).thenReturn(
                new PageImpl<>(List.of(dto), org.springframework.data.domain.PageRequest.of(0, 1), 1));

        mockMvc.perform(get("/amizades"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(1));
    }
}

