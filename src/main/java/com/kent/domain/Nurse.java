package com.kent.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

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

    @Column(name = "modification_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime modificationTime;

    @PrePersist
    protected void onCreate() {
        // 新增資料前，設置 modificationTime 屬性為當前日期時間
        this.modificationTime = LocalDateTime.now();
        System.out.println(this.modificationTime);
    }

    @PreUpdate
    protected void onUpdate() {
        // 更新資料前，設置 modificationTime 屬性為當前日期時間
        this.modificationTime = LocalDateTime.now();
        System.out.println(this.modificationTime);
    }
}