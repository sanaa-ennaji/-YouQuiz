package org.sanaa.setnence.citronix.youquiz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuestionAnswerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuestionAnswerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.*;
import org.sanaa.setnence.citronix.youquiz.model.mapper.QuestionAnswerMapper;
import org.sanaa.setnence.citronix.youquiz.repository.QuestionAnswerRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.QuestionAnswerServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionAnswerService implements QuestionAnswerServiceI {
    private final QuestionAnswerRepository questionAnswerRepository;
    private final QuestionAnswerMapper questionAnswerMapper;
    private final QuestionService questionService;
    private final AnswerService answerService;

    public QuestionAnswerService(
            QuestionAnswerRepository questionAnswerRepository,
            QuestionAnswerMapper questionAnswerMapper,
            QuestionService questionService,
            AnswerService answerService) {
        this.questionAnswerRepository = questionAnswerRepository;
        this.questionAnswerMapper = questionAnswerMapper;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @Override
    @Transactional
    public QuestionAnswerResponseDTO create(QuestionAnswerRequestDTO questionAnswerRequestDTO) {
        Question question = questionService.findEntityById(questionAnswerRequestDTO.getQuestionId());
        Answer answer = answerService.findEntityById(questionAnswerRequestDTO.getAnswerId());

        QuestionAnswer questionAnswer = questionAnswerMapper.toEntity(questionAnswerRequestDTO);
        questionAnswer.setQuestion(question);
        questionAnswer.setAnswer(answer);

        QuestionAnswer savedQuestionAnswer = questionAnswerRepository.save(questionAnswer);
        return questionAnswerMapper.toResponseDTO(savedQuestionAnswer);
    }

    @Override
    public Optional<QuestionAnswerResponseDTO> findById(Long id) {
        return questionAnswerRepository.findById(id)
                .map(questionAnswerMapper::toResponseDTO);
    }

    @Override
    public List<QuestionAnswerResponseDTO> findAll() {
        return questionAnswerRepository.findAll().stream()
                .map(questionAnswerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!questionAnswerRepository.existsById(id)) {
            throw new EntityNotFoundException("QuestionAnswer not found with ID: " + id);
        }
        questionAnswerRepository.deleteById(id);
    }
}
