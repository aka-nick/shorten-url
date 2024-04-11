package me.nego.shortenurl.business.exception;

/**
 * @author Nick
 * @since 2024-04-11
 */

public class AddressNotFoundException extends RuntimeException {

    private static final String EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 단축 URL입니다 (%s)";

    public AddressNotFoundException(String notFoundShortened) {
        super(String.format(EXCEPTION_MESSAGE_FORMAT, notFoundShortened));
    }

}
