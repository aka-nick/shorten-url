package me.nego.shortenurl.business.service;

import me.nego.shortenurl.business.usecase.OriginalToShortenedUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nick
 * @since 2024-04-05 16:52
 */
@Service
@Transactional(readOnly = true)
public class OriginalToShortened implements OriginalToShortenedUseCase {

    @Override
    public Response originalToShortened(Request request) {
        return null;
    }

}
