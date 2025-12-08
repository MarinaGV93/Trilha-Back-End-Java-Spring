package tech.ada.java.curso_spring.api.Amizade;

import org.springframework.http.HttpStatus;
import tech.ada.java.curso_spring.api.exception.AbstractException;

//Exceção
public class AmizadeInvalidaBusinessException extends AbstractException {
    public AmizadeInvalidaBusinessException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
