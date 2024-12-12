package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.AnswerValidationRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.AnswerValidationResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.AnswerValidation;


import java.util.List;


@Mapper(componentModel = "spring", uses = {AnswerMapper.class})
public interface AnswerValidationMapper {
    @Mapping(target = "questionId", source = "question.id")
    @Mapping(target = "answerId", source = "answer.id")
    @Mapping(target = "quizAssignmentId", source = "quizAssignment.id")
    AnswerValidationResponseDTO toResponseDTO(AnswerValidation answerValidation);

    AnswerValidation toEntity(AnswerValidationRequestDTO requestDTO);

    List<AnswerValidationResponseDTO> toResponseDTOList(List<AnswerValidation> entities);

    List<AnswerValidation> toEntityList(List<AnswerValidationResponseDTO> requestDTOs);

    void updateEntityFromRequest(AnswerValidationRequestDTO answerValidationRequestDTO, @MappingTarget AnswerValidation answerValidation);
}

