package org.sanaa.setnence.citronix.youquiz.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int passingScore;

    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledStart;

    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledEnd;

    @Column(length = 1000)
    private String instructions;

    @Column(length = 1000)
    private String remarks;


}
