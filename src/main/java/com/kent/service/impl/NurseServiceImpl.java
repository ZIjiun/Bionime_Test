package com.kent.service.impl;

import com.kent.dao.NurseDao;
import com.kent.domain.Nurse;
import com.kent.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NurseServiceImpl implements NurseService {

    @Autowired
    private NurseDao nurseDao;

    /**
     * 新增護士業務
     * @param addItem
     @Override
     * @return
     */
    public Boolean add(Nurse addItem) {
        Nurse savedNurse = nurseDao.save(addItem);
        return savedNurse.getId() > 0;
    }

    /**
     * 根據 id 刪除護士業務
     * @param id
     * @return
     */
    @Override
    public Boolean deleteById(Integer id) {
        nurseDao.deleteById(id);
        return !nurseDao.existsById(id);
    }

    /**
     * 更新護士業務
     * @param updateItem
     * @return
     */
    @Override
    public Boolean update(Nurse updateItem) {
        Optional<Nurse> result = nurseDao.findById(updateItem.getId());

        if(result.isPresent()) {
            Nurse savedNurse = nurseDao.save(updateItem);
            return savedNurse.getId() > 0;
        } else {
            return false;
        }
    }

    /**
     * 根據 id 查詢護士業務
     * @param id
     * @return
     */
    @Override
    public Nurse getById(Integer id) {
        Optional<Nurse> result = nurseDao.findById(id);
        return result.orElse(null);
    }

    /**
     * 查詢所有護士業務
     * @return
     */
    @Override
    public List<Nurse> getAll() {
        return nurseDao.findAll();
    }
}
