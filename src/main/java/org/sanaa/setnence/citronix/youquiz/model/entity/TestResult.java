package org.sanaa.setnence.citronix.youquiz.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Quiz test;

    @ManyToOne
    private Student student;

    private int attemptNumber;
    private int score;
    private boolean passed;
}
