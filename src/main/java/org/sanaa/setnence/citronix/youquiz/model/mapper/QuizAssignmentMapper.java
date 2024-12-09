package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuizAssignmentRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuizAssignmentResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.QuizAssignment;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface QuizAssignmentMapper {
    @Mapping(target = "quizId", source = "quiz.id")
    @Mapping(target = "studentId", source = "student.id")
    QuizAssignmentResponseDTO toResponseDTO(QuizAssignment entity);
    QuizAssignment toEntity (QuizAssignmentRequestDTO requestDTO);
    void updateEntityFromRequest(QuizAssignmentRequestDTO quizAssignmentRequestDTO , @MappingTarget QuizAssignment quizAssignment) ;
    List<QuizAssignmentResponseDTO> toResponseDTOList(List<QuizAssignment> entities);
    List<QuizAssignment> toEntityList(List<QuizAssignmentResponseDTO> requestDTOs);
}
