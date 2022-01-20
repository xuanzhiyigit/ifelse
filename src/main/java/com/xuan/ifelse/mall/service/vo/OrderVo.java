package com.xuan.ifelse.mall.service.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xuan
 * @version 1.0.0
 * @Description 订单模型
 * @createTime 2022年01月02日 14:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo  implements Serializable {
    private static final long serialVersionUID = -3414440485452423134L;

    /** 类型 */
    private String type;

    /** 订单金额 */
    private BigDecimal orderAmt;

    /** 订单号 */
    private String orderId;

    /** 商品名称 */
    private String productName;

    /** 优惠金额 */
    private BigDecimal discountAmt;

    /** 实付金额 */
    private BigDecimal payAmt;

    /** 备注 */
    private String remark;

    // 省略 ...
}
