package org.sanaa.setnence.citronix.youquiz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.AnswerValidationRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.AnswerValidationResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.AnswerValidation;
import org.sanaa.setnence.citronix.youquiz.model.entity.Question;
import org.sanaa.setnence.citronix.youquiz.model.entity.QuestionAnswer;
import org.sanaa.setnence.citronix.youquiz.model.mapper.AnswerValidationMapper;
import org.sanaa.setnence.citronix.youquiz.repository.AnswerValidationRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.AnsweValidationServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerValidationService implements AnsweValidationServiceI {

        private final AnswerValidationMapper answerValidationMapper;
        private final QuestionService questionService;
        private final QuestionAnswerService questionAnswerService;
        private final QuizAssignmentService quizAssignmentService;
        private final AnswerValidationRepository answerValidationRepository;

        public AnswerValidationService(AnswerValidationMapper answerValidationMapper, QuestionService questionService,
                                       QuestionAnswerService questionAnswerService, QuizAssignmentService quizAssignmentService, AnswerValidationRepository answerValidationRepository) {
            this.answerValidationMapper = answerValidationMapper;
            this.questionService = questionService;
            this.questionAnswerService = questionAnswerService;
            this.quizAssignmentService = quizAssignmentService;
            this.answerValidationRepository = answerValidationRepository;
        }

        @Override
        public AnswerValidationResponseDTO create(AnswerValidationRequestDTO answerValidationRequestDTO) {
            Question question = questionService.findEntityById(answerValidationRequestDTO.getQuestionId());
            QuestionAnswer questionAnswer = questionAnswerService.findAnswer(
                    answerValidationRequestDTO.getQuestionId(),
                    answerValidationRequestDTO.getAnswerId()
            );


            AnswerValidation answerValidation = answerValidationMapper.toEntity(answerValidationRequestDTO);
            answerValidation.setQuestion(question);
            answerValidation.setAnswer(questionAnswer.getAnswer());
            answerValidation.setPoints(questionAnswer.getPoints());

            Long quizAssignmentId = answerValidationRequestDTO.getQuizAssignmentId();
            quizAssignmentService.addAnswerValidation(quizAssignmentId, answerValidation);

            return answerValidationMapper.toResponseDTO(answerValidationRepository.save(answerValidation));
        }

    @Override
    public AnswerValidationResponseDTO update(Long id, AnswerValidationRequestDTO answerValidationRequestDTO) {
        AnswerValidation answerValidation  = answerValidationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AnswerValidation not found with ID: " + id));
        answerValidationMapper.updateEntityFromRequest(answerValidationRequestDTO , answerValidation);
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
            throw new  EntityNotFoundException("answer validation not found with ID: " + id);
        }
        answerValidationRepository.deleteById(id);

    }
    public AnswerValidation findEntityById(Long id) {
        return answerValidationRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("answer validation not found with id "+ id));
    }
}
