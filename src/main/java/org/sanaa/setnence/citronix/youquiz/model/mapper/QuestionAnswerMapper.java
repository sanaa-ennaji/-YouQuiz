package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuestionAnswerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuestionAnswerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.QuestionAnswer;


import java.util.List;

@Mapper(componentModel = "spring" )
public interface QuestionAnswerMapper {
    @Mapping(target = "questionId", source = "question.id")
    @Mapping(target = "answerId", source = "answer.id")
    QuestionAnswerResponseDTO toResponseDTO(QuestionAnswer entity);
    QuestionAnswer toEntity (QuestionAnswerRequestDTO requestDTO);
    List<QuestionAnswerResponseDTO> toResponseDTOList(List<QuestionAnswer> entities);
    List<QuestionAnswer> toEntityList(List<QuestionAnswerResponseDTO> requestDTOs);

}
