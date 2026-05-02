package br.com.wagner.api_cursos.courses.services;

import org.springframework.stereotype.Service;

import br.com.wagner.api_cursos.courses.dtos.CreateCourseDTO;
import br.com.wagner.api_cursos.courses.entities.CourseEntity;
import br.com.wagner.api_cursos.courses.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseEntity create(CreateCourseDTO dto) {
        
        var course = CourseEntity.builder()
            .name(dto.name())
            .category(dto.category())
            .active(true)
            .build();

        return courseRepository.save(course);
    }
 }
