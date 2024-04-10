package me.nego.shortenurl.business.service;

import java.time.LocalDateTime;
import me.nego.shortenurl.business.scenario.DeleteExpiredShortenedScenario;
import me.nego.shortenurl.business.usecase.DeleteExpiredShortenedUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nick
 * @since 2024-04-10
 */

@Service
@Transactional(readOnly = true)
public class DeleteExpiredShortened implements DeleteExpiredShortenedUseCase {

    private final DeleteExpiredShortenedScenario deleteExpiredShortenedScenario;

    public DeleteExpiredShortened(DeleteExpiredShortenedScenario deleteExpiredShortenedScenario) {
        this.deleteExpiredShortenedScenario = deleteExpiredShortenedScenario;
    }

    @Override
    public void deleteExpiredShortened(Request request) {
        LocalDateTime expirationTerm = deleteExpiredShortenedScenario.calculateExpirationTerm(request.beforeDays());
        deleteExpiredShortenedScenario.expireAllByExpirationTerm(expirationTerm);
    }

}
