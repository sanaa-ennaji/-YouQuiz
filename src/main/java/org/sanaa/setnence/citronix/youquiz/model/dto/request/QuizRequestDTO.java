package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizRequestDTO {
    @NotBlank(message = "Title cannot be blank.")
    private String title;
    @Min(value = 0, message = "Passing score must be a non-negative value.")
    private int passingScore;
    private Boolean canSeeAnswers;
    private Boolean canSeeResult;
    @Min(value = 0, message = "Chances must be a non-negative value.")
    private int chances;
    @NotNull
    private String remark;
    @NotNull
    private Long trainerId;
}
