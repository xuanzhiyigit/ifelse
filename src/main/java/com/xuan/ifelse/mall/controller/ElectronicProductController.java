package com.xuan.ifelse.mall.controller;

import com.xuan.ifelse.common.Result;
import com.xuan.ifelse.mall.service.ElectronicProductService;
import com.xuan.ifelse.mall.service.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

/**
 * @author xuan
 * @version 1.0.0
 * @Description 干掉 IF ELSE的 第一种模式
 * @createTime 2022年01月02日 15:01
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class ElectronicProductController {
//    @Resource
//    private   ElectronicProductService electronicProductService  ;

    private final ElectronicProductService electronicProductService  ;
    public ElectronicProductController( ElectronicProductService electronicProductService){
        this.electronicProductService=electronicProductService;
    }

    /**
     * 打折
     * @param type
     * @return
     */
    @ResponseBody
    @RequestMapping("/discount/{type}")
    public Object discount(@PathVariable String type){
        return electronicProductService.discount(type);
    }

    /**
     * 优惠
     * @param type
     * @return
     */
    @ResponseBody
    @RequestMapping("/fullReduction/{type}")
    public Object fullReduction(@PathVariable String type){
        OrderVo orderVo = new OrderVo();
        orderVo.setType(type);
        orderVo.setOrderAmt(getBigDecimalF2(5000));
        orderVo.setOrderId(UUID.randomUUID().toString().toLowerCase().replace("-",""));

        OrderVo reOrderVo = electronicProductService.fullReduction(orderVo);

        return Result.sucess(reOrderVo);
    }


    public BigDecimal getBigDecimalF2(int max){
        Double rand=Math.random()*max;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String randDec=decimalFormat.format(rand);
        return new BigDecimal(randDec);
    }

}
