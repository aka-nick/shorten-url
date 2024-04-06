package me.nego.shortenurl.business.usecase;

/**
 * @author Nick
 * @since 2024-04-06
 */

public interface RedirectOriginalFromShortenedUseCase {

    Response redirectOriginalFromShortened(Request request);

    record Request(
            String shortened
    ) {
    }

    record Response(
            String original
    ) {

        public static Response from(String original) {
            return new Response(original);
        }

    }

}
