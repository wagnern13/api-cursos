package br.com.wagner.api_cursos.courses.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.wagner.api_cursos.courses.entities.CourseEntity;

public record CourseResponseDTO(
    UUID id,
    String name,
    String category,
    Boolean active,
    LocalDateTime created_at,
    LocalDateTime updated_at
) {
    public static CourseResponseDTO fromEntity(CourseEntity entity) {
        return new CourseResponseDTO(
            entity.getId(), 
            entity.getName(), 
            entity.getCategory(), 
            entity.getActive(), 
            entity.getCreated_at(), 
            entity.getUpdated_at()
        );
    }
} 
