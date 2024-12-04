package org.sanaa.setnence.citronix.youquiz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuestionAnswerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuestionAnswerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.service.impl.QuestionAnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/api/v1/questions_answers")
@Validated
@RequiredArgsConstructor
public class QuestionAnswerController {
    private final QuestionAnswerService questionAnswerService;

    @PostMapping
    public ResponseEntity<QuestionAnswerResponseDTO> create(@Valid @RequestBody QuestionAnswerRequestDTO questionAnswerRequestDTO) {
        QuestionAnswerResponseDTO questionAnswerResponse = questionAnswerService.create(questionAnswerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(questionAnswerResponse);
    }


    @GetMapping("/{id}")
    public ResponseEntity<QuestionAnswerResponseDTO> findById(@PathVariable Long id) {
        return questionAnswerService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "QuestionAnswer not found"));
    }

    @GetMapping
    public ResponseEntity<List<QuestionAnswerResponseDTO>> findAll() {
        List<QuestionAnswerResponseDTO> quizzes = questionAnswerService.findAll();
        return ResponseEntity.ok(quizzes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        questionAnswerService.delete(id);
        return ResponseEntity.ok("QuestionAnswer was deleted");
    }
}
