package me.nego.shortenurl.infrastructure.service;

import java.util.Optional;
import me.nego.shortenurl.infrastructure.entity.AddressJpaEntity;
import me.nego.shortenurl.infrastructure.repository.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nick
 * @since 2024-04-05 17:37
 */
@Service
@Transactional(readOnly = true)
public class AddressQuery {

    private final AddressRepository addressRepository;

    public AddressQuery(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Optional<AddressJpaEntity> queryByOriginal(String original) {
        return addressRepository.findByOriginal(original);
    }

    public AddressJpaEntity queryByShortened(String shortened) {
        return addressRepository.findByShortened(shortened);
    }

}
