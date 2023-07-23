package com.kent.service;

import com.kent.domain.MedicalAidStation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MedicalAidStationServiceTestCase {
    @Autowired
    private MedicalAidStationService medicalAidStationService;

    /**
     * 測試站點新增業務
     */
    @Test
    void testAdd() {
        MedicalAidStation medicalAidStation = new MedicalAidStation();
        medicalAidStation.setStationName("s-0209");
        System.out.println(medicalAidStationService.add(medicalAidStation));
    }

    /**
     * 測試根據 id 刪除站點業務
     */
    @Test
    void testDeleteById() {
        System.out.println(medicalAidStationService.deleteById(6));
    }

    /**
     * 測試查詢所有站點業務
     */
    @Test
    void testGetAll() {
        System.out.println(medicalAidStationService.getAll());
    }

    /**
     * 測試根據 id 查詢站點業務
     */
    @Test
    void testGetById() {
        System.out.println(medicalAidStationService.getById(7));
    }

    /**
     * 測試站點更新功能
     */
    @Test
    void testUpdate() {
        MedicalAidStation result = medicalAidStationService.getById(9);
        if (result != null) {
            MedicalAidStation medicalAidStation = new MedicalAidStation();
            medicalAidStation.setId(7);
            medicalAidStation.setStationName("1232");
            System.out.println(medicalAidStationService.update(medicalAidStation));
        } else {
            System.out.println(false);
        }
    }
}