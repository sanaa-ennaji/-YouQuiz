package org.sanaa.setnence.citronix.youquiz.model.entity;

import jakarta.persistence.*;

import java.util.Date;

public class QuizAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;

    private int score ;
    private int result ;


}
