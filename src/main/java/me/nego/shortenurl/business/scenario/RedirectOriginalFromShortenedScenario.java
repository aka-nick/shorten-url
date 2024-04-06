package me.nego.shortenurl.business.scenario;

import java.util.Optional;
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
public class RedirectOriginalFromShortenedScenario {

    private final ShortenedOriginalCacheService shortenedOriginalCacheService;
    private final AddressQuery addressQuery;

    public RedirectOriginalFromShortenedScenario(
            ShortenedOriginalCacheService shortenedOriginalCacheService,
            AddressQuery addressQuery
    ) {
        this.shortenedOriginalCacheService = shortenedOriginalCacheService;
        this.addressQuery = addressQuery;
    }

    public Optional<String> findOriginalInCache(String shortened) {
        return shortenedOriginalCacheService.retrieve(shortened);
    }

    public String getOriginalInDbAndCached(String shortened) {
        String original = getOriginalInDb(shortened);
        caching(shortened, original);
        return original;
    }

    private void caching(String shortened, String original) {
        shortenedOriginalCacheService.add(shortened, original);
    }

    private String getOriginalInDb(String shortened) {
        return addressQuery
                .queryByShortened(shortened)
                .getOriginal();
    }

}
