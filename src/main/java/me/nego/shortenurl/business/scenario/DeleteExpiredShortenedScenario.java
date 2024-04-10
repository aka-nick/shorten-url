package me.nego.shortenurl.business.scenario;

import java.time.LocalDateTime;
import java.util.List;
import me.nego.shortenurl.infrastructure.entity.AddressJpaEntity;
import me.nego.shortenurl.infrastructure.service.AddressCommand;
import me.nego.shortenurl.infrastructure.service.AddressQuery;
import me.nego.shortenurl.infrastructure.service.ShortenedOriginalCacheService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DeleteExpiredShortenedScenario {

    private final AddressQuery addressQuery;
    private final AddressCommand addressCommand;
    private final ShortenedOriginalCacheService shortenedOriginalCacheService;

    public DeleteExpiredShortenedScenario(
            AddressQuery addressQuery,
            AddressCommand addressCommand,
            ShortenedOriginalCacheService shortenedOriginalCacheService
    ) {
        this.addressQuery = addressQuery;
        this.addressCommand = addressCommand;
        this.shortenedOriginalCacheService = shortenedOriginalCacheService;
    }

    public LocalDateTime calculateExpirationTerm(Long beforeDays) {
        return LocalDateTime.now().minusDays(beforeDays);
    }

    public void expireAllByExpirationTerm(LocalDateTime expirationTerm) {
        List<AddressJpaEntity> targetEntitys = findExpirationTargets(expirationTerm);

        expireAllInCache(targetEntitys);
        expireAllInPersistence(targetEntitys);
    }

    private List<AddressJpaEntity> findExpirationTargets(LocalDateTime expirationTarget) {
        return addressQuery.queryAllByCreatedAtLessThanEqual(expirationTarget);
    }

    private void expireAllInCache(List<AddressJpaEntity> targetEntitys) {
        targetEntitys.stream()
                .map(AddressJpaEntity::getShortened)
                .forEach(shortenedOriginalCacheService::deleteByShortened);
    }

    private void expireAllInPersistence(List<AddressJpaEntity> targetEntitys) {
        addressCommand.deleteAllByTargetIds(targetEntitys.stream()
                .map(AddressJpaEntity::getId)
                .toList()
        );
    }

}
