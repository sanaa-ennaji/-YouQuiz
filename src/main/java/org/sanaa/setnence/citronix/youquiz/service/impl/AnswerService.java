package org.sanaa.setnence.citronix.youquiz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.AnswerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.AnswerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Answer;
import org.sanaa.setnence.citronix.youquiz.model.entity.Level;
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
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found with ID: " + id));
        answerMapper.updateEntityFromRequest(answerRequestDTO , answer);
        Answer updatedAnswer= answerRepository.save(answer);
        return answerMapper.toResponseDTO(updatedAnswer);
    }

    @Override
    public Optional<AnswerResponseDTO> findById(Long id) {
        return answerRepository.findById(id)
                .map(answerMapper::toResponseDTO);
    }

    @Override
    public List<AnswerResponseDTO> findAll() {
        return answerRepository.findAll()
                .stream()
                .map(answerMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if(!answerRepository.existsById(id)){
            throw new  EntityNotFoundException("answer not found with ID: " + id);
        }
        answerRepository.deleteById(id);
    }

    public Answer findEntityById(Long id) {
        return answerRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("answer not found with id "+ id));
    }
}
