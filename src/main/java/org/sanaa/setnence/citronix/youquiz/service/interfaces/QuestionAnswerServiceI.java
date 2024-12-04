package org.sanaa.setnence.citronix.youquiz.service.interfaces;

import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuestionAnswerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuestionAnswerResponseDTO;


import java.util.List;
import java.util.Optional;

public interface QuestionAnswerServiceI {

   QuestionAnswerResponseDTO create(QuestionAnswerRequestDTO questionAnswerRequestDTO) ;
   Optional<QuestionAnswerResponseDTO> findById(Long id);
   List<QuestionAnswerResponseDTO> findAll();
   void delete(Long id) ;
}

