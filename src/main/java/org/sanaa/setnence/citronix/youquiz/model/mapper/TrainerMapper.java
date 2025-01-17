package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.TrainerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.TrainerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Trainer;


import java.util.List;

@Mapper(componentModel = "spring" )
public interface TrainerMapper {
    TrainerResponseDTO toResponseDTO(Trainer entity);
    Trainer toEntity (TrainerRequestDTO requestDTO);
    void updateEntityFromDTO(TrainerRequestDTO dto, @MappingTarget Trainer trainer);
    List<TrainerResponseDTO> toResponseDTOList(List<Trainer> entities);
    List<Trainer> toEntityList(List<TrainerResponseDTO> requestDTOs);
}
