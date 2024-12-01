package org.sanaa.setnence.citronix.youquiz.service.impl;

import org.sanaa.setnence.citronix.youquiz.model.dto.request.TrainerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.TrainerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.mapper.TrainerMapper;
import org.sanaa.setnence.citronix.youquiz.repository.TrainerRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.TrainerServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService implements TrainerServiceI  {
    private TrainerRepository trainerRepository;
    private TrainerMapper trainerMapper ;

    @Override
    public TrainerResponseDTO create (TrainerRequestDTO requestDTO) {
       return null ;
    }

    @Override
    public TrainerResponseDTO update(Long id, TrainerRequestDTO trainerRequestDTO) {
        return null;
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
