package me.nego.shortenurl.infrastructure.repository;

import java.util.Optional;
import me.nego.shortenurl.infrastructure.entity.AddressJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Nick
 * @since 2024-04-05 17:36
 */
public interface AddressRepository extends JpaRepository<AddressJpaEntity, Long> {

    Optional<AddressJpaEntity> findByOriginal(String original);

    AddressJpaEntity findByShortened(String shortened);

}
