package tech.ada.java.curso_spring.api.usuario;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.java.curso_spring.api.exception.NaoEncontradoException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioJpaRepository;

    //Retorna um usuário baseado no UUID
    public Usuario buscarPorUuid(@NotNull UUID usuarioA) {
        return usuarioJpaRepository.findByUuid(usuarioA).orElseThrow(() -> new NaoEncontradoException("Usuário Não encontrado"));
    }
    private List<Usuario> buscaListaPorUuid(@NotNull UUID usuarioA){
        return usuarioJpaRepository.findByUuidIn(List.of(usuarioA));
    }
}
