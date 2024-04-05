package me.nego.shortenurl.interfaces.dto;

import me.nego.shortenurl.business.usecase.OriginalToShortenedUseCase;

/**
 * @author Nick
 * @since 2024-04-05 16:36
 */
public record ShortenResponse(
        String shortened
) {

    public ShortenResponse(OriginalToShortenedUseCase.Response response) {
        this(response.shortened());
    }

}
