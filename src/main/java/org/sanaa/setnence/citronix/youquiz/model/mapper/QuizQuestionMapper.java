package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuizQuestionRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuizQuestionResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.QuizQuestion;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface QuizQuestionMapper {
    @Mapping(target = "quizId", source = "quiz.id")
    @Mapping(target = "questionId", source = "question.id")
    QuizQuestionResponseDTO toResponseDTO(QuizQuestion entity);
    QuizQuestion toEntity (QuizQuestionRequestDTO requestDTO);
    List<QuizQuestionResponseDTO> toResponseDTOList(List<QuizQuestion> entities);
    List<QuizQuestion> toEntityList(List<QuizQuestionResponseDTO> requestDTOs);

    void updateEntityFromRequest(QuizQuestionRequestDTO quizQuestionRequestDTO,@MappingTarget QuizQuestion quizQuestion);
}
