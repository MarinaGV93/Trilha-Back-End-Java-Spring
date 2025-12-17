package tech.ada.java.curso_spring.api.Amizade;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;

public class SerializationDebugTest {

    @Test
    void serializePageImpl() throws Exception {
        AmizadeDTO dto = new AmizadeDTO();
        dto.setId(1L);

        @SuppressWarnings("null")
        PageImpl<AmizadeDTO> page = new PageImpl<>(List.of(dto),
                org.springframework.data.domain.PageRequest.of(0, 1), 1);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(page);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
