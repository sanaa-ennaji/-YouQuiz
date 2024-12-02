package org.sanaa.setnence.citronix.youquiz.service.impl;

import org.sanaa.setnence.citronix.youquiz.model.dto.request.AnswerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.AnswerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Answer;
import org.sanaa.setnence.citronix.youquiz.model.mapper.AnswerMapper;
import org.sanaa.setnence.citronix.youquiz.repository.AnswerRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.AnswerServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService implements AnswerServiceI {


    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    public AnswerService(AnswerRepository answerRepository, AnswerMapper answerMapper) {
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
    }

    @Override
    public AnswerResponseDTO create(AnswerRequestDTO requestDTO) {
        Answer answer = answerMapper.toEntity(requestDTO);
        Answer savedAnswer = answerRepository.save(answer);
        return answerMapper.toResponseDTO(savedAnswer);

    }

    @Override
    public AnswerResponseDTO update(Long id, AnswerRequestDTO answerRequestDTO) {
        return null;
    }

    @Override
    public Optional<AnswerResponseDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<AnswerResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
