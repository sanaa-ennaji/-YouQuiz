package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {QuestionMapper.class, AnswerMapper.class})
public interface LevelMapper {

}
