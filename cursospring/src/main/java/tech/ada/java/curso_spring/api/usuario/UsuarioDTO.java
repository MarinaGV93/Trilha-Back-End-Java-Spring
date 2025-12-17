package tech.ada.java.cursospring.api.usuario;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Schema(description = "DTO para criação de usuário")
public class UsuarioDTO {
    @Schema(description = "UUID do usuário", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID uuid;

    @Schema(description = "Nome do usuário", example = "Usuário Exemplar")
    private String nome;

    @Schema(description = "Email do usuário", example = "user@example.com")
    private String email;

    @Schema(description = "Data de nascimento", example = "2000-01-01")
    private String dob;
}