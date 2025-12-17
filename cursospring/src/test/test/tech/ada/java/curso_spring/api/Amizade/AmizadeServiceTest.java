package tech.ada.java.curso_spring.api.Amizade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import tech.ada.java.curso_spring.api.exception.AmizadeInvalidadeBusinessException;
import tech.ada.java.curso_spring.api.usuario.Usuario;
import tech.ada.java.curso_spring.api.usuario.UsuarioService;


@ExtendWith(MockitoExtension.class) //Colocar mock
@SuppressWarnings("null")
class AmizadeServiceTest {

    //Dependências
    @Mock
    private AmizadeRepository amizadeRepository;
    @Mock
    private UsuarioService usuarioService;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks //Injetar os mocks no serviços
    private AmizadeService amizadeService;

    //Teste de sucesso
    @Test
    @DisplayName("Sucesso") //Colocar a forma (texto) que quer que apareça no relatório de execuções
    void criarAmizade() {

        //Cenário
        UUID usuarioA = UUID.fromString("23e4567-e89b-12d3-a456-426614174000");
        UUID usuarioB = UUID.fromString("23e4567-e89b-12d3-a456-426614174001");

        //Mockar
        Mockito
                //Quando
                .when(this.usuarioService.buscarPorUuid(
                        //Passando qualquer UUID
                        Mockito.<UUID>any()))
                //Retorna
                .thenReturn(
                        //Um objeto novo de Usuário
                        new Usuario());
        Mockito.when(this.amizadeRepository.save(Mockito.<Amizade>any())).thenReturn(new Amizade());
        Mockito.when(this.modelMapper.map(Mockito.<Amizade>any(), Mockito.any())).thenReturn(new  AmizadeDTO());

        //Ação
        AmizadeDTO amizadeDTO = this.amizadeService.criarAmizade(usuarioA, usuarioB);

        //Validação
        //Verifique se são iguais
        Assertions.assertEquals(
                //O que é esperado
                //Um objeto Amizade vazio
                new AmizadeDTO(),

                //Onde é esperado
                amizadeDTO);
        // Obs: Para funcionar precisa implementar equals and hashcode em AmizadeDTO
    }


    //Testar falha ao criar uma solicitação de amizade
    @Test
    void falhaCriarAmizade() {

        //- Cenário
        //Pegar os UUIDs
        UUID usuarioA = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
        UUID usuarioB = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");

    //- Ação
        //Vai ter uma exceção
//        this.amizadeService.criarAmizade(usuarioA, usuarioB);

    //- Validação
        //JUNIT
        //Que lance a exceção
        Assertions.assertThrows(AmizadeInvalidadeBusinessException.class,
                //Ação que dispara essa exceção
                //Chamada ao criarAmizade
                () -> this.amizadeService.criarAmizade(usuarioA, usuarioB)
                );
    }

    @Test
    void testListarTodosReturnsPageOfAmizadeDTO() {
        Usuario usuarioA = new Usuario();
        Usuario usuarioB = new Usuario();
        Amizade amizade = new Amizade(usuarioA, usuarioB);
        List<Amizade> amizades = Arrays.asList(amizade);
        Page<Amizade> page = new PageImpl<>(amizades);
        when(amizadeRepository.findAll(Mockito.<Pageable>any())).thenReturn(page);
        when(modelMapper.map(Mockito.<Amizade>any(), eq(AmizadeDTO.class))).thenReturn(new AmizadeDTO());

        Page<AmizadeDTO> result = amizadeService.listarTodos(PageRequest.of(0, 10));

        assertEquals(1, result.getTotalElements());
        assertNotNull(result.getContent().get(0));

        verify(amizadeRepository).findAll(Mockito.<Pageable>any());
        verify(modelMapper, times(1)).map(Mockito.<Amizade>any(), eq(AmizadeDTO.class));
    }

    @Test
    void testConvertToDtoMapsCorrectly() {
        Usuario usuarioA = new Usuario();
        Usuario usuarioB = new Usuario();
        Amizade amizade = new Amizade(usuarioA, usuarioB);
        when(modelMapper.map(Mockito.<Amizade>any(), eq(AmizadeDTO.class))).thenReturn(new AmizadeDTO());

        AmizadeDTO dto = amizadeService.convertToDto(amizade);

        assertNotNull(dto);
        verify(modelMapper).map(any(Amizade.class), eq(AmizadeDTO.class));
    }

    @Test
    void testCriarAmizadeThrowsExceptionForSameUser() {
        UUID uuid = UUID.randomUUID();
        assertThrows(AmizadeInvalidaBusinessException.class, () -> {
            amizadeService.criarAmizade(uuid, uuid);
        });
    }

    @Test
    void testCriarAmizadeCreatesAndReturnsDTO() {
        UUID uuidA = UUID.randomUUID();
        UUID uuidB = UUID.randomUUID();
        Usuario usuarioA = new Usuario();
        Usuario usuarioB = new Usuario();
        Amizade amizade = new Amizade(usuarioA, usuarioB);

        when(usuarioService.buscarPorUuid(uuidA)).thenReturn(usuarioA);
        when(usuarioService.buscarPorUuid(uuidB)).thenReturn(usuarioB);
        when(amizadeRepository.save(isA(Amizade.class))).thenReturn(amizade);
        when(modelMapper.map(Mockito.<Amizade>any(), eq(AmizadeDTO.class))).thenReturn(new AmizadeDTO());

        AmizadeDTO dto = amizadeService.criarAmizade(uuidA, uuidB);

        assertNotNull(dto);
        verify(usuarioService).buscarPorUuid(uuidA);
        verify(usuarioService).buscarPorUuid(uuidB);
        verify(amizadeRepository).save(isA(Amizade.class));
        verify(modelMapper).map(Mockito.<Amizade>any(), eq(AmizadeDTO.class));
    }
}
