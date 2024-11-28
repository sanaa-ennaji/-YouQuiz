package org.sanaa.setnence.citronix.youquiz.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizAssignmentResponseDTO {
    private Long id;
    private String reason;
    private LocalDate startDate;
    private LocalDate endDate;
    private int score;
    private int result;
    private StudentResponseDTO student;
}
