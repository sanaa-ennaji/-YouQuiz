package org.sanaa.setnence.citronix.youquiz.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerValidationResponseDTO {
    private Long id;
    private  int points;
    private long questionId ;
    private long answerId;
    private Long quizAssignmentId;

}
