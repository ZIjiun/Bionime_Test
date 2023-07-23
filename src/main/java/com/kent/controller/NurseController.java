package com.kent.controller;

import com.kent.controller.utils.R;
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
    public R getAll() {
        return new R(true, nurseService.getAll());
    }

    /**
     * 新增護士
     * @param nurse
     * @return
     */
    @PostMapping
    public R add(@RequestBody Nurse nurse){
        System.out.println(nurse);
        boolean flag = nurseService.add(nurse);
        System.out.println(flag);
        return new R(flag, flag? "新增成功!":"新增失敗!");
    }

    /**
     * 修改護士
     * @param nurse
     * @return
     */
    @PutMapping
    public R update(@RequestBody Nurse nurse) {
        Boolean flag = nurseService.update(nurse);
        return new R(flag, flag? "更新成功":"更新失敗");
    }

    /**
     * 根據 id 刪除護士
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        Boolean flag = nurseService.deleteById(id);
        return new R(flag, flag? "刪除成功": "刪除失敗");
    }

    /**
     * 根據 id 查詢護士
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, nurseService.getById(id));
    }
}
