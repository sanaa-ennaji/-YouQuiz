package org.sanaa.setnence.citronix.youquiz.model.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.embedded.QuestionAnswerEmbeddedDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponseDTO {
    private Long id;
    private String text;
    private boolean isCorrect;
    private List<QuestionAnswerEmbeddedDTO> questionAnswers;
}
