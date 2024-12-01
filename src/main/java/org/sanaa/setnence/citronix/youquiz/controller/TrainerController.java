package org.sanaa.setnence.citronix.youquiz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.TrainerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.TrainerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.service.impl.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/trainers")
@Validated
@RequiredArgsConstructor
public class TrainerController {
    private final TrainerService trainerService;

    public ResponseEntity<TrainerResponseDTO>  create(@Valid @RequestBody TrainerRequestDTO requestDTO){
        TrainerResponseDTO trainerResponseDTO = trainerService.create(requestDTO);
        return new ResponseEntity<>(trainerResponseDTO, HttpStatus.CREATED);
    }


}
