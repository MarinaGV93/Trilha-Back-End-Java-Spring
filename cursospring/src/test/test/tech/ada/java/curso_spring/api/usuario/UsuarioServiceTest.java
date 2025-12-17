package tech.ada.java.curso_spring.api.usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import tech.ada.java.curso_spring.api.exception.NaoEncontradoException;
import tech.ada.java.curso_spring.api.usuario.Usuario;


@ExtendWith(MockitoExtension.class)
@SuppressWarnings("null")
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void listarTodos_deveRetornarPageDeUsuarioDTO() {
        Usuario u = new Usuario(UUID.randomUUID(), "Teste", "t@example.com", LocalDate.of(1990, 1, 1));
        Page<Usuario> page = new PageImpl<>(Collections.singletonList(u));

        when(repository.findAll(Mockito.<Pageable>any())).thenReturn(page);
        when(modelMapper.map(Mockito.<Usuario>any(), eq(UsuarioDTO.class))).thenReturn(new UsuarioDTO());

        Page<UsuarioDTO> result = usuarioService.listarTodos(PageRequest.of(0, 10));

        assertEquals(1, result.getTotalElements());
        verify(repository).findAll(Mockito.<Pageable>any());
        verify(modelMapper).map(Mockito.<Usuario>any(), eq(UsuarioDTO.class));
    }

    @Test
    void buscarPorUuidDTO_deveRetornarDTO_quandoExistir() {
        UUID uuid = UUID.randomUUID();
        Usuario u = new Usuario(uuid, "Nome", "n@example.com", LocalDate.of(1991, 2, 2));

        when(repository.findByUuid(uuid)).thenReturn(Optional.of(u));
        when(modelMapper.map(u, UsuarioDTO.class)).thenReturn(new UsuarioDTO());

        UsuarioDTO dto = usuarioService.buscarPorUuidDTO(uuid);
        assertNotNull(dto);
        verify(repository).findByUuid(uuid);
    }

    @Test
    void buscarPorUuidDTO_deveLancarNaoEncontrado_quandoNaoExistir() {
        UUID uuid = UUID.randomUUID();
        when(repository.findByUuid(uuid)).thenReturn(Optional.empty());

        assertThrows(NaoEncontradoException.class, () -> usuarioService.buscarPorUuidDTO(uuid));
    }

    @Test
    void criarUsuario_devePersistirEvoltarEntidade() {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome("Criar");
        dto.setEmail("c@example.com");
        dto.setDob("1990-01-01");

        Usuario saved = new Usuario(UUID.randomUUID(), "Criar", "c@example.com", LocalDate.of(1990, 1, 1));
        when(repository.save(Mockito.<Usuario>any())).thenReturn(saved);

        Usuario result = usuarioService.criarUsuario(dto);
        assertNotNull(result);
        verify(repository).save(Mockito.<Usuario>any());
    }

    @Test
    void atualizarUsuario_devePreservarIdExistente() {
        UUID uuid = UUID.randomUUID();
        Usuario existente = new Usuario(uuid, "Existente", "e@example.com", LocalDate.of(1990, 1, 1));
        existente.setId(99L);

        Usuario novo = new Usuario(uuid, "Novo", "n@example.com", LocalDate.of(1992, 3, 3));
        novo.setId(null);

        when(repository.findByUuid(uuid)).thenReturn(Optional.of(existente));
        when(repository.save(Mockito.<Usuario>any())).thenAnswer(inv -> inv.getArgument(0));

        Usuario result = usuarioService.atualizarUsuario(uuid, novo);
        assertEquals(99L, result.getId());
        verify(repository).save(Mockito.<Usuario>any());
    }
}