package me.nego.shortenurl.interfaces.dto;

import jakarta.validation.constraints.NotEmpty;

/**
 * @author Nick
 * @since 2024-04-05 16:35
 */
public record ShortenRequest(
        @NotEmpty
        String original
) {

}
