package org.sanaa.setnence.citronix.youquiz.model.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends User {

    private LocalDate enrollmentDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<QuizAssignment> quizAssignment ;


}
