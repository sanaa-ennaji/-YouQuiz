package org.sanaa.setnence.citronix.youquiz.model.dto.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizAssignmentEmbeddedDTO {
    private long id;
    private String reason;
    private LocalDate startDate;
    private LocalDate endDate;


}
