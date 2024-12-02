package org.sanaa.setnence.citronix.youquiz.service.impl;

import org.sanaa.setnence.citronix.youquiz.model.dto.request.TrainerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.TrainerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Trainer;
import org.sanaa.setnence.citronix.youquiz.model.mapper.TrainerMapper;
import org.sanaa.setnence.citronix.youquiz.repository.TrainerRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.TrainerServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService implements TrainerServiceI  {
    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper ;

    public TrainerService(TrainerRepository trainerRepository, TrainerMapper trainerMapper) {
        this.trainerRepository = trainerRepository;
        this.trainerMapper = trainerMapper;
    }

    @Override
    public TrainerResponseDTO create (TrainerRequestDTO requestDTO) {
        Trainer trainer = trainerMapper.toEntity(requestDTO);
        Trainer savedTrainer =  trainerRepository.save(trainer);
        return trainerMapper.toResponseDTO(savedTrainer) ;
    }

    @Override
    public TrainerResponseDTO update(Long id, TrainerRequestDTO trainerRequestDTO) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Trainer not found with id : " + id));
        trainerMapper.updateEntityFromDTO(trainerRequestDTO , trainer);
        Trainer updatedTrainer = trainerRepository.save(trainer);
        return trainerMapper.toResponseDTO(updatedTrainer);

    }

    @Override
    public Optional<TrainerResponseDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<TrainerResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
