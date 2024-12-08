package org.sanaa.setnence.citronix.youquiz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuestionRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuestionResponseDTO;
import org.sanaa.setnence.citronix.youquiz.service.impl.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
@Validated
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionResponseDTO> create(@Valid @RequestBody QuestionRequestDTO questionRequestDTO) {
        QuestionResponseDTO questionResponse = questionService.create(questionRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(questionResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> update(@PathVariable Long id, @Valid @RequestBody QuestionRequestDTO questionRequestDTO) {
        QuestionResponseDTO updatedQuestion = questionService.update(id, questionRequestDTO);
        return ResponseEntity.ok(updatedQuestion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> findById(@PathVariable Long id) {
        return questionService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found"));
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> findAll() {
        List<QuestionResponseDTO> questions = questionService.findAll();
        return ResponseEntity.ok(questions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        questionService.delete(id);
        return ResponseEntity.ok("Question was deleted");
    }

}
