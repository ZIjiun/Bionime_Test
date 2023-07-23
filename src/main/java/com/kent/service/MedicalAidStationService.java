package com.kent.service;

import com.kent.domain.MedicalAidStation;

import java.util.List;
import java.util.Optional;

public interface MedicalAidStationService {

    /**
     * 新增站點業務
     * @param addItem
     * @return
     */
    Boolean add(MedicalAidStation addItem);

    /**
     * 根據 id 刪除站點業務
     * @param id
     * @return
     */
    Boolean deleteById(Integer id);

    /**
     * 修改站點業務
     * @param updateItem
     * @return
     */
    Boolean update(MedicalAidStation updateItem);

    /**
     * 根據 id 查詢站點業務
     *
     * @param id
     * @return
     */
    MedicalAidStation getById(Integer id);

    /**
     * 查詢所有站點業務
     * @return
     */
    List<MedicalAidStation> getAll();
}
