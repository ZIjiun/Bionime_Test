package com.kent.controller;

import com.kent.controller.utils.ReturnFormat;
import com.kent.domain.MedicalAidStation;
import com.kent.service.MedicalAidStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicalAidStation")
public class MedicalAidStationController {
    @Autowired
    private MedicalAidStationService medicalAidStationService;

    /**
     * 取得全部站點
     * @return
     */
    @GetMapping
    public ReturnFormat getAll() {
        return new ReturnFormat(true, medicalAidStationService.getAll());
    }

    /**
     * 新增站點
     * @param medicalAidStation
     * @return
     */
    @PostMapping
    public ReturnFormat add(@RequestBody MedicalAidStation medicalAidStation){
        boolean flag = medicalAidStationService.add(medicalAidStation);
        return new ReturnFormat(flag, flag? "新增成功!":"新增失敗!");
    }

    /**
     * 修改站點
     * @param medicalAidStation
     * @return
     */
    @PutMapping
    public ReturnFormat update(@RequestBody MedicalAidStation medicalAidStation) {
        Boolean flag = medicalAidStationService.update(medicalAidStation);
        return new ReturnFormat(flag, flag? "更新成功":"更新失敗");
    }

    /**
     * 根據 id 刪除站點
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ReturnFormat delete(@PathVariable Integer id) {
        Boolean flag = medicalAidStationService.deleteById(id);
        return new ReturnFormat(flag, flag? "刪除成功": "刪除失敗");
    }

    /**
     * 根據 id 查詢站點
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ReturnFormat getById(@PathVariable Integer id) {
        return new ReturnFormat(true, medicalAidStationService.getById(id));
    }
}
