package org.sanaa.setnence.citronix.youquiz.repository;


import org.sanaa.setnence.citronix.youquiz.model.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {
    Optional<QuestionAnswer> findByQuestionIdAndAnswerId(Long questionId, Long answerId);
}
