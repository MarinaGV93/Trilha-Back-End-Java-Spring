package tech.ada.java.curso_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//A junção de 3 aplicações. Quando for rodar o projeto, vai pegar todas as anotações para saber o que ele vai fazer no ambiente
@SpringBootApplication
public class CursoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringApplication.class, args);
    }

}
