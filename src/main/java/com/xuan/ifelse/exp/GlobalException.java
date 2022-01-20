package com.xuan.ifelse.exp;

import com.xuan.ifelse.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author xuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年01月02日 15:18
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {


    @ExceptionHandler(BusException.class)
    public Result busException(BusException e){
        log.error(e.getMessage());
        Result result = new Result();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        return  result;
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public Result exception(NoHandlerFoundException e){
        log.error(e.getMessage());
        Result result = new Result();
        result.setCode("404");
        result.setMsg("无此路由："+e.getMessage());
        return  result;
    }

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e){
        log.error(e.getMessage());
        Result result = new Result();
        result.setCode("401");
        result.setMsg("失败："+e.getMessage());
        return  result;
    }



}
