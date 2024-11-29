package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO extends UserRequestDTO {
    @NotNull
    private LocalDate enrollmentDate;
}
