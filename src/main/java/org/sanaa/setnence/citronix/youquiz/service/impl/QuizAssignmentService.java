package org.sanaa.setnence.citronix.youquiz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuizAssignmentRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuizAssignmentResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.*;
import org.sanaa.setnence.citronix.youquiz.model.mapper.QuizAssignmentMapper;
import org.sanaa.setnence.citronix.youquiz.repository.QuizAssignmentRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.QuizAssignmentServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizAssignmentService implements QuizAssignmentServiceI {

    private final QuizService quizService;
    private final StudentService studentService;
    private final QuizAssignmentMapper quizAssignmentMapper;
    private final QuizAssignmentRepository quizAssignmentRepository;

    public QuizAssignmentService(QuizService quizService, StudentService studentService, QuizAssignmentMapper quizAssignmentMapper, QuizAssignmentRepository quizAssignmentRepository) {
        this.quizService = quizService;
        this.studentService = studentService;
        this.quizAssignmentMapper = quizAssignmentMapper;
        this.quizAssignmentRepository = quizAssignmentRepository;
    }

    @Override
    public QuizAssignmentResponseDTO create(QuizAssignmentRequestDTO quizAssignmentRequestDTO) {
        Quiz quiz = quizService.findEntityById(quizAssignmentRequestDTO.getQuizId());
        Student student = studentService.findEntityById(quizAssignmentRequestDTO.getStudentId());
        QuizAssignment quizAssignment = quizAssignmentMapper.toEntity(quizAssignmentRequestDTO);
        quizAssignment.setQuiz(quiz);
        quizAssignment.setStudent(student);
        quizAssignment.setAttempts(1);
        quizAssignment.setScore(0);
        quizAssignment.setResult(0);

        return quizAssignmentMapper.toResponseDTO(quizAssignmentRepository.save(quizAssignment));
    }

    public void addAnswerValidation(Long quizAssignmentId, AnswerValidation answerValidation) {
        QuizAssignment quizAssignment = quizAssignmentRepository.findById(quizAssignmentId)
                .orElseThrow(() -> new EntityNotFoundException("QuizAssignment not found"));

        quizAssignment.getAnswerValidation().add(answerValidation);
        quizAssignment.setScore(quizAssignment.getScore() + answerValidation.getPoints());
    }




    @Override
    public QuizAssignmentResponseDTO update(Long id, QuizAssignmentRequestDTO quizAssignmentRequestDTO) {
        QuizAssignment quizAssignment  = quizAssignmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found with ID: " + id));
        quizAssignmentMapper.updateEntityFromRequest(quizAssignmentRequestDTO , quizAssignment);
        QuizAssignment updatedQuizAssignment = quizAssignmentRepository.save(quizAssignment);
        return quizAssignmentMapper.toResponseDTO(updatedQuizAssignment);
    }

    @Override
    public Optional<QuizAssignmentResponseDTO> findById(Long id) {
        return quizAssignmentRepository.findById(id)
                .map(quizAssignmentMapper::toResponseDTO);
    }

    @Override
    public List<QuizAssignmentResponseDTO> findAll() {
        return quizAssignmentRepository.findAll()
                .stream()
                .map(quizAssignmentMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if(!quizAssignmentRepository.existsById(id)){
            throw new EntityNotFoundException("quizAssignment not found with id " +id);
        }
     quizAssignmentRepository.deleteById(id);
    }
    public QuizAssignment findEntityById(Long id) {
        return quizAssignmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("QuizAssignment not found for id: " + id));
    }

}
