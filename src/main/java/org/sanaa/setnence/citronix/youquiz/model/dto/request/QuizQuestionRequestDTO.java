package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestionRequestDTO {
    @NotNull(message = "Timer cannot be null.")
    private Duration timer;
    @NotNull(message= "question id can't be null")
    private long QuestionId ;
    @NotNull(message= "quiz id can't be null")
    private long QuizId;
}
