package com.kent.controller.utils;

import lombok.Data;

@Data
public class ReturnFormat {
    private Boolean flag; // 操作成功為 true，失敗為 false
    private Object data; // 返回查詢操作的值
    private String msg; // 返回要給使用者的訊息

    public ReturnFormat() {}

    public ReturnFormat(Boolean flag){
        this.flag = flag;
    }

    public ReturnFormat(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public ReturnFormat(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public ReturnFormat(String msg) {
        this.flag = false;
        this.msg = msg;
    }
}
