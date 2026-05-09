package br.com.wagner.api_cursos.courses.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.wagner.api_cursos.courses.dtos.CourseResponseDTO;
import br.com.wagner.api_cursos.courses.dtos.CreateCourseDTO;
import br.com.wagner.api_cursos.courses.entities.CourseEntity;
import br.com.wagner.api_cursos.courses.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseResponseDTO create(CreateCourseDTO dto) {
        
        var course = CourseEntity.builder()
            .name(dto.name())
            .category(dto.category())
            .active(true)
            .build();

        var saved = courseRepository.save(course);    
        return CourseResponseDTO.fromEntity(saved);
    }

    public List<CourseResponseDTO> findAll() {
        
        return courseRepository.findAll()
            .stream()
            .map(CourseResponseDTO::fromEntity)
            .toList();
    }
 }
