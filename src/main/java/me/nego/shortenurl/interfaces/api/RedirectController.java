package me.nego.shortenurl.interfaces.api;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import me.nego.shortenurl.business.usecase.RedirectOriginalFromShortenedUseCase;
import me.nego.shortenurl.business.usecase.RedirectOriginalFromShortenedUseCase.Request;
import me.nego.shortenurl.business.usecase.RedirectOriginalFromShortenedUseCase.Response;
import me.nego.shortenurl.interfaces.dto.RedirectRequest;
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
    public void redirect(
            @PathVariable("shortened") @Validated RedirectRequest requestDto,
            HttpServletResponse httpServletResponse
    ) throws IOException {
        Response response = redirectOriginalFromShortenedUseCase.redirectOriginalFromShortened(
                new Request(requestDto.shortened())
        );

        httpServletResponse.sendRedirect(response.original());
    }


}
