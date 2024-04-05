package me.nego.shortenurl.business.service;

import me.nego.shortenurl.business.model.Address;
import me.nego.shortenurl.business.scenario.ShortenScenario;
import me.nego.shortenurl.business.usecase.OriginalToShortenedUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nick
 * @since 2024-04-05 16:52
 */
@Service
@Transactional(readOnly = true)
public class OriginalToShortened implements OriginalToShortenedUseCase {

    public final ShortenScenario shortenScenario;

    public OriginalToShortened(ShortenScenario shortenScenario) {
        this.shortenScenario = shortenScenario;
    }

    @Override
    public Response originalToShortened(Request request) {
        Address savedAddress = shortenScenario
                .retrieveAddressByOriginal(request.original())
                .orElseGet(() -> shortenScenario.makeShortenByOriginal(request.original()));
        return Response.from(savedAddress);
    }

}
