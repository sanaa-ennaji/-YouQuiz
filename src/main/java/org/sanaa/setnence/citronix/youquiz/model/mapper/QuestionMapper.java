package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuestionRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuestionResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Question;

import java.util.List;
@Mapper(componentModel = "spring", uses = {AnswerMapper.class})
public interface QuestionMapper {
    QuestionResponseDTO toResponseDTO(Question entity);
    Question toEntity (QuestionRequestDTO requestDTO);
    List<QuestionResponseDTO> toResponseDTOList(List<Question> entities);
    List<Question> toEntityList(List<QuestionResponseDTO> requestDTOs);
}
