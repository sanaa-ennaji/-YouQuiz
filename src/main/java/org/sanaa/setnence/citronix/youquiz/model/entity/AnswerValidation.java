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

    @ManyToOne
    @JoinColumn(name = "quiz_assignment_id")
    private QuizAssignment quizAssignment;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer ;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question ;


}
