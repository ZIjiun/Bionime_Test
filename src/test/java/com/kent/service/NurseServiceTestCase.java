package com.kent.service;

import com.kent.dao.NurseDao;
import com.kent.domain.MedicalAidStation;
import com.kent.domain.Nurse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NurseServiceTestCase {

    @Autowired
    private NurseService nurseService;

    @Autowired
    private MedicalAidStationService medicalAidStationService;

    /**
     * 測試護士新增業務
     */
    @Test
    void testAdd() {
        MedicalAidStation existingStation = medicalAidStationService.getById(3);

        Nurse nurse = new Nurse();
        nurse.setEmployeeId("456");
        nurse.setNurseName("nurse2");
        nurse.setStation(existingStation);

        System.out.println(nurseService.add(nurse));
    }

    /**
     * 測試根據 id 刪除護士業務
     */
    @Test
    void testDeleteById() {
        System.out.println(nurseService.deleteById(3));
    }

    /**
     * 測試查詢所有護士業務
     */
    @Test
    void testGetAll() {
        System.out.println(nurseService.getAll());
    }

    /**
     * 測試根據 id 查詢護士業務
     */
    @Test
    void testGetById() {
        System.out.println(nurseService.getById(3));
    }

    /**
     * 測試護士更新業務
     */
    @Test
    void testUpdate() {
        Nurse targetNurse = nurseService.getById(6);
        MedicalAidStation existingStation = medicalAidStationService.getById(1);

        if (targetNurse != null) {
            targetNurse.setNurseName("test_nurse");
            targetNurse.setStation(existingStation);
            System.out.println(nurseService.update(targetNurse));
        } else {
            System.out.println(false);
        }
    }
}