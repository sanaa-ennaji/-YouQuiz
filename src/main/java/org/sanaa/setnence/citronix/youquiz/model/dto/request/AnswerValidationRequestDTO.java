package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerValidationRequestDTO {
    private Long id;
    @Min(value = 0, message = "Points must be a non-negative value.")
    private  int points;
    @Positive(message = "Question ID must be a positive value.")
    private long questionId;

}
