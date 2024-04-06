package me.nego.shortenurl.business.usecase;

/**
 * @author Nick
 * @since 2024-04-06
 */

public interface RedirectOriginalFromShortenedUseCase {

    Response redirectOriginalFromShortened(Request request);

    record Request() {
    }

    record Response() {
    }

}
