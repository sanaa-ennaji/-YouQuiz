package org.sanaa.setnence.citronix.youquiz.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private int attempts = 0;
    private int score;

    private int result;

    @ManyToMany
    @JoinTable(
            name = "quiz_assignment_answer_validation",
            joinColumns = @JoinColumn(name = "quiz_assignment_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_validation_id")
    )
    private List<AnswerValidation> answerValidation;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
