package me.nego.shortenurl.interfaces.dto;

import jakarta.validation.constraints.NotEmpty;

/**
 * @author Nick
 * @since 2024-04-06
 */

public record RedirectRequest(
        @NotEmpty
        String shortened
) {

}
