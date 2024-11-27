package org.sanaa.setnence.citronix.youquiz.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class QuizAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    private int score ;
    private int result ;
    @ManyToMany
    @JoinColumn(name = "answerValidation_id", nullable = false)
    private List<AnswerValidation> answerValidation;
}
