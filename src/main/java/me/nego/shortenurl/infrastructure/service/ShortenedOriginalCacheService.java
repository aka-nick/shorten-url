package me.nego.shortenurl.infrastructure.service;

import java.util.Optional;
import me.nego.shortenurl.infrastructure.repository.Cache;
import org.springframework.stereotype.Service;

/**
 * @author Nick
 * @since 2024-04-06
 */

@Service
public class ShortenedOriginalCacheService {

    // TODO: Shortened와 Original을 별개의 개념으로 추출할것(현재는 둘 다 String)
    private final Cache<String, String> cache;

    public ShortenedOriginalCacheService(Cache<String, String> cache) {
        this.cache = cache;
    }

    public boolean isHit(String shortened) {
        return cache.isHit(shortened);
    }

    public void add(String shortened, String original) {
        cache.set(shortened, original);
    }

    public String get(String shortened) {
        return cache.get(shortened);
    }

    public Optional<String> retrieve(String shortened) {
        return Optional.ofNullable(
                get(shortened)
        );
    }

    public void deleteByShortened(String shortened) {
        cache.delete(shortened);
    }

}
