package org.sanaa.setnence.citronix.youquiz.service.interfaces;

import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuestionRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuestionResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Question;

public interface QuestionServiceI extends GenericServiceI<Question, QuestionRequestDTO, QuestionResponseDTO> {
}
