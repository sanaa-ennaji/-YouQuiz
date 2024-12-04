package org.sanaa.setnence.citronix.youquiz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.AnswerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.AnswerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.service.impl.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answers")
@Validated
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    public ResponseEntity<AnswerResponseDTO> create(@Valid @RequestBody AnswerRequestDTO answerRequestDTO) {
        AnswerResponseDTO answerResponse = answerService.create(answerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(answerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO> update(@PathVariable Long id, @Valid @RequestBody AnswerRequestDTO answerRequestDTO) {
        AnswerResponseDTO updatedAnswer = answerService.update(id, answerRequestDTO);
        return ResponseEntity.ok(updatedAnswer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO> findById(@PathVariable Long id) {
        return answerService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Answer not found"));
    }

    @GetMapping
    public ResponseEntity<List<AnswerResponseDTO>> findAll() {
        List<AnswerResponseDTO> answers = answerService.findAll();
        return ResponseEntity.ok(answers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        answerService.delete(id);
        return ResponseEntity.ok("Answer was deleted");
    }

}
