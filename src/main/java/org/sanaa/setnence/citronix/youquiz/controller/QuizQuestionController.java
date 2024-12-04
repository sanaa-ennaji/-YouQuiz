package org.sanaa.setnence.citronix.youquiz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuizQuestionRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuizQuestionResponseDTO;
import org.sanaa.setnence.citronix.youquiz.service.impl.QuizQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/api/v1/quizQuestions")
@Validated
@RequiredArgsConstructor
public class QuizQuestionController {
    private final QuizQuestionService quizQuestionService;

    @PostMapping
    public ResponseEntity<QuizQuestionResponseDTO> create(@Valid @RequestBody QuizQuestionRequestDTO quizQuestionRequestDTO) {
        QuizQuestionResponseDTO quizQuestionResponse = quizQuestionService.create(quizQuestionRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(quizQuestionResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizQuestionResponseDTO> update(@PathVariable Long id, @Valid @RequestBody QuizQuestionRequestDTO quizQuestionRequestDTO) {
        QuizQuestionResponseDTO updatedQuizQuestion = quizQuestionService.update(id, quizQuestionRequestDTO);
        return ResponseEntity.ok(updatedQuizQuestion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizQuestionResponseDTO> findById(@PathVariable Long id) {
        return quizQuestionService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "QuizQuestion not found"));
    }

    @GetMapping
    public ResponseEntity<List<QuizQuestionResponseDTO>> findAll() {
        List<QuizQuestionResponseDTO> quizQuestions = quizQuestionService.findAll();
        return ResponseEntity.ok(quizQuestions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        quizQuestionService.delete(id);
        return ResponseEntity.ok("QuizQuestion was deleted");
    }
}
