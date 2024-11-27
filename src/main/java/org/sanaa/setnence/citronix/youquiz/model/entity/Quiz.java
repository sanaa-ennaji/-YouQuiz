package org.sanaa.setnence.citronix.youquiz.model.entity;

import jakarta.persistence.*;


@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int passingScore;
    private Boolean canSeeAnswers;
    private Boolean canSeeResult;
    private int chances;
    @Column(length = 1000)
    private String remark ;

}
