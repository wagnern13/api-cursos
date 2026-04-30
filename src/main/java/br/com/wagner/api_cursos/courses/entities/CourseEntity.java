package br.com.wagner.api_cursos.courses.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "courses")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;                   // Identificador único de cada curso

    @NotBlank(message = "O nome do curso é obrigatório")
    @Column(nullable = false)
    private String name;               // Nome do curso

    @NotBlank(message = "A categoria é obrigatório")
    @Column(nullable = false)
    private String category;           // Categoria do curso

    @Column(nullable = false)
    private Boolean active;            //  Define se o curso está ativo ou não

    @CreationTimestamp
    private LocalDateTime created_at;  // Data de quando o curso foi criado

    @UpdateTimestamp
    private LocalDateTime updated_at;  // Deve ser sempre alterado para a data de quando o curso for atualizado
}
