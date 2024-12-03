package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuizRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuizResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Quiz;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface QuizMapper {
    @Mapping(target = "trainerId", source = "trainer.id")
    QuizResponseDTO toResponseDTO(Quiz entity);
    Quiz toEntity (QuizRequestDTO requestDTO);
    void updateEntityFromRequest(QuizRequestDTO quizRequestDTO, @MappingTarget Quiz quiz);
    List<QuizResponseDTO> toResponseDTOList(List<Quiz> entities);
    List<Quiz> toEntityList(List<QuizResponseDTO> requestDTOs);
}
