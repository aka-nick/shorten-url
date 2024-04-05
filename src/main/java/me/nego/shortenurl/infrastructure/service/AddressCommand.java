package me.nego.shortenurl.infrastructure.service;

import me.nego.shortenurl.infrastructure.entity.AddressJpaEntity;
import me.nego.shortenurl.infrastructure.repository.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nick
 * @since 2024-04-05
 */
@Service
@Transactional
public class AddressCommand {

    private final AddressRepository addressRepository;

    public AddressCommand(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressJpaEntity save(AddressJpaEntity toSave) {
        return addressRepository.save(toSave);
    }

}
