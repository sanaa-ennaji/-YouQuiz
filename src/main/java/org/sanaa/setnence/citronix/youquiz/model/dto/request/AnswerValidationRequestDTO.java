package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerValidationRequestDTO {
    @Min(value = 0, message = "Points must be a non-negative value.")
    private  int points;
    @NotNull
    private long questionId;
    @NotNull
    private long answerId;
    private long quizAssignmentId;

}
