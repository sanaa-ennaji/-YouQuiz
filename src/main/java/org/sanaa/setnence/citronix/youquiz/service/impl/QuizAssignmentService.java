package org.sanaa.setnence.citronix.youquiz.service.impl;

import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuizAssignmentRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuizAssignmentResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.QuizAssignment;
import org.sanaa.setnence.citronix.youquiz.model.entity.Student;
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
        QuizAssignment quiz = quizService.findEntityById(quizAssignmentRequestDTO.getQuizId());
     Student student = studentService.findEntityById(quizAssignmentRequestDTO.getQuizId());
        QuizAssignmentMapper.updateEntityFromRequest(, )
        return null;
    }

    @Override
    public QuizAssignmentResponseDTO update(Long id, QuizAssignmentRequestDTO quizAssignmentRequestDTO) {
        return null;
    }

    @Override
    public Optional<QuizAssignmentResponseDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<QuizAssignmentResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
