package org.sanaa.setnence.citronix.youquiz.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
