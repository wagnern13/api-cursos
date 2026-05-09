package br.com.wagner.api_cursos.courses.dtos;

import jakarta.validation.constraints.NotBlank;

public record UpdateCourseDTO(

    @NotBlank(message = "O nome do curso é obrigatório")
    String name,

    @NotBlank(message = "A categoria é obrigatória")
    String category

) {}
