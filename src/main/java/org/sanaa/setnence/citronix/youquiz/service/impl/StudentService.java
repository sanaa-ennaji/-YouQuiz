package org.sanaa.setnence.citronix.youquiz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.StudentRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.StudentResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Student;
import org.sanaa.setnence.citronix.youquiz.model.mapper.StudentMapper;
import org.sanaa.setnence.citronix.youquiz.repository.StudentRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.StudentServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService implements StudentServiceI {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;



    public StudentService(StudentRepository studentRepository,
                          StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    @Override
    public StudentResponseDTO create(StudentRequestDTO studentRequestDTO) {
        Student student = studentMapper.toEntity(studentRequestDTO);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponseDTO(savedStudent);
    }

    @Override
    public StudentResponseDTO update(Long id, StudentRequestDTO studentRequestDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        studentMapper.updateEntityFromRequest(studentRequestDTO, student);
        Student updatedStudent = studentRepository.save(student);

        return studentMapper.toResponseDTO(updatedStudent);
    }

    @Override
    public Optional<StudentResponseDTO> findById(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toResponseDTO);
    }

    @Override
    public List<StudentResponseDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public Student findEntityById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("student not found" + id));
    }
}
