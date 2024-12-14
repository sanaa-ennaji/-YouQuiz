package org.sanaa.setnence.citronix.youquiz.ServiceTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuizRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuizResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Quiz;
import org.sanaa.setnence.citronix.youquiz.model.entity.Trainer;
import org.sanaa.setnence.citronix.youquiz.model.mapper.QuizMapper;
import org.sanaa.setnence.citronix.youquiz.repository.QuizRepository;
import org.sanaa.setnence.citronix.youquiz.service.impl.QuizService;
import org.sanaa.setnence.citronix.youquiz.service.impl.TrainerService;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class QuizServiceTest {

    @Mock
    private QuizRepository quizRepository;

    @Mock
    private QuizMapper quizMapper;

    @Mock
    private TrainerService trainerService;

    @InjectMocks
    private QuizService quizService;

    private QuizRequestDTO quizRequestDTO;
    private Quiz quiz;
    private QuizResponseDTO quizResponseDTO;

    @BeforeEach
    public void setUp() {

        quizRequestDTO = new QuizRequestDTO();
        quizRequestDTO.setTitle("Java Quiz");
        quizRequestDTO.setPassingScore(80);
        quizRequestDTO.setCanSeeAnswers(true);
        quizRequestDTO.setCanSeeResult(true);
        quizRequestDTO.setChances(3);
        quizRequestDTO.setRemark("This is a Java quiz");
        quizRequestDTO.setTrainerId(1L);


        quiz = new Quiz();
        quiz.setId(1L);
        quiz.setTitle("Java Quiz");
        quiz.setPassingScore(80);
        quiz.setCanSeeAnswers(true);
        quiz.setCanSeeResult(true);
        quiz.setChances(3);
        quiz.setRemark("This is a Java quiz");


        quizResponseDTO = new QuizResponseDTO();
        quizResponseDTO.setId(1L);
        quizResponseDTO.setTitle("Java Quiz");
        quizResponseDTO.setPassingScore(80);
        quizResponseDTO.setCanSeeAnswers(true);
        quizResponseDTO.setCanSeeResult(true);
        quizResponseDTO.setChances(3);
        quizResponseDTO.setRemark("This is a Java quiz");
    }

    @Test
    public void testCreate() {

        when(trainerService.findEntityById(anyLong())).thenReturn(new Trainer());
        when(quizMapper.toEntity(any(QuizRequestDTO.class))).thenReturn(quiz);
        when(quizRepository.save(any(Quiz.class))).thenReturn(quiz);
        when(quizMapper.toResponseDTO(any(Quiz.class))).thenReturn(quizResponseDTO);

        QuizResponseDTO result = quizService.create(quizRequestDTO);


        assertThat(result)
                .isNotNull()
                .extracting(QuizResponseDTO::getTitle, QuizResponseDTO::getPassingScore)
                .containsExactly("Java Quiz", 80);

        verify(trainerService, times(1)).findEntityById(anyLong());
        verify(quizMapper, times(1)).toEntity(any(QuizRequestDTO.class));
        verify(quizRepository, times(1)).save(any(Quiz.class));
        verify(quizMapper, times(1)).toResponseDTO(any(Quiz.class));
        verifyNoMoreInteractions(trainerService, quizMapper, quizRepository);
    }

    @Test
    public void CreateQuiz() {

        when(trainerService.findEntityById(anyLong())).thenReturn(new Trainer());
        when(quizMapper.toEntity(any(QuizRequestDTO.class))).thenReturn(quiz);
        when(quizRepository.save(any(Quiz.class))).thenThrow(new RuntimeException("Database error"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> quizService.create(quizRequestDTO));

        assertThat(exception).hasMessage("Database error");

        verify(trainerService, times(1)).findEntityById(anyLong());
        verify(quizMapper, times(1)).toEntity(any(QuizRequestDTO.class));
        verify(quizRepository, times(1)).save(any(Quiz.class));
        verifyNoMoreInteractions(trainerService, quizMapper, quizRepository);
    }


    @Test
    public void NotFound() {

        when(quizRepository.findById(anyLong())).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
                () -> quizService.update(1L, quizRequestDTO));
        assertThat(exception).hasMessage("Quiz not found with ID: 1");

        verify(quizRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(quizRepository);
    }
}
