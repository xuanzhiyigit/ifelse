package com.xuan.ifelse.mall.service.strategy;

import com.xuan.ifelse.anno.ElectronicType;
import com.xuan.ifelse.constant.ElectronicEnum;
import com.xuan.ifelse.exp.BusException;
import com.xuan.ifelse.mall.service.ElectronicProductService;
import com.xuan.ifelse.mall.service.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuan
 * @version 1.0.0
 * @Description 电子商品业务策略
 * @createTime 2022年01月02日 15:06
 */
@Slf4j
@Primary
@Component
public class ElectronicProductServiceStrategy implements ElectronicProductService, ApplicationContextAware {

    /** 存所有 ElectronicProductService 实现类 */
    private static Map<ElectronicEnum, ElectronicProductService> enumElectronicProductServiceMap;

    /**
     * 打折
     * @param type
     * @return
     */
    @Override
    public String discount(String type) {
        ElectronicProductService electronicProductService=getElectronicProductServiceImpl(type);
        return electronicProductService.discount("这是参数");

    }

    /**
     * 满减
     * @param orderVo 业务参数
     * @return
     */
    @Override
    public OrderVo fullReduction(OrderVo orderVo) {
        ElectronicProductService electronicProductService=getElectronicProductServiceImpl(orderVo.getType());
        return electronicProductService.fullReduction(orderVo);
    }


    /**
     * 自动加载所有因子组实现类
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 获取 ElectronicProductService 接口的所有实现类
        Map<String,ElectronicProductService> electronicProductServiceMap=applicationContext.getBeansOfType(ElectronicProductService.class);
        enumElectronicProductServiceMap = new HashMap<>();

        // 将实现类放入map中，key为实现类对应的枚举，value为实现类
        for (ElectronicProductService item: electronicProductServiceMap.values()) {
            ElectronicType annotation = item.getClass().getAnnotation(ElectronicType.class);
            if (null != annotation ){
                enumElectronicProductServiceMap.put(annotation.value(),item);
            }

        }
    }


    /**
     * 获取实现类
     * @param type
     * @return electronicProductService
     * @throws BusException
     */
    public static ElectronicProductService getElectronicProductServiceImpl(String type) throws BusException {
        return enumElectronicProductServiceMap.get(getElectronicEnum(type));
    }

    public static ElectronicEnum getElectronicEnum(String type){
        for (ElectronicEnum item: ElectronicEnum.values()) {
            if (item.getType().equals(type)){
                return item;
            }
        }
        throw  new BusException("401","服务不存在！");
    }
}
