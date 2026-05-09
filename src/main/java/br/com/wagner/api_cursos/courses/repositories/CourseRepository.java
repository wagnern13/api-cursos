package br.com.wagner.api_cursos.courses.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wagner.api_cursos.courses.entities.CourseEntity;
import java.util.List;


public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    
    List<CourseEntity> findByNameContainingIgnoreCase(String name);
    List<CourseEntity> findByCategoryContainingIgnoreCase(String category);
    List<CourseEntity> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(String name, String category);
    
}

