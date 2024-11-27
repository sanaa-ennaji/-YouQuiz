package org.sanaa.setnence.citronix.youquiz.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int attemptNumber;
    private int score;
    private boolean passed;

    @ManyToOne
    private Quiz test;

    @ManyToOne
    private Student student;
}
