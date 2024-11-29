package org.sanaa.setnence.citronix.youquiz.repository;

import org.sanaa.setnence.citronix.youquiz.model.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
