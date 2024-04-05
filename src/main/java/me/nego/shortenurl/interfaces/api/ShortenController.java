package me.nego.shortenurl.interfaces.api;

import me.nego.shortenurl.interfaces.dto.ShortenRequest;
import me.nego.shortenurl.interfaces.dto.ShortenResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nick
 * @since 2024-04-05 16:30
 */
@RestController
@RequestMapping("/api")
public class ShortenController {

    @PostMapping("/v1/shorten")
    public Object shorten(
            @RequestBody @Validated final ShortenRequest requestDto
    ) {
        return new ShortenResponse("");
    }


}
