package org.sanaa.setnence.citronix.youquiz.model.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class Student extends User {

    private LocalDate enrollmentDate;

}
