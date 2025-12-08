package tech.ada.java.curso_spring.api.Amizade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import tech.ada.java.curso_spring.api.usuario.Usuario;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class) //Colocar mock
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
        UUID usuarioA = UUID.fromString("123");
        UUID usuarioB = UUID.fromString("456");

        //Mockar
        Mockito
                //Quando
                .when(this.usuarioService.buscarPorUuid(
                        //Passando qualquer UUID
                        Mockito.any()))
                //Retorna
                .thenReturn(
                        //Um objeto novo de Usuário
                        new Usuario());
        Mockito.when(this.usuarioRepository.save(Mockito.any())).thenReturn(new Amizade());
        Mockito.when(this.modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(new  AmizadeDTO());

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
    }


    //Testar falha ao criar uma solicitação de amizade
    @Test
    void falhaCriarAmizade() {

        //- Cenário
        //Pegar os UUIDs
        UUID usuarioA = UUID.fromString("123");
        UUID usuarioB = UUID.fromString("123");

    //- Ação
        //Vai ter uma exceção
//        this.amizadeService.criarAmizade(usuarioA, usuarioB);

    //- Validação
        //JUNIT
        //Que lance a exceção
        Assertions.assertThrows(AmizadeInvalidaBusinessException.class,
                //Ação que dispara essa exceção
                //Chamada ao criarAmizade
                () -> this.amizadeService.criarAmizade(usuarioA, usuarioB)
                );
    }
}
