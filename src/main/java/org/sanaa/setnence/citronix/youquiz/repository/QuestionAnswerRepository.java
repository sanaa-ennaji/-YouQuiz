package org.sanaa.setnence.citronix.youquiz.repository;


import org.sanaa.setnence.citronix.youquiz.model.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {
}
