package br.com.wagner.api_cursos.courses.dtos;

import jakarta.validation.constraints.NotNull;

public record UpdateCourseStatusDTO(

    @NotNull(message = "O status active é obrigatório")
    Boolean active

) {}
