package org.sanaa.setnence.citronix.youquiz.model.dto.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.enums.QuestionType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionEmbeddedDTO {
    private Long id;
    private String text;
    private QuestionType type;
    private int correctAnswers;
}
