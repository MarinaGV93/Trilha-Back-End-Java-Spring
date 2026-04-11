import org.calculadora.Calculadora;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.Parameter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTest {
    private Calculadora calculadora;

    //Antes de cada teste
    //Arrange (Preparo)
    @BeforeEach
    void configurar() {
        calculadora = new Calculadora();
    }

    @Test
    void testeSoma() {
        //Separando em passos

        //Act (Ação)
        int soma = calculadora.somar(2, 3);

        //Assert (Verificação/Validação)
        assertEquals(5, soma, "Teste de soma falhou");
    }

    @Test
    void testeSubtracao() {
        assertEquals(1, calculadora.subtrair(3, 2), "Teste de subtração falhou");
    }

    @Test
    void testeMultiplicacao() {
        assertEquals(6, calculadora.multiplicar(2, 3), "Teste de multiplicação falhou");
    }

    @Test
    void testeDivisao() {
        assertEquals(2, calculadora.dividir(4, 2), "Teste de divisão falhou");
    }

    @Test
    void testeDivisaoPorZero() {
        Exception excecao = assertThrows(IllegalArgumentException.class , () -> calculadora.dividir(4, 0));
        assertEquals("Divisão por zero não é permitido", excecao.getMessage());
    }

    //Teste parametrizado - vai poder reunir informações completas e fazer um teste unico para processar todas essas informações, para nao precisa criar um teste para cada caso. Pode juntar uma quantidade enorme de informaçoes e fazer um teste unico para processar todas essas informaçoes
    @ParameterizedTest
    //Separar por virgulas
    @CsvSource({
            //a, b, resultadoEsperado
            "1, 1, 2",
            "2, 3, 5",
            //Ira falhar
            "5, 5, 11",
            "7, 2, 9"
    })
    void testeSomaComParametros(int a, int b, int resultadoEsperado) {
        assertEquals(resultadoEsperado, calculadora.somar(a, b), "Teste parametrizado de soma falhou");
    }

    //Depois de cada teste
    @AfterEach
    void limpar() {
        calculadora = null;
    }
}
