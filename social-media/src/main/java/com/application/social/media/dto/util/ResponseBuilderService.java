package com.application.social.media.dto.util;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

public class ResponseBuilderService {

    @Data
    @Builder
    public static class DefaultResponseDto {
        private LocalDateTime date;
        private String body;
        private String errorMessage;
    }
}
