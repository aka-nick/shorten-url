package me.nego.shortenurl.interfaces.exception.aop;

import me.nego.shortenurl.business.exception.AddressNotFoundException;
import me.nego.shortenurl.interfaces.exception.ExceptionResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author Nick
 * @since 2024-04-05 16:43
 */
@RestControllerAdvice
public class ApiRestControllerAdvice {
    // TODO : 로깅 남기기

    /*
    기본 예외 처리 : 400, 404, 500
     */
    @ExceptionHandler(ConstraintViolationException.class)
    ExceptionResponse handleExceptionDefault(ConstraintViolationException e) {
        return ExceptionResponse.BAD_REQUEST;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ExceptionResponse handleExceptionDefault(MethodArgumentNotValidException e) {
        return ExceptionResponse.BAD_REQUEST;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    ExceptionResponse handleExceptionDefault(NoHandlerFoundException e) {
        return ExceptionResponse.NOT_FOUND;
    }

    @ExceptionHandler(Exception.class)
    ExceptionResponse handleExceptionDefault(Exception e) {
        return ExceptionResponse.INTERNAL_SERVER_ERROR;
    }

    /*
    커스텀 예외 처리
     */
    @ExceptionHandler(AddressNotFoundException.class)
    ExceptionResponse handException(AddressNotFoundException e) {
        return new ExceptionResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                e.getMessage()
        );
    }

}