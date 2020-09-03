package cn.cps.servicebase.handle;

import cn.cps.commonutils.Result;
import cn.cps.servicebase.exception.GuLiException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandle {


    @ResponseBody //为了返回数据
    @ExceptionHandler(Exception.class)//指定出现什么异常执行这个方法
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error(e.getMessage());
    }


    @ResponseBody //为了返回数据
    @ExceptionHandler(GuLiException.class)//自定义异常处理，需要手动抛出自定义的异常
    public Result error2(GuLiException e) {
        e.printStackTrace();
        return Result.error(e.getCode()+"\t"+e.getMessage()+e.getMessage());
    }

}
