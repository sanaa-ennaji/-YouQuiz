package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.LevelRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.LevelResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Level;


import java.util.List;

@Mapper(componentModel = "spring", uses = {QuestionMapper.class, AnswerMapper.class})
public interface LevelMapper {
    LevelResponseDTO toResponseDTO(Level entity);
    Level toEntity (LevelRequestDTO requestDTO);
    List<LevelResponseDTO> toResponseDTOList(List<Level> entities);
    List<Level> toEntityList(List<LevelResponseDTO> requestDTOs);

}
