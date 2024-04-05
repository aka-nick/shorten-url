package me.nego.shortenurl.business.scenario;

import java.util.Optional;
import me.nego.shortenurl.business.usecase.OriginalToShortenedUseCase;
import me.nego.shortenurl.business.usecase.OriginalToShortenedUseCase.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nick
 * @since 2024-04-05 17:17
 */
@Service
@Transactional(readOnly = true)
public class ShortenScenario {

    private final ShortenQuery shortenQuery;

    public ShortenScenario(ShortenQuery shortenQuery) {
        this.shortenQuery = shortenQuery;
    }

    public Optional<OriginalToShortenedUseCase.Response> retrieveByOriginal(String original) {
        Optional<UrlJpaEntity> exists = shortenQuery.queryByOriginal(original);
        if (exists.isEmpty()) {
            return Optional.empty();
        }

        UrlJpaEntity found = exists.get();
        return Optional.of(new Response(
                found.getOriginal(),
                found.getShortened()
        ));
    }

}
