package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizRequestDTO {
    private String title;
    private int passingScore;
    private Boolean canSeeAnswers;
    private Boolean canSeeResult;
    private int chances;
    private String remark;
    private Long trainerId;
}
