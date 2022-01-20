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
 * @Description 电脑
 * @createTime 2022年01月02日 14:58
 */
@Slf4j
@Component
@ElectronicType(ElectronicEnum.COMPUTER)
public class ComputerServiceImpl implements ElectronicProductService {
    @Override
    public String discount(String params) {
        return "电脑 打6折";
    }

    @Override
    public OrderVo fullReduction(OrderVo orderVo) {

        OrderVo orderVo1 = new OrderVo();
        BeanUtils.copyProperties(orderVo,orderVo1);
        log.info("电视:满2200减25");
        // 赋值 模拟业务 显示
        orderVo1.setProductName("电脑");
        orderVo1.setRemark("满2200减25");
        orderVo1.setPayAmt(orderVo.getOrderAmt());
        orderVo1.setDiscountAmt(new BigDecimal("0"));

        if (orderVo.getOrderAmt().compareTo(new BigDecimal("2200"))==1){
            BigDecimal discountAmt=new BigDecimal("25");
            orderVo1.setDiscountAmt(discountAmt);
            orderVo1.setPayAmt(orderVo.getOrderAmt().subtract(discountAmt));
        }

        return orderVo1;
    }

}
