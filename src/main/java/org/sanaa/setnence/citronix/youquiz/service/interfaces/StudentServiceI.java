package org.sanaa.setnence.citronix.youquiz.service.interfaces;

import org.sanaa.setnence.citronix.youquiz.model.dto.request.StudentRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.StudentResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Student;

public interface StudentServiceI extends GenericServiceI<Student, StudentRequestDTO, StudentResponseDTO> {
}
