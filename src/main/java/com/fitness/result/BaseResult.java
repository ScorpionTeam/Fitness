package com.fitness.result;


/**
 * Created on 2017/7/1.
 */
public class BaseResult {

    //成功标识
    public static int SUCCESS = 1;

    //失败标识
    public static int FAIL = 0;

    //结果状态码
    private int result;


    public BaseResult(int result) {
        this.result = result;
    }

    public static BaseResult success(Object object) {
        return new SuccessResult(object);
    }

    public static BaseResult error(String code, String message) {
        return new ErrorResult(code, message);
    }

    public static BaseResult paramError() {
        return new ErrorResult("002", "参数错误");
    }

    public static BaseResult oathTimeout() {
        return new ErrorResult("003", "授权超时");
    }

    public static BaseResult oathError() {
        return new ErrorResult("004", "授权失效");
    }

    public static BaseResult nonSuchResult() {
        return new ErrorResult("005", "查无结果");
    }

    public static BaseResult systemError() {
        return new ErrorResult("006", "系统错误");
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
