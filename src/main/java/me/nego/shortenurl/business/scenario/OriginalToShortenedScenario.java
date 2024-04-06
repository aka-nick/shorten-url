package me.nego.shortenurl.business.scenario;

import java.time.LocalDateTime;
import java.util.Optional;
import me.nego.shortenurl.business.model.Address;
import me.nego.shortenurl.common.util.HashDigestor;
import me.nego.shortenurl.infrastructure.entity.AddressJpaEntity;
import me.nego.shortenurl.infrastructure.service.AddressCommand;
import me.nego.shortenurl.infrastructure.service.AddressQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nick
 * @since 2024-04-05 17:17
 */
@Service
@Transactional(readOnly = true)
public class OriginalToShortenedScenario {

    private static final int SHORTEN_LENGTH = 5;
    private static final long EXPIRE_TERM = 7L;

    private final AddressQuery addressQuery;
    private final AddressCommand addressCommand;

    public OriginalToShortenedScenario(
            AddressQuery addressQuery,
            AddressCommand addressCommand
    ) {
        this.addressQuery = addressQuery;
        this.addressCommand = addressCommand;
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

    public Address makeShortenByOriginal(String original) {
        String hashed = HashDigestor.hash(original);
        String shortened = hashed.substring(0, SHORTEN_LENGTH);

        AddressJpaEntity save = addressCommand.save(new AddressJpaEntity(
                original,
                shortened,
                LocalDateTime.now().plusDays(EXPIRE_TERM)
        ));

        return new Address(
                save.getOriginal(),
                save.getShortened()
        );
    }

}
