package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.SubjectRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.SubjectResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Subject;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface SubjectMapper {

    SubjectResponseDTO toResponseDTO (Subject entity);

    Subject toEntity (SubjectRequestDTO requestDTO);
    void updateEntityFromDTO(SubjectRequestDTO dto, @MappingTarget Subject subject);
    List<SubjectResponseDTO> toResponseDTOList(List<Subject> entities);
    List<Subject> toEntityList(List<SubjectResponseDTO> requestDTOs);
}
