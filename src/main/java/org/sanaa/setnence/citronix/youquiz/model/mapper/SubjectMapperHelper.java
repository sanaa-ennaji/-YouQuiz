package org.sanaa.setnence.citronix.youquiz.model.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.sanaa.setnence.citronix.youquiz.model.entity.Subject;
import org.sanaa.setnence.citronix.youquiz.repository.SubjectRepository;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapperHelper {

    private final SubjectRepository subjectRepository;

    public SubjectMapperHelper(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject mapParentSubject(Long parentSubjectId) {
        if (parentSubjectId == null) {
            return null;
        }
        return subjectRepository.findById(parentSubjectId)
                .orElseThrow(() -> new EntityNotFoundException("Parent Subject not found with ID: " + parentSubjectId));
    }
}
