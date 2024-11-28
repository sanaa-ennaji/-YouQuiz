package org.sanaa.setnence.citronix.youquiz.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.embedded.QuestionEmbeddedDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.embedded.SubjectEmbeddedDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectResponseDTO {
    private Long id;
    private String title;
    private long parentSubjectId;
    private List<SubjectEmbeddedDTO> subSubjects;
    private List<QuestionEmbeddedDTO> questionEmbeddedDTO ;
}
