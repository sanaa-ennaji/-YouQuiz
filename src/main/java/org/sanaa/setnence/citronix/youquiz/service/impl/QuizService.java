package org.sanaa.setnence.citronix.youquiz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuizRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuizResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Quiz;
import org.sanaa.setnence.citronix.youquiz.model.mapper.QuizMapper;
import org.sanaa.setnence.citronix.youquiz.repository.QuizRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.QuizServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService implements QuizServiceI {

    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    public QuizService(QuizRepository quizRepository, QuizMapper quizMapper) {
        this.quizRepository = quizRepository;
        this.quizMapper = quizMapper;
    }

    @Override
    public QuizResponseDTO create(QuizRequestDTO quizRequestDTO) {
        Quiz  quiz = quizMapper.toEntity(quizRequestDTO);
        Quiz savedQuiz = quizRepository.save(quiz);
        return  quizMapper.toResponseDTO(savedQuiz);
    }

    @Override
    public QuizResponseDTO update(Long id, QuizRequestDTO quizRequestDTO) {
        Quiz quiz  = quizRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found with ID: " + id));
         quizMapper.updateEntityFromRequest(quizRequestDTO , quiz);
         Quiz updatedQuiz = quizRepository.save(quiz);
        return quizMapper.toResponseDTO(updatedQuiz);
    }

    @Override
    public Optional<QuizResponseDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<QuizResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
