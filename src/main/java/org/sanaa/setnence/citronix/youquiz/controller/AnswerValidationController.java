package org.sanaa.setnence.citronix.youquiz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.AnswerValidationRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.AnswerValidationResponseDTO;
import org.sanaa.setnence.citronix.youquiz.service.impl.AnswerValidationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answer_validations")
@Validated
@RequiredArgsConstructor
public class AnswerValidationController {

    private final AnswerValidationService answerValidationService;

    @PostMapping
    public ResponseEntity<AnswerValidationResponseDTO> create(@Valid @RequestBody AnswerValidationRequestDTO answerValidationRequestDTO) {
        AnswerValidationResponseDTO answerValidationResponse = answerValidationService.create(answerValidationRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(answerValidationResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerValidationResponseDTO> update(@PathVariable Long id, @Valid @RequestBody AnswerValidationRequestDTO answerValidationRequestDTO) {
        AnswerValidationResponseDTO updatedAnswerValidation = answerValidationService.update(id, answerValidationRequestDTO);
        return ResponseEntity.ok(updatedAnswerValidation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerValidationResponseDTO> findById(@PathVariable Long id) {
        return answerValidationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "AnswerValidation not found"));
    }

    @GetMapping
    public ResponseEntity<List<AnswerValidationResponseDTO>> findAll() {
        List<AnswerValidationResponseDTO> answers = answerValidationService.findAll();
        return ResponseEntity.ok(answers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        answerValidationService.delete(id);
        return ResponseEntity.ok("AnswerValidation was deleted");
    }


}
