package cn.cps.servicebase.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuLiException extends RuntimeException{

    private Integer code;//状态码
    private String message;//异常信息

}
