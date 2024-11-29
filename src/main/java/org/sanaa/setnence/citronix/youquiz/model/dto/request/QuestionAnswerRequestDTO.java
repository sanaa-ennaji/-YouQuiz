package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerRequestDTO {
    @Min(value = 0, message = "Points must be a non-negative value.")
    private int points;
    @NotNull(message = "question not must be not null")
    private long questionId;
    @NotNull(message = "question not must be not null")
    private long answerId;

}
