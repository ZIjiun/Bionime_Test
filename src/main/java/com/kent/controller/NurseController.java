package com.kent.controller;

import com.kent.controller.utils.ReturnFormat;
import com.kent.domain.Nurse;
import com.kent.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    @Autowired
    private NurseService nurseService;

    /**
     * 取得全部護士
     * @return
     */
    @GetMapping
    public ReturnFormat getAll() {
        return new ReturnFormat(true, nurseService.getAll());
    }

    /**
     * 新增護士
     * @param nurse
     * @return
     */
    @PostMapping
    public ReturnFormat add(@RequestBody Nurse nurse){
        System.out.println(nurse);
        boolean flag = nurseService.add(nurse);
        System.out.println(flag);
        return new ReturnFormat(flag, flag? "新增成功!":"新增失敗!");
    }

    /**
     * 修改護士
     * @param nurse
     * @return
     */
    @PutMapping
    public ReturnFormat update(@RequestBody Nurse nurse) {
        Boolean flag = nurseService.update(nurse);
        return new ReturnFormat(flag, flag? "更新成功":"更新失敗");
    }

    /**
     * 根據 id 刪除護士
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ReturnFormat delete(@PathVariable Integer id) {
        Boolean flag = nurseService.deleteById(id);
        return new ReturnFormat(flag, flag? "刪除成功": "刪除失敗");
    }

    /**
     * 根據 id 查詢護士
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ReturnFormat getById(@PathVariable Integer id) {
        return new ReturnFormat(true, nurseService.getById(id));
    }
}
