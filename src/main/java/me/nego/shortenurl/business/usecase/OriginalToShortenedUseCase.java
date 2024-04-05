package me.nego.shortenurl.business.usecase;

/**
 * @author Nick
 * @since 2024-04-05 16:47
 */
public interface OriginalToShortenedUseCase {

    Response originalToShortened(Request request);

    record Request(
            String original
    ) {
    }

    record Response(
            String original,
            String shortened
    ) {
    }

}
