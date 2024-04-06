package me.nego.shortenurl.business.service;

import me.nego.shortenurl.business.model.Address;
import me.nego.shortenurl.business.scenario.OriginalToShortenedScenario;
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

    public final OriginalToShortenedScenario originalToShortenedScenario;

    public OriginalToShortened(OriginalToShortenedScenario originalToShortenedScenario) {
        this.originalToShortenedScenario = originalToShortenedScenario;
    }

    @Override
    public Response originalToShortened(Request request) {
        Address savedAddress = originalToShortenedScenario
                .retrieveAddressByOriginal(request.original())
                .orElseGet(() -> originalToShortenedScenario.makeShortenByOriginal(request.original()));
        return Response.from(savedAddress);
    }

}
