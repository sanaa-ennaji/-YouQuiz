package org.sanaa.setnence.citronix.youquiz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuestionAnswerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuestionRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuestionAnswerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuestionResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.*;
import org.sanaa.setnence.citronix.youquiz.model.mapper.QuestionAnswerMapper;
import org.sanaa.setnence.citronix.youquiz.repository.QuestionAnswerRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.QuestionAnswerServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionAnswerService implements QuestionAnswerServiceI {
    private final QuestionAnswerRepository questionAnswerRepository;
    private final QuestionAnswerMapper questionAnswerMapper;
    private final QuestionService questionService;
    private final AnswerService answerService;

    public QuestionAnswerService(QuestionAnswerRepository questionAnswerRepository, QuestionAnswerMapper questionAnswerMapper, QuestionService questionService, AnswerService answerService) {
        this.questionAnswerRepository = questionAnswerRepository;
        this.questionAnswerMapper = questionAnswerMapper;
        this.questionService = questionService;
        this.answerService = answerService;

    }

    @Override
    public QuestionAnswerResponseDTO create(QuestionAnswerRequestDTO questionAnswerRequestDTO) {
      return null ;
    }


    @Override
    public Optional<QuestionAnswerResponseDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<QuestionAnswerResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
