package com.hg.inventory.common.domain.vo;

import lombok.Data;

@Data
public class Result<T> {
    private static final int SUCCESS = 200;
    private static final int FAIL = 500;
    private static final String SUCCESS_STRING = "操作成功";
    private static final String FAIL_STRING = "操作失败";
    private int code;
    private String msg;
    private T data;
    public static <T> Result<T> success(){
        Result<T> objectResult = new Result<>();
        objectResult.setCode(SUCCESS);
        objectResult.setMsg(SUCCESS_STRING);
        return objectResult;
    }
    public static <T> Result<T> success(T data){
        Result<T> objectResult = new Result<>();
        objectResult.setCode(SUCCESS);
        objectResult.setMsg(SUCCESS_STRING);
        objectResult.setData(data);
        return objectResult;
    }
    public static <T> Result<T> fail(){
        Result<T> objectResult = new Result<>();
        objectResult.setCode(FAIL);
        objectResult.setMsg(FAIL_STRING);
        return objectResult;
    }
    public static <T> Result<T> fail(String msg){
        Result<T> objectResult = new Result<>();
        objectResult.setCode(FAIL);
        objectResult.setMsg(msg);
        return objectResult;
    }
}
