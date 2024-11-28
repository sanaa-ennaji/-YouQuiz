package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizAssignmentRequestDTO {
    private String reason;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long studentId;
}
