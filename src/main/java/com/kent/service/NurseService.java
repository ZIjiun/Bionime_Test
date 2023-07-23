package com.kent.service;

import com.kent.domain.Nurse;

import java.util.List;


public interface NurseService {
    /**
     * 新增護士業務
     * @param addItem
     * @return
     */
    Boolean add(Nurse addItem);

    /**
     * 根據 id 刪除護士業務
     * @param id
     * @return
     */
    Boolean deleteById(Integer id);

    /**
     * 修改護士業務
     * @param updateItem
     * @return
     */
    Boolean update(Nurse updateItem);

    /**
     * 根據 id 查詢護士業務
     *
     * @param id
     * @return
     */
    Nurse getById(Integer id);

    /**
     * 查詢所有護士業務
     * @return
     */
    List<Nurse> getAll();
}
