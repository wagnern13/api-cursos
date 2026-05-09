package br.com.wagner.api_cursos.courses.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wagner.api_cursos.courses.dtos.CourseResponseDTO;
import br.com.wagner.api_cursos.courses.dtos.CreateCourseDTO;
import br.com.wagner.api_cursos.courses.dtos.UpdateCourseDTO;
import br.com.wagner.api_cursos.courses.dtos.UpdateCourseStatusDTO;
import br.com.wagner.api_cursos.courses.services.CourseService;
import br.com.wagner.api_cursos.responses.SuccessResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;




@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<SuccessResponse<CourseResponseDTO>> create(
        @RequestBody @Valid CreateCourseDTO body,
        HttpServletRequest request) {
       
        var dto = courseService.create(body);

        var response = new SuccessResponse<>(
            LocalDateTime.now(),
            HttpStatus.CREATED.value(),
            "Curso criado com sucesso",
            request.getRequestURI(),
            dto
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<CourseResponseDTO>> update(
        @PathVariable UUID id, @RequestBody @Valid UpdateCourseDTO body,
            HttpServletRequest request) {
       
        var dto = courseService.update(id, body);
        
        var response = new SuccessResponse<>(
            LocalDateTime.now(),
            HttpStatus.CREATED.value(),
            "Curso atualizado com sucesso",
            request.getRequestURI(),
            dto
        );    
        
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<SuccessResponse<CourseResponseDTO>> updateStatus(
        @PathVariable UUID id,
        @RequestBody @Valid UpdateCourseStatusDTO body,
            HttpServletRequest request) {
       
        var dto = courseService.updateStatus(id, body);
        
        var response = new SuccessResponse<>(
            LocalDateTime.now(),
            HttpStatus.CREATED.value(),
            "Status atualizado com sucesso",
            request.getRequestURI(),
            dto
        );    

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse<Void>> delete(
        @PathVariable UUID id, 
        HttpServletRequest request) {
        
        courseService.delete(id);

        SuccessResponse<Void> response = new SuccessResponse<>(
            LocalDateTime.now(), 
            HttpStatus.OK.value(), 
            "Exclusão efetuada com sucesso", 
            request.getRequestURI(),
            null
        );
        
        return ResponseEntity.ok(response);
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
