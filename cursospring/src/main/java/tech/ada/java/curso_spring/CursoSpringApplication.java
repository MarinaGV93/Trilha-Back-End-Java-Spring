package tech.ada.java.curso_spring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//A junção de 3 aplicações. Quando for rodar o projeto, vai pegar todas as anotações para saber o que ele vai fazer no ambiente
@SpringBootApplication
public class CursoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringApplication.class, args);
    }

    //Criar um bean específico (explicitamente)
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
