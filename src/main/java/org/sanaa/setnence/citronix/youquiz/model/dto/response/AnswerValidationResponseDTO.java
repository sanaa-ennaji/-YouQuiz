package org.sanaa.setnence.citronix.youquiz.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.embedded.QuizAssignmentEmbeddedDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.QuizAssignment;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerValidationResponseDTO {
    private Long id;
    private  int points;
    private List<QuizAssignmentEmbeddedDTO> quizAssignmentEmbeddedDTO;
    private long questionId ;
}
