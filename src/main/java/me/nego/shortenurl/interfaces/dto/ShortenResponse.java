package me.nego.shortenurl.interfaces.dto;

import me.nego.shortenurl.business.usecase.OriginalToShortenedUseCase;

/**
 * @author Nick
 * @since 2024-04-05 16:36
 */
public record ShortenResponse(
        String shortened
) {

    public static ShortenResponse from(OriginalToShortenedUseCase.Response response) {
        return new ShortenResponse(response.shortened());
    }

}
