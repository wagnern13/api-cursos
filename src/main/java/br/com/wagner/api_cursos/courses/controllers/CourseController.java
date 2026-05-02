package br.com.wagner.api_cursos.courses.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wagner.api_cursos.courses.dtos.CreateCourseDTO;
import br.com.wagner.api_cursos.courses.entities.CourseEntity;
import br.com.wagner.api_cursos.courses.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseEntity> create(@RequestBody @Valid CreateCourseDTO body) {
       
        var course = courseService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }
}
