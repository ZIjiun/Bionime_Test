package com.kent.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "medical_aid_station")
public class MedicalAidStation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "station_name", nullable = false, length = 50)
    private String stationName;

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
