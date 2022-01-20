package com.xuan.ifelse.exp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xuan
 * @version 1.0.0
 * @Description 异常类
 * @createTime 2022年01月02日 15:29
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusException extends RuntimeException {
    private String code;
    private String msg;
}
