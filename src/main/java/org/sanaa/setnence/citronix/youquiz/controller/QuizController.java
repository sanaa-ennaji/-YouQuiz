package org.sanaa.setnence.citronix.youquiz.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuizRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuizResponseDTO;
import org.sanaa.setnence.citronix.youquiz.service.impl.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quizzes")
@Validated
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping
    public ResponseEntity<QuizResponseDTO> create(@Valid @RequestBody QuizRequestDTO quizRequestDTO) {
        QuizResponseDTO quizResponse = quizService.create(quizRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(quizResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizResponseDTO> update(@PathVariable Long id, @Valid @RequestBody QuizRequestDTO quizRequestDTO) {
        QuizResponseDTO updatedQuiz = quizService.update(id, quizRequestDTO);
        return ResponseEntity.ok(updatedQuiz);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizResponseDTO> findById(@PathVariable Long id) {
        return quizService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found"));
    }

    @GetMapping
    public ResponseEntity<List<QuizResponseDTO>> findAll() {
        List<QuizResponseDTO> quizzes = quizService.findAll();
        return ResponseEntity.ok(quizzes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        quizService.delete(id);
        return ResponseEntity.ok("Quiz was deleted");
    }
}
