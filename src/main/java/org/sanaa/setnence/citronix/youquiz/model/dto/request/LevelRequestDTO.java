package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelRequestDTO {

    @NotBlank(message = "Description cannot be blank.")
    private String description;
    @Min(value = 0, message = "Min points must be a non-negative value.")
    private int minPoints;
    @Min(value = 0, message = "Max points must be a non-negative value.")
    private int maxPoints;
}
