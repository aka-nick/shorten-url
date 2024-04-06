package me.nego.shortenurl.interfaces.dto;

import me.nego.shortenurl.business.usecase.RedirectOriginalFromShortenedUseCase;

public record RedirectResponse(
        String original
) {

    public static RedirectResponse from(RedirectOriginalFromShortenedUseCase.Response response) {
        return new RedirectResponse(response.original());
    }

}
