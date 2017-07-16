package com.fitness.exception;

import com.fitness.result.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统全局异常处理
 * Created on 2017/7/3.
 */
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    final Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 请求参数错误
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private BaseResult bindException(BindException e) {

        List<ObjectError> errors = e.getAllErrors();
        String error = "";
        for (ObjectError objectError : errors) {
            FieldError fieldError = (FieldError) objectError;
            error += fieldError.getField() + "-->" + fieldError.getDefaultMessage() + "|";
        }
        logger.error("参数验证------------>" + error);

        return BaseResult.error("002", error);
    }

    /**
     * 服务器发生错误
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private BaseResult exceptionHandler(Exception e) {
        logger.error("系统出错----------->", e);
        return BaseResult.systemError();
    }

}
