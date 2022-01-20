package com.xuan.ifelse.anno;

import com.xuan.ifelse.constant.ElectronicEnum;

import java.lang.annotation.*;

/**
 * @author xuan
 * @version 1.0.0
 * @Description 电子产品类型注解
 * @createTime 2022年01月02日 14:45
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ElectronicType {
    /**
     * 策略类型
     * @return
     */
    ElectronicEnum value();
}
