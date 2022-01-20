package com.xuan.ifelse.mall.service.impl;

import com.xuan.ifelse.anno.ElectronicType;
import com.xuan.ifelse.constant.ElectronicEnum;
import com.xuan.ifelse.mall.service.ElectronicProductService;
import com.xuan.ifelse.mall.service.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author xuan
 * @version 1.0.0
 * @Description 手机
 * @createTime 2022年01月02日 14:59
 */
@Slf4j
@Component
@ElectronicType(ElectronicEnum.CELLPHONE)
public class MobilePhoneServiceImpl  implements ElectronicProductService {
    @Override
    public String discount(String params) {
        return "手机打8.2折";
    }

    @Override
    public OrderVo fullReduction(OrderVo orderVo) {
        OrderVo orderVo1 = new OrderVo();
        BeanUtils.copyProperties(orderVo,orderVo1);
        log.info("电视:满500减15");
        // 赋值 模拟业务 显示
        orderVo1.setProductName("手机");
        orderVo1.setRemark("满500减15");
        orderVo1.setPayAmt(orderVo.getOrderAmt());
        orderVo1.setDiscountAmt(new BigDecimal("0"));

        if (orderVo.getOrderAmt().compareTo(new BigDecimal("500"))==1){
            BigDecimal discountAmt=new BigDecimal("15");
            orderVo1.setDiscountAmt(discountAmt);
            orderVo1.setPayAmt(orderVo.getOrderAmt().subtract(discountAmt));
        }

        return orderVo1;
    }

}
