package org.mine.patientmanagment.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patients")
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patient_name;
    private Integer age;
    private  Integer weight;
    private String treatment;
}
