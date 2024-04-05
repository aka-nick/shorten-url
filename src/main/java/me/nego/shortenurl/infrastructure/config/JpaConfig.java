package me.nego.shortenurl.infrastructure.config;

import jakarta.persistence.EntityListeners;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class JpaConfig {

}
