package tech.ada.java.curso_spring.api.exception;

import org.springframework.http.HttpStatus;

//Representar todas as exceções do projeto, e cada exceção especifica herda dela
//Como tem um metodo abstrato, a classe tambem tem q ser abstrata
public abstract class AbstractException extends RuntimeException {

    //Construtor que recebe uma mensagem personalizada
    protected AbstractException(String message) {
        super(message);
    }

    //Le qual é o status HTTP especifico daquela exceção
    public abstract HttpStatus getStatus();
}
