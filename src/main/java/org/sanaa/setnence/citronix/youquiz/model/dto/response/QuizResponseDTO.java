package org.sanaa.setnence.citronix.youquiz.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.embedded.QuizQuestionEmbeddedDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponseDTO {
    private Long id;
    private String title;
    private int passingScore;
    private Boolean canSeeAnswers;
    private Boolean canSeeResult;
    private int chances;
    private String remark;
    private TrainerResponseDTO trainer;
    private List<QuizQuestionEmbeddedDTO> quizQuestionEmbeddedDTO ;
}
