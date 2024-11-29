package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequestDTO {
    @NotNull(message = "QuestionAnswers list cannot be null.")
    private String text;
    private boolean isCorrect;

}
