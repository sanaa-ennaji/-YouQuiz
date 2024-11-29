package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.AnswerValidationRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.AnswerValidationResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.AnswerValidation;


import java.util.List;


@Mapper(componentModel = "spring", uses = {AnswerMapper.class})
public interface AnswerValidationMapper {
    AnswerValidationResponseDTO toResponseDTO(AnswerValidation entity);
    AnswerValidation toEntity (AnswerValidationRequestDTO requestDTO);
    List<AnswerValidationResponseDTO> toResponseDTOList(List<AnswerValidation> entities);
    List<AnswerValidation> toEntityList(List<AnswerValidationResponseDTO> requestDTOs);

}
