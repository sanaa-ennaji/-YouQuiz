package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerRequestDTO extends UserRequestDTO {
    private String specialty;
}
