package org.sanaa.setnence.citronix.youquiz.repository;

import org.sanaa.setnence.citronix.youquiz.model.entity.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {
}
