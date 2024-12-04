package org.sanaa.setnence.citronix.youquiz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuizQuestionRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuizQuestionResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Question;
import org.sanaa.setnence.citronix.youquiz.model.entity.Quiz;
import org.sanaa.setnence.citronix.youquiz.model.entity.QuizQuestion;
import org.sanaa.setnence.citronix.youquiz.model.mapper.QuizQuestionMapper;
import org.sanaa.setnence.citronix.youquiz.repository.QuizQuestionRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.QuizQuestionServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizQuestionService implements QuizQuestionServiceI {
    private final QuizQuestionRepository quizQuestionRepository;
    private final QuizQuestionMapper quizQuestionMapper;
    private final QuestionService questionService;
    private final QuizService quizService;

    public QuizQuestionService(QuizQuestionRepository quizQuestionRepository, QuizQuestionMapper quizQuestionMapper, QuestionService questionService, QuizService quizService) {
        this.quizQuestionRepository = quizQuestionRepository;
        this.quizQuestionMapper = quizQuestionMapper;
        this.questionService = questionService;
        this.quizService = quizService;
    }


    @Override
    public QuizQuestionResponseDTO create(QuizQuestionRequestDTO quizQuestionRequestDTO) {
        Question question = questionService.findEntityById(quizQuestionRequestDTO.getQuestionId());
        Quiz quiz = quizService.findEntityById(quizQuestionRequestDTO.getQuizId());
        QuizQuestion quizQuestion = quizQuestionMapper.toEntity(quizQuestionRequestDTO);
        quizQuestion.setQuestion(question);
        quizQuestion.setQuiz(quiz);

        QuizQuestion savedQuizQuestion = quizQuestionRepository.save(quizQuestion);
        return  quizQuestionMapper.toResponseDTO(savedQuizQuestion);
    }

    @Override
    public QuizQuestionResponseDTO update(Long id, QuizQuestionRequestDTO quizQuestionRequestDTO) {
        QuizQuestion quizQuestion  = quizQuestionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("QuizQuestion not found with ID: " + id));
        quizQuestionMapper.updateEntityFromRequest(quizQuestionRequestDTO , quizQuestion);
        QuizQuestion updatedQuizQuestion = quizQuestionRepository.save(quizQuestion);
        return quizQuestionMapper.toResponseDTO(updatedQuizQuestion);
    }

    @Override
    public Optional<QuizQuestionResponseDTO> findById(Long id) {
        return quizQuestionRepository.findById(id)
                .map(quizQuestionMapper::toResponseDTO);
    }

    @Override
    public List<QuizQuestionResponseDTO> findAll() {
        return quizQuestionRepository.findAll()
                .stream()
                .map(quizQuestionMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if(!quizQuestionRepository.existsById(id)){
            throw new  EntityNotFoundException("Quiz not found with ID: " + id);
        }
        quizQuestionRepository.deleteById(id);
    }
}
