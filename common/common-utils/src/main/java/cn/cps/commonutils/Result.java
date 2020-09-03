package cn.cps.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//统一返回结果的类
@Data
public class Result<T> {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    //把构造方法私有
    private Result() {}

    //成功静态方法
    public static <T> Result<T> ok() {
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    //成功静态方法
    public static <T> Result<T> ok(T data) {
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        r.setData(data);
        return r;
    }

    //失败静态方法
    public static Result error() {
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    //失败静态方法
    public static Result error(String message) {
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage(message);
        return r;
    }
}
