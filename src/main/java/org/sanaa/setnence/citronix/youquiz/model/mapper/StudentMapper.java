package org.sanaa.setnence.citronix.youquiz.model.mapper;

import org.mapstruct.Mapper;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.StudentRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.StudentResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Student;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface StudentMapper {

    StudentResponseDTO toResponseDTO(Student entity);
    Student toEntity (StudentRequestDTO requestDTO);
    List<StudentResponseDTO> toResponseDTOList(List<Student> entities);
    List<Student> toEntityList(List<StudentResponseDTO> requestDTOs);
}
