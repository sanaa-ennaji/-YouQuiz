package org.sanaa.setnence.citronix.youquiz.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectResponseDTO {
    private Long id;
    private String title;
    private SubjectResponseDTO parentSubject; // Nested parent subject
    private List<SubjectResponseDTO> subSubjects;// Nested sub-subjects
}
