package org.sanaa.setnence.citronix.youquiz.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToMany(mappedBy = "answerValidation")
    @JsonBackReference
    private List<QuizAssignment> quizAssignment;


    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question ;

}
