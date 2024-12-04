package org.sanaa.setnence.citronix.youquiz.service.impl;

import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuestionRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuestionResponseDTO;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.QuestionServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements QuestionServiceI {

    @Override
    public QuestionResponseDTO create(QuestionRequestDTO questionRequestDTO) {
        return null;
    }

    @Override
    public QuestionResponseDTO update(Long id, QuestionRequestDTO questionRequestDTO) {
        return null;
    }

    @Override
    public Optional<QuestionResponseDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<QuestionResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
