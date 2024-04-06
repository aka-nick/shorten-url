package me.nego.shortenurl.business.service;

import me.nego.shortenurl.business.scenario.RedirectOriginalFromShortenedScenario;
import me.nego.shortenurl.business.usecase.RedirectOriginalFromShortenedUseCase;
import me.nego.shortenurl.infrastructure.service.AddressQuery;
import me.nego.shortenurl.infrastructure.service.ShortenedOriginalCacheService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nick
 * @since 2024-04-06
 */

@Service
@Transactional(readOnly = true)
public class RedirectOriginalFromShortened implements RedirectOriginalFromShortenedUseCase {

    private final ShortenedOriginalCacheService shortenedOriginalCacheService;
    private final AddressQuery addressQuery;

    private final RedirectOriginalFromShortenedScenario redirectOriginalFromShortenedScenario;

    public RedirectOriginalFromShortened(
            ShortenedOriginalCacheService shortenedOriginalCacheService,
            AddressQuery addressQuery,
            RedirectOriginalFromShortenedScenario redirectOriginalFromShortenedScenario
    ) {
        this.shortenedOriginalCacheService = shortenedOriginalCacheService;
        this.addressQuery = addressQuery;
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
