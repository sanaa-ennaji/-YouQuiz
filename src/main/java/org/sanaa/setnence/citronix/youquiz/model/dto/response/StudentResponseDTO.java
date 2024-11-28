package org.sanaa.setnence.citronix.youquiz.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.embedded.QuizAssignmentEmbeddedDTO;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO extends UserResponseDTO {
    private LocalDate enrollmentDate;
    private List<QuizAssignmentEmbeddedDTO>  quizAssingnmentEmbeddedDTO;
}
