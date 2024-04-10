package me.nego.shortenurl.interfaces.scheduler;

import me.nego.shortenurl.business.usecase.DeleteExpiredShortenedUseCase;
import me.nego.shortenurl.business.usecase.DeleteExpiredShortenedUseCase.Request;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Nick
 * @since 2024-04-10
 */

@Component
public class ShortenedRemoveScheduler {

    public static final long TERM_FOR_DELETE = 7L;

    private final DeleteExpiredShortenedUseCase deleteExpiredShortenedUseCase;

    public ShortenedRemoveScheduler(DeleteExpiredShortenedUseCase deleteExpiredShortenedUseCase) {
        this.deleteExpiredShortenedUseCase = deleteExpiredShortenedUseCase;
    }

    @Scheduled(cron = "0 0 4 * * *")
    public void deleteOldShortened() {
        deleteExpiredShortenedUseCase.deleteExpiredShortened(new Request(
                TERM_FOR_DELETE
        ));
    }

}
