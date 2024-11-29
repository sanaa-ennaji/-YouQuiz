package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectRequestDTO {
    @NotNull
    private String title;
    private Long parentSubjectId;
}
