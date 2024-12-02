package org.sanaa.setnence.citronix.youquiz.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Trainer extends User {

    private String specialty;
    @OneToMany(mappedBy = "trainer")
    private List<Quiz> quiz;


}
