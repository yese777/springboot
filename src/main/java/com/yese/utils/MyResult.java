package com.yese.utils;

import lombok.Data;


/**
 * 封装返回给前端的数据
 */
@Data
public class MyResult {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    

    // 响应中的数据
    private Object data;

    // 构建其他状态的MyResult对象
    public static MyResult build(Integer status, String msg, Object data) {
        return new MyResult(status, msg, data);
    }

    public static MyResult build(Integer status, String msg) {
        return new MyResult(status, msg, null);
    }

    public static MyResult success(Object data) {
        return new MyResult(data);
    }

    public static MyResult success() {
        return new MyResult(null);
    }

    public MyResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public MyResult(Object data) {
        this.status = 200;
        this.msg = "执行成功";
        this.data = data;
    }

    public MyResult() {

    }

}
