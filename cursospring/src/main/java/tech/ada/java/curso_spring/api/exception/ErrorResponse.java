package tech.ada.java.curso_spring.api.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

//Criar um objeto para indicar as informações de erro para adicionar essas informações
@Getter
@Setter
public class ErrorResponse {

    //Qual foi a classe de exceção (exceção originaria)
    private Class<?> exceptionClass;

    //Qual é o status HTTP
    private HttpStatus httpStatus;

    //Uma mensagem
    private String message;

    //Qual foi a data/hora que aconteceu o problema
    private LocalDateTime thrownAt;

    public <T> ErrorResponse(Class<?> exceptionClass, HttpStatus httpStatus, String message) {
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
        this.message = message;
        this.thrownAt = LocalDateTime.now();
    }
}
