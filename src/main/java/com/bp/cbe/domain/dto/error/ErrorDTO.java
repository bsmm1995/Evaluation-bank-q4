package com.bp.cbe.domain.dto.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorDTO {
    private HttpStatus status;
    private String message;
    private String url;
    private LocalDateTime date = LocalDateTime.now();

    public ErrorDTO(HttpStatus status, String message, String url) {
        this.status = status;
        this.message = message;
        this.url = url;
    }
}
