package org.sanaa.setnence.citronix.youquiz.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AnswerValidation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  int points;

    @ManyToMany
    @JoinColumn(name = "quizAssignment_id", nullable = false)
    private List<QuizAssignment> quizAssignment;

}
