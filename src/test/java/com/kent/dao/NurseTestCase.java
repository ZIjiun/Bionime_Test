package com.kent.dao;

import com.kent.domain.MedicalAidStation;
import com.kent.domain.Nurse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class NurseTestCase {

    @Autowired
    private NurseDao nurseDao;

    @Autowired
    private MedicalAidStationDao medicalAidStationDao;

    /**
     * 測試護士新增功能
     */
    @Test
    void testSave() {
        MedicalAidStation existingStation = medicalAidStationDao.findById(1).orElse(null);

        if (existingStation != null) {
            Nurse nurse = new Nurse();
            nurse.setNurseName("nurse_1");
            nurse.setEmployeeId("123");
            nurse.setStation(existingStation);
            nurseDao.save(nurse);
        }
    }

    /**
     * 測試護士資訊更新功能
     */
    @Test
    void testupdate() {
        Optional<Nurse> optionalNurse = nurseDao.findById(3);
        // 如果已經存在，則進行更新
        if (optionalNurse.isPresent()) {
            Nurse nurse = optionalNurse.get();
            nurseDao.save(nurse);
        } else {
            // 如果不存在，提示不存在
            System.out.println("not exist");
        }
    }

    /**
     * 測試根據 id 移除護士
     */
    @Test
    void testDeleteById() {
        nurseDao.deleteById(1);
    }

    /**
     * 測試查詢所有護士
     */
    @Test
    void testSelectAll() {
        System.out.println(nurseDao.findAll());
    }

    /**
     * 測試根據 id 查詢站點
     */
    @Test
    void testSelectById() {
        System.out.println(medicalAidStationDao.findById(1));
    }
}