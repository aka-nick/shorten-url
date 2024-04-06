package me.nego.shortenurl.business.service;

import me.nego.shortenurl.business.scenario.RedirectOriginalFromShortenedScenario;
import me.nego.shortenurl.business.usecase.RedirectOriginalFromShortenedUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nick
 * @since 2024-04-06
 */

@Service
@Transactional(readOnly = true)
public class RedirectOriginalFromShortened implements RedirectOriginalFromShortenedUseCase {

    private final RedirectOriginalFromShortenedScenario redirectOriginalFromShortenedScenario;

    public RedirectOriginalFromShortened(
            RedirectOriginalFromShortenedScenario redirectOriginalFromShortenedScenario
    ) {
        this.redirectOriginalFromShortenedScenario = redirectOriginalFromShortenedScenario;
    }

    @Override
    public Response redirectOriginalFromShortened(Request request) {
        return Response.from(redirectOriginalFromShortenedScenario
                .findOriginalInCache(request.shortened())
                .orElseGet(() -> redirectOriginalFromShortenedScenario.getOriginalInDbAndCached(request.shortened()))
        );
    }

}
