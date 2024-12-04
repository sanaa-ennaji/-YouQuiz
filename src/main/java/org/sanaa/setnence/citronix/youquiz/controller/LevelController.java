package org.sanaa.setnence.citronix.youquiz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.AnswerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.LevelRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.AnswerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.LevelResponseDTO;
import org.sanaa.setnence.citronix.youquiz.service.impl.AnswerService;
import org.sanaa.setnence.citronix.youquiz.service.impl.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Levels")
@Validated
@RequiredArgsConstructor
public class LevelController {
    private final LevelService levelService;

    @PostMapping
    public ResponseEntity<LevelResponseDTO> create(@Valid @RequestBody LevelRequestDTO levelRequestDTO) {
        LevelResponseDTO levelResponse = levelService.create(levelRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(levelResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LevelResponseDTO> update(@PathVariable Long id, @Valid @RequestBody LevelRequestDTO levelRequestDTO) {
        LevelResponseDTO updatedLevel = levelService.update(id, levelRequestDTO);
        return ResponseEntity.ok(updatedLevel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LevelResponseDTO> findById(@PathVariable Long id) {
        return levelService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "level not found"));
    }

    @GetMapping
    public ResponseEntity<List<LevelResponseDTO>> findAll() {
        List<LevelResponseDTO> levels = levelService.findAll();
        return ResponseEntity.ok(levels);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        levelService.delete(id);
        return ResponseEntity.ok("Level was deleted");
    }
}
