package org.sanaa.setnence.citronix.youquiz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuizRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuizResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.TrainerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Quiz;
import org.sanaa.setnence.citronix.youquiz.model.entity.Trainer;
import org.sanaa.setnence.citronix.youquiz.model.mapper.QuizMapper;
import org.sanaa.setnence.citronix.youquiz.repository.QuizRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.QuizServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//@Transactional
@Service
public class QuizService implements QuizServiceI {

    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;
    private final TrainerService trainerService ;

    public QuizService(QuizRepository quizRepository, QuizMapper quizMapper, TrainerService trainerService) {
        this.quizRepository = quizRepository;
        this.quizMapper = quizMapper;
        this.trainerService = trainerService;
    }

    @Override
    public QuizResponseDTO create(QuizRequestDTO quizRequestDTO) {
        Trainer trainer = trainerService.findEntityById(quizRequestDTO.getTrainerId());

        Quiz quiz = quizMapper.toEntity(quizRequestDTO);
        quiz.setTrainer(trainer);

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
        return quizRepository.findById(id)
                .map(quizMapper::toResponseDTO);
    }

    @Override
    public List<QuizResponseDTO> findAll() {
        return quizRepository.findAll()
                .stream()
                .map(quizMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if(!quizRepository.existsById(id)){
            throw new  EntityNotFoundException("Quiz not found with ID: " + id);
        }
      quizRepository.deleteById(id);
    }
}
