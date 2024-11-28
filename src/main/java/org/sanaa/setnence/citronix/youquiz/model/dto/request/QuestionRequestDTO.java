package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.enums.QuestionType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequestDTO {
    private String text;
    private QuestionType type;
    private int correctAnswers;
    private Long subjectId;
    private Long levelId;
}
