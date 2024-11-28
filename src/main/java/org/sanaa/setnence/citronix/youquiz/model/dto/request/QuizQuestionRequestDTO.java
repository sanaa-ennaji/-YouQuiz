package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestionRequestDTO {
    private Duration timer;
    private long QuestionId ;
    private long QuizId;
}
