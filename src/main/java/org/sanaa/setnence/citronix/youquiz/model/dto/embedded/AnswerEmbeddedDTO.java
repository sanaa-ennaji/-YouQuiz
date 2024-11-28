package org.sanaa.setnence.citronix.youquiz.model.dto.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerEmbeddedDTO {
    private Long id;
    private String text;
    private boolean isCorrect;
}
