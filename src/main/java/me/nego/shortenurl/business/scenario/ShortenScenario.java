package me.nego.shortenurl.business.scenario;

import java.util.Optional;
import me.nego.shortenurl.business.domain.Address;
import me.nego.shortenurl.infrastructure.entity.AddressJpaEntity;
import me.nego.shortenurl.infrastructure.service.AddressQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nick
 * @since 2024-04-05 17:17
 */
@Service
@Transactional(readOnly = true)
public class ShortenScenario {

    private final AddressQuery addressQuery;

    public ShortenScenario(AddressQuery addressQuery) {
        this.addressQuery = addressQuery;
    }

    public Optional<Address> retrieveAddressByOriginal(String original) {
        Optional<AddressJpaEntity> exists = addressQuery.queryByOriginal(original);
        if (exists.isEmpty()) {
            return Optional.empty();
        }

        AddressJpaEntity found = exists.get();
        return Optional.of(new Address(
                found.getOriginal(),
                found.getShortened()
        ));
    }

}
