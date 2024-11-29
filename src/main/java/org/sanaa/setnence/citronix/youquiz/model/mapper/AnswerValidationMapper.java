package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {AnswerMapper.class})
public interface AnswerValidationMapper {


}
