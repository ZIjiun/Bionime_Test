package com.kent.service.impl;

import com.kent.dao.MedicalAidStationDao;
import com.kent.domain.MedicalAidStation;
import com.kent.service.MedicalAidStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalAidStationServiceImpl implements MedicalAidStationService {
    @Autowired
    MedicalAidStationDao medicalAidStationDao;

    /**
     * 新增站點業務
     * @param addItem
     * @return
     */
    @Override
    public Boolean add(MedicalAidStation addItem) {
        MedicalAidStation medicalAidStation = new MedicalAidStation();

        medicalAidStation.setStationName(addItem.getStationName());
        MedicalAidStation savedStation = medicalAidStationDao.save(medicalAidStation);
        return savedStation.getId() > 0;
    }

    /**
     * 根據 id 刪除站點業務
     * @param id
     * @return
     */
    @Override
    public Boolean deleteById(Integer id) {
        medicalAidStationDao.deleteById(id);
        return !medicalAidStationDao.existsById(id);
    }

    /**
     * 更新站點業務
     * @param updateItem
     * @return
     */
    @Override
    public Boolean update(MedicalAidStation updateItem) {
        Optional<MedicalAidStation> result = medicalAidStationDao.findById(updateItem.getId());
        if(result.isPresent()) {
            MedicalAidStation medicalAidStation = result.get();
            medicalAidStation.setStationName(updateItem.getStationName());
            MedicalAidStation savedStation = medicalAidStationDao.save(medicalAidStation);
            return savedStation.getId() > 0;
        } else {
            return false;
        }
    }

    /**
     * 根據 id 查詢站點業務
     * @param id
     * @return
     */
    @Override
    public MedicalAidStation getById(Integer id) {
        Optional<MedicalAidStation> result = medicalAidStationDao.findById(id);
        return result.orElse(null);
    }

    /**
     * 查詢所有站點業務
     * @return
     */
    @Override
    public List<MedicalAidStation> getAll() {
        return medicalAidStationDao.findAll();
    }
}
