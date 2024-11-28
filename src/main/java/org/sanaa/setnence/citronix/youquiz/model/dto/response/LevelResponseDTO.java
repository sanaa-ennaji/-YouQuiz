package org.sanaa.setnence.citronix.youquiz.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelResponseDTO {
    private Long id;
    private String description;
    private int minPoints;
    private int maxPoints;
}
