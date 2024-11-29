package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.enums.QuestionType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequestDTO {
    @NotBlank(message = "Question text cannot be blank.")
    private String text;
    @NotNull(message = "Question type cannot be null.")
    private QuestionType type;
    @Min(value = 0, message = "Correct answers must be a non-negative value.")
    private int correctAnswers;

    @NotNull
    private Long subjectId;
    @NotNull
    private Long levelId;
}
