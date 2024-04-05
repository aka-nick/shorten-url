package me.nego.shortenurl.infrastructure.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class AddressJpaEntity {

    protected AddressJpaEntity() {
    }

    public AddressJpaEntity(
            String original,
            String shortened,
            LocalDateTime expirationAt
    ) {
        this.original = original;
        this.shortened = shortened;
        this.expirationAt = expirationAt;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String original;

    @Column(nullable = false)
    private String shortened;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @Column(nullable = false)
    private LocalDateTime expirationAt;

    public Long getId() {
        return id;
    }

    public String getOriginal() {
        return original;
    }

    public String getShortened() {
        return shortened;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public LocalDateTime getExpirationAt() {
        return expirationAt;
    }

}
