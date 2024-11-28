package org.sanaa.setnence.citronix.youquiz.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.enums.QuestionType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDTO {
    private Long id;
    private String text;
    private QuestionType type;
    private int correctAnswers;
    //private SubjectResponseDTO subject;
//    private LevelResponseDTO level;
}
