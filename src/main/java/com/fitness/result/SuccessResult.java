package com.fitness.result;


/**
 * Created on 2017/7/1.
 */
public class SuccessResult extends BaseResult {

    private Object data;

    public SuccessResult(Object object) {
        this();
        this.data = object;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SuccessResult() {
        super(SUCCESS);
    }
}
