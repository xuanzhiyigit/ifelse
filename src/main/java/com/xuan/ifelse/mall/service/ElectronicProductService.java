package com.xuan.ifelse.mall.service;

import com.xuan.ifelse.mall.service.vo.OrderVo;

/**
 * @author xuan
 * @version 1.0.0
 * @Description 电子产品业务
 * @createTime 2022年01月02日 14:56
 */
public interface ElectronicProductService {

    /**
     * 打折
     * @param params 业务参数
     * @return
     */
    String discount(String params);


    /**
     * 满减活动
     * @param orderVo 业务参数
     * @return
     */
    OrderVo fullReduction(OrderVo orderVo);
}
