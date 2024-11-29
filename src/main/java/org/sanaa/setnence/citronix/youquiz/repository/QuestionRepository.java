package org.sanaa.setnence.citronix.youquiz.repository;

import org.sanaa.setnence.citronix.youquiz.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
