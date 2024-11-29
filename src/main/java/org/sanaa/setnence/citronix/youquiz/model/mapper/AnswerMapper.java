package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.AnswerRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.AnswerResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Answer;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface AnswerMapper {
    AnswerResponseDTO toResponseDTO(Answer entity) ;
    Answer toEntity(AnswerRequestDTO requestDTO);
    List<AnswerResponseDTO> toResponseDTOList (List<Answer> entities);
    List<Answer> toEntityList(List<AnswerRequestDTO> requestDTOs);
}
