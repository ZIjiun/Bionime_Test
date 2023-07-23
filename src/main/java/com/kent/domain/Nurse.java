package com.kent.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "nurse")
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nurse_name", nullable = false, length = 10)
    private String nurseName;

    @Column(name = "employee_id", nullable = false, length = 10)
    private String employeeId;

    // 護士和站點是多對一的關係
    @ManyToOne
    @JoinColumn(name = "station_id", referencedColumnName = "id")
    private MedicalAidStation station;
}