package org.sanaa.setnence.citronix.youquiz.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.embedded.QuestionEmbeddedDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelResponseDTO {
    private Long id;
    private String description;
    private int minPoints;
    private int maxPoints;
    private List<QuestionEmbeddedDTO> questionEmbeddedDTO;

}
