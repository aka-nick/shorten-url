package me.nego.shortenurl.interfaces.api;

import me.nego.shortenurl.business.usecase.RedirectOriginalFromShortenedUseCase;
import me.nego.shortenurl.business.usecase.RedirectOriginalFromShortenedUseCase.Request;
import me.nego.shortenurl.business.usecase.RedirectOriginalFromShortenedUseCase.Response;
import me.nego.shortenurl.interfaces.dto.RedirectRequest;
import me.nego.shortenurl.interfaces.dto.RedirectResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nick
 * @since 2024-04-06
 */
@RestController
public class RedirectController {

    private final RedirectOriginalFromShortenedUseCase redirectOriginalFromShortenedUseCase;

    public RedirectController(RedirectOriginalFromShortenedUseCase redirectOriginalFromShortenedUseCase) {
        this.redirectOriginalFromShortenedUseCase = redirectOriginalFromShortenedUseCase;
    }

    @GetMapping("/{shortened}")
    public RedirectResponse redirect(
            @PathVariable("shortened") @Validated RedirectRequest requestDto
    ) {
        Response response = redirectOriginalFromShortenedUseCase.redirectOriginalFromShortened(
                new Request(requestDto.shortened())
        );

        return RedirectResponse.from(response);
    }


}
