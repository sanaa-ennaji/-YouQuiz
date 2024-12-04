package org.sanaa.setnence.citronix.youquiz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuizAssignmentRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuizAssignmentResponseDTO;
import org.sanaa.setnence.citronix.youquiz.service.impl.QuizAssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quizAssignments")
@Validated
@RequiredArgsConstructor
public class QuizAssingmentController {

    private final QuizAssignmentService quizAssignmentService;
    @PostMapping
    public ResponseEntity<QuizAssignmentResponseDTO> create(@Valid @RequestBody QuizAssignmentRequestDTO quizAssignmentRequestDTO) {
        QuizAssignmentResponseDTO quizResponse = quizAssignmentService.create(quizAssignmentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(quizResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizAssignmentResponseDTO> update(@PathVariable Long id, @Valid @RequestBody QuizAssignmentRequestDTO quizAssignmentRequestDTO) {
        QuizAssignmentResponseDTO updatedQuizAssignment = quizAssignmentService.update(id, quizAssignmentRequestDTO);
        return ResponseEntity.ok(updatedQuizAssignment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizAssignmentResponseDTO> findById(@PathVariable Long id) {
        return quizAssignmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "QuizAssignment not found"));
    }

    @GetMapping
    public ResponseEntity<List<QuizAssignmentResponseDTO>> findAll() {
        List<QuizAssignmentResponseDTO> quizzeAssignments = quizAssignmentService.findAll();
        return ResponseEntity.ok(quizzeAssignments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        quizAssignmentService.delete(id);
        return ResponseEntity.ok("QuizAssignment was deleted");
    }
}
