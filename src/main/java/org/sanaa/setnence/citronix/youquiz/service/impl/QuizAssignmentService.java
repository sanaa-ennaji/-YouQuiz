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

    private final QuizAssignmentRepository quizAssignmentRepository ;
    private final QuizAssignmentMapper quizAssignmentMapper;
    private final StudentService studentService;
    private final QuizService quizService;

    public QuizAssignmentService(QuizAssignmentRepository quizAssignmentRepository, QuizAssignmentMapper quizAssignmentMapper, StudentService studentService, QuizService quizService) {
        this.quizAssignmentRepository = quizAssignmentRepository;
        this.quizAssignmentMapper = quizAssignmentMapper;
        this.studentService = studentService;
        this.quizService = quizService;
    }


    @Override
    public QuizAssignmentResponseDTO create(QuizAssignmentRequestDTO quizAssignmentRequestDTO) {
        Quiz quiz = quizService.findEntityById(quizAssignmentRequestDTO.getQuizId());
        Student student = studentService.findEntityById(quizAssignmentRequestDTO.getStudentId());

        int score = calculateScore(student, quiz);
        int result = calculateResult(score, quiz.getPassingScore());
        int attempts = calculateAttempts(student, quiz);

        QuizAssignment quizAssignment = quizAssignmentMapper.toEntity(quizAssignmentRequestDTO);
        quizAssignment.setStudent(student);
        quizAssignment.setQuiz(quiz);
        quizAssignment.setScore(score);
        quizAssignment.setResult(result);
        quizAssignment.setAttempts(attempts);

        QuizAssignment savedAssignment = quizAssignmentRepository.save(quizAssignment);
        return quizAssignmentMapper.toResponseDTO(savedAssignment);
    }


    public int calculateScore(Student student, Quiz quiz) {
        int score = 0;


        List<QuizAssignment> quizAssignments = student.getQuizAssignment();

        QuizAssignment quizAssignment = quizAssignments.stream()
                .filter(assignment -> assignment.getQuiz().equals(quiz))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found for student"));

        List<AnswerValidation> answerValidations = quizAssignment.getAnswerValidation();

        for (AnswerValidation answerValidation : answerValidations) {

            if (answerValidation.getAnswer() != null && answerValidation.getAnswer().isCorrect()) {
                score += answerValidation.getPoints();
            }
        }

        return score;
    }


    public int calculateResult(int score, int passingScore) {
        return score >= passingScore ? 1 : 0;
    }


    public int calculateAttempts(Student student, Quiz quiz) {
        List<QuizAssignment> quizAssignments = student.getQuizAssignment();

        long attempts = quizAssignments.stream()
                .filter(assignment -> assignment.getQuiz().equals(quiz))
                .count();

        return (int) (attempts + 1);
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
}
