package com.fitness.result;

/**
 * Created on 2017/7/1.
 */
public class ErrorResult extends BaseResult {

    private Error error;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public ErrorResult() {
        super(FAIL);
    }

    public ErrorResult(String code, String message) {
        this();
        this.error = new Error();
        this.error.setCode(code);
        this.error.setMessage(message);

    }
}
