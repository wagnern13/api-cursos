package br.com.wagner.api_cursos.responses;

import java.time.LocalDateTime;

public record SuccessResponse<T>(

    LocalDateTime timestamp,
    int stauts,
    String message,
    String path,
    T data
) {}
