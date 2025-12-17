package tech.ada.java.curso_spring;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//Teste de integração
@SpringBootTest(classes = tech.ada.java.curso_spring.CursoSpringApplication.class)
class CursoSpringApplicationTests {

    //Testa a sanidade da aplicação (saúde)
    @Test
    void contextLoads() {
    }

}
