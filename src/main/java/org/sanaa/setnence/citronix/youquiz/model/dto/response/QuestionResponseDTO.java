package org.sanaa.setnence.citronix.youquiz.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.embedded.AnswerValidationEmbeddedDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.embedded.QuestionAnswerEmbeddedDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.embedded.QuizQuestionEmbeddedDTO;
import org.sanaa.setnence.citronix.youquiz.model.enums.QuestionType;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDTO {
    private Long id;
    private String text;
    private QuestionType type;
    private int correctAnswers;
    private Long subjectId;
    private Long levelId;
    private List<QuestionAnswerEmbeddedDTO> questionAnswersEmbeddedDTO;
    private List<QuizQuestionEmbeddedDTO> quizQuestionEmbeddedDTO ;
    private List<AnswerValidationEmbeddedDTO> answerValidationEmbeddedDTO;

}
