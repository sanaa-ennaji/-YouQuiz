package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelRequestDTO {
    private String description;
    private int minPoints;
    private int maxPoints;
}
