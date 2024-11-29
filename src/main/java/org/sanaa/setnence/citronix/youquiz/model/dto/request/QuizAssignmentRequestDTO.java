package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizAssignmentRequestDTO {
    @NotBlank(message = "Reason cannot be blank.")
    private String reason;
    @NotNull(message = "Start date cannot be null.")
    private LocalDate startDate;
    @NotNull(message = "End date cannot be null.")
    private LocalDate endDate;
    @NotNull(message = "student id can't be null")
    private Long studentId;
}
