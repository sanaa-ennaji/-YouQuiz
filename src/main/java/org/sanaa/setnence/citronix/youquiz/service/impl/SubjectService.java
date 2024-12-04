package org.sanaa.setnence.citronix.youquiz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.SubjectRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.SubjectResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Quiz;
import org.sanaa.setnence.citronix.youquiz.model.entity.Subject;
import org.sanaa.setnence.citronix.youquiz.model.mapper.SubjectMapper;
import org.sanaa.setnence.citronix.youquiz.repository.SubjectRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.SubjectServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService implements SubjectServiceI {
 private final SubjectRepository subjectRepository;
 private final SubjectMapper subjectMapper;

    public SubjectService(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public SubjectResponseDTO create(SubjectRequestDTO subjectRequestDTO) {
        Subject subject = subjectMapper.toEntity(subjectRequestDTO);
        Subject savedSubject = subjectRepository.save(subject);
        return subjectMapper.toResponseDTO(savedSubject);
    }

    @Override
    public SubjectResponseDTO update(Long id, SubjectRequestDTO subjectRequestDTO) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found"));

        subjectMapper.updateEntityFromDTO(subjectRequestDTO, subject);
        Subject updatedSubject = subjectRepository.save(subject);

        return subjectMapper.toResponseDTO(updatedSubject);
    }

    @Override
    public Optional<SubjectResponseDTO> findById(Long id) {
        return subjectRepository.findById(id)
                .map(subjectMapper::toResponseDTO);
    }

    @Override
    public List<SubjectResponseDTO> findAll() {
        return subjectRepository.findAll().stream()
                .map(subjectMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }

    public Subject findEntityById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("subject not found with id "+ id));
    }
}
