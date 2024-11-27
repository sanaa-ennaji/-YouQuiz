package org.sanaa.setnence.citronix.youquiz.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    private int passingScore;
    private Boolean canSeeAnswers;
    private Boolean canSeeResult;
    private int chances;
    @Column(length = 1000)
    private String remark ;

}
