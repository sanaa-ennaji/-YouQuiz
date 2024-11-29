package org.sanaa.setnence.citronix.youquiz.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    @NotNull(message = "firstname can't be null ")
    private String firstName;
    @NotNull(message = "lastname can't be null ")
    private String lastName;
    @NotBlank
    private LocalDate birthDate;
    @NotNull
    private String address;
}
