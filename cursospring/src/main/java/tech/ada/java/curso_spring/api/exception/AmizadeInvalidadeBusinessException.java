package tech.ada.java.curso_spring.api.exception;

import org.springframework.http.HttpStatus;

public class AmizadeInvalidadeBusinessException extends AbstractException{

    public AmizadeInvalidadeBusinessException(String message){
        super(message);
    }

    @Override
    public HttpStatus getStatus(){
        return HttpStatus.BAD_REQUEST;
    }
}
