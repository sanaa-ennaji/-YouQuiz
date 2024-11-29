package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuizAssignmentRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuizAssignmentResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.QuizAssignment;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface QuizAssignmentMapper {
    QuizAssignmentResponseDTO toResponseDTO(QuizAssignment entity);
    QuizAssignment toEntity (QuizAssignmentRequestDTO requestDTO);
    List<QuizAssignmentResponseDTO> toResponseDTOList(List<QuizAssignment> entities);
    List<QuizAssignment> toEntityList(List<QuizAssignmentResponseDTO> requestDTOs);
}
