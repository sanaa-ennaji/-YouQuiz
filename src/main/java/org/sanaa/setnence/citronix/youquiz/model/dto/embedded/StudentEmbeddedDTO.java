package org.sanaa.setnence.citronix.youquiz.model.dto.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEmbeddedDTO {
    private LocalDate enrollmentDate;
    private List<QuizAssignmentEmbeddedDTO> quizAssingnmentEmbeddedDTO;


}
