package org.sanaa.setnence.citronix.youquiz.repository;

import org.sanaa.setnence.citronix.youquiz.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
