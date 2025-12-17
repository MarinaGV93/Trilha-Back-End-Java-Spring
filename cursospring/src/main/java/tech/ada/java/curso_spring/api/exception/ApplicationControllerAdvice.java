package tech.ada.java.curso_spring.api.exception;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.log4j.Log4j2;

//Vai capturar todas as exceções
@ControllerAdvice
@Log4j2 //Para o objeto com log
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler {

    //Vai transformar tudo em um Responde Entity

    public static final String METHOD_ARGUMENT_NOT_VALID_ERROR_MESSAGE = "Campo inválido: '%s'. Causa: '%s'.";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        log.error(ex.getMessage(), ex);
//        logger.error(ex.getMessage(), ex);
        String errorMessage = getErrorMessages(ex.getBindingResult());
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final ErrorResponse errorResponse = new ErrorResponse(ex.getClass(), httpStatus, errorMessage);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    private String getErrorMessages( BindingResult bindingResult) {
        return Stream.concat(
                bindingResult.getFieldErrors().stream().map(this::getMethodArgumentsNotValidErrorMessage),
                bindingResult.getGlobalErrors().stream().map(this::getMethodArgumentsNotValidErrorMessage)
        ).collect(Collectors.joining(", "));
    }

    private String getMethodArgumentsNotValidErrorMessage( FieldError error) {
        return String.format(METHOD_ARGUMENT_NOT_VALID_ERROR_MESSAGE, error.getField() , error.getDefaultMessage());
    }

    private String getMethodArgumentsNotValidErrorMessage(ObjectError error) {
        return String.format(METHOD_ARGUMENT_NOT_VALID_ERROR_MESSAGE, error.getObjectName(), error.getDefaultMessage());
    }

    @SuppressWarnings("null")
    @ExceptionHandler(value = NaoEncontradoException.class) //Caso aconteça a exceção de nao encontrado
    public ResponseEntity<ErrorResponse> recursoNaoEncontradoExceptionHandler( NaoEncontradoException ex) {
        HttpStatus status = ex.getStatus() != null ? ex.getStatus() : HttpStatus.NOT_FOUND;
        final ErrorResponse errorResponse = new ErrorResponse(ex.getClass(), status, ex.getMessage());
        log.debug(ex.getMessage(), ex);
        return new ResponseEntity<>(errorResponse, status);
    }

    //Qualquer outra exceção que nao foi capturado
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> defaultExceptionHandler(Exception ex) {
        final ErrorResponse errorResponse = new ErrorResponse(ex.getClass(), HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
