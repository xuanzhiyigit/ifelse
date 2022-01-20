package com.xuan.ifelse.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * @author xuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年01月02日 15:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result  implements Serializable {
    private static final long serialVersionUID = 8788541605809662780L;
    private String code;
    private String msg;
    private Object data;

    public Result(String code,String msg){
        this.code=code;
        this.msg=msg;
    }



    public static  Result  sucess(Object data){
        Result result = new Result();
        result.setCode("200");
        result.setMsg("成功");
        result.setData(data);
        return  result;
    }

}
