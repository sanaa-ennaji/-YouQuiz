package org.sanaa.setnence.citronix.youquiz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.AnswerValidationRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.AnswerValidationResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.AnswerValidation;
import org.sanaa.setnence.citronix.youquiz.model.entity.Question;
import org.sanaa.setnence.citronix.youquiz.model.mapper.AnswerValidationMapper;
import org.sanaa.setnence.citronix.youquiz.repository.AnswerValidationRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.AnsweValidationServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerValidationService implements AnsweValidationServiceI {
    private final AnswerValidationRepository  answerValidationRepository;
    private final AnswerValidationMapper answerValidationMapper;
    private final QuestionService questionService;

    public AnswerValidationService(AnswerValidationRepository answerValidationRepository, AnswerValidationMapper answerValidationMapper, QuestionService questionService) {
        this.answerValidationRepository = answerValidationRepository;
        this.answerValidationMapper = answerValidationMapper;
        this.questionService = questionService;
    }

    @Override
    public AnswerValidationResponseDTO create(AnswerValidationRequestDTO answerValidationRequestDTO) {
        Question question= questionService.findEntityById(answerValidationRequestDTO.getQuestionId());


        AnswerValidation answerValidation = answerValidationMapper.toEntity(answerValidationRequestDTO);
        answerValidation.setQuestion(question);

        AnswerValidation savedAnswerValidation = answerValidationRepository.save(answerValidation);
        return  answerValidationMapper.toResponseDTO(savedAnswerValidation);
    }

    @Override
    public AnswerValidationResponseDTO update(Long id, AnswerValidationRequestDTO answerValidationRequestDTO) {
        AnswerValidation answerValidation  = answerValidationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AnswerValidation not found with ID: " + id));
        answerValidation.updateEntityFromRequest(answerValidation , answerValidation);
        AnswerValidation updatedAnswerValidation = answerValidationRepository.save(answerValidation);
        return answerValidationMapper.toResponseDTO(updatedAnswerValidation);
    }

    @Override
    public Optional<AnswerValidationResponseDTO> findById(Long id) {
        return answerValidationRepository.findById(id)
                .map(answerValidationMapper::toResponseDTO);
    }

    @Override
    public List<AnswerValidationResponseDTO> findAll() {
        return answerValidationRepository.findAll()
                .stream()
                .map(answerValidationMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if(!answerValidationRepository.existsById(id)){
            throw new  EntityNotFoundException("answerValidation not found with ID: " + id);
        }
        answerValidationRepository.deleteById(id);

    }
    public AnswerValidation findEntityById(Long id) {
        return answerValidationRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("answervalidation not found with id "+ id));
    }
}
