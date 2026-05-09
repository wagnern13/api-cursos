package br.com.wagner.api_cursos.courses.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wagner.api_cursos.courses.dtos.CourseResponseDTO;
import br.com.wagner.api_cursos.courses.dtos.CreateCourseDTO;
import br.com.wagner.api_cursos.courses.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponseDTO> create(@RequestBody @Valid CreateCourseDTO body) {
       
        var response = courseService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> list() {
        
        var response = courseService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CourseResponseDTO>> search(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String category) {

        var response = courseService.search(name, category);
        return ResponseEntity.ok(response);
    }
}
