package com.kent.dao;

import com.kent.domain.MedicalAidStation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class MedicalAidStationTestCase {

    @Autowired
    private MedicalAidStationDao medicalAidStationDao;

    /**
     * 測試站點新增功能
     */
    @Test
    void testSave() {
        MedicalAidStation medicalAidStation = new MedicalAidStation();
        medicalAidStation.setStationName("station_1");
        medicalAidStationDao.save(medicalAidStation);
    }

    /**
     * 測試站點更新功能
     */
    @Test
    void testupdate() {
        Optional<MedicalAidStation> optionalStation = medicalAidStationDao.findById(2);
        // 如果已經存在，則進行更新
        if (optionalStation.isPresent()) {
            MedicalAidStation medicalAidStation = optionalStation.get();
            medicalAidStation.setStationName("st_0722");
            medicalAidStationDao.save(medicalAidStation);
        } else {
            // 如果不存在，提示不存在
            System.out.println("not exist");
        }
    }

    /**
     * 測試根據 id 刪除站點
     */
    @Test
    void testDeleteById() {
        medicalAidStationDao.deleteById(1);
    }

    /**
     * 測試查詢所有站點
     */
    @Test
    void testSelectAll() {
        System.out.println(medicalAidStationDao.findAll());
    }

    /**
     * 測試根據 id 查詢站點
     */
    @Test
    void testSelectById() {
        System.out.println(medicalAidStationDao.findById(1));
    }
}