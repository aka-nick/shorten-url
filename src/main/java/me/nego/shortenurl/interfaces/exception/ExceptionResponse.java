package me.nego.shortenurl.interfaces.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Nick
 * @since 2024-04-05 16:43
 */
public record ExceptionResponse(
        int value,
        String codeName,
        String message
) {

    public static final ExceptionResponse BAD_REQUEST = new ExceptionResponse(
            HttpStatus.BAD_REQUEST.value(),
            HttpStatus.BAD_REQUEST.name(),
            HttpStatus.BAD_REQUEST.getReasonPhrase()
    );
    public static final ExceptionResponse NOT_FOUND = new ExceptionResponse(
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.name(),
            HttpStatus.NOT_FOUND.getReasonPhrase()
    );
    public static final ExceptionResponse INTERNAL_SERVER_ERROR = new ExceptionResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            HttpStatus.INTERNAL_SERVER_ERROR.name(),
            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()
    );

}
