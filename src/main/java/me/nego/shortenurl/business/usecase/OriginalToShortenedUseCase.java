package me.nego.shortenurl.business.usecase;

import me.nego.shortenurl.business.model.Address;

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

        public static Response from(Address address) {
            return new Response(
                    address.original(),
                    address.shortened()
            );
        }

    }

}
