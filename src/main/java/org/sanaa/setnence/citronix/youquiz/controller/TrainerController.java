package org.sanaa.setnence.citronix.youquiz.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.TrainerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.TrainerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.service.impl.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainers")
@Validated
@RequiredArgsConstructor
public class TrainerController {
    private final TrainerService trainerService;

    @PostMapping
    public ResponseEntity<TrainerResponseDTO>  create(@Valid @RequestBody TrainerRequestDTO requestDTO){
        TrainerResponseDTO trainerResponseDTO = trainerService.create(requestDTO);
        return new ResponseEntity<>(trainerResponseDTO, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TrainerResponseDTO> update(@PathVariable Long id, @Valid @RequestBody  TrainerRequestDTO requestDTO){
        TrainerResponseDTO responseDTO = trainerService.update(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TrainerResponseDTO> getById(@PathVariable Long id){
        return trainerService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new EntityNotFoundException("trainer not found with id "+ id));
    }

    @GetMapping
    public ResponseEntity<List<TrainerResponseDTO>> getAll(){
        List<TrainerResponseDTO> trainers = trainerService.findAll();
        return ResponseEntity.ok(trainers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        trainerService.delete(id);
        return ResponseEntity.ok("trainer was deleted");
    }
}
