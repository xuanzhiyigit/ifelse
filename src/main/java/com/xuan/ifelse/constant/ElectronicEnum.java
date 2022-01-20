package com.xuan.ifelse.constant;

/**
 * @author xuan
 * @version 1.0.0
 * @Description 电子产品类型
 * @createTime 2022年01月02日 14:46
 */
public enum ElectronicEnum {
    CELLPHONE("001","手机"),
    COMPUTER("002","电脑"),
    TV("003","电视");

    private String type;
    private String desc;

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    /**
     *
     * @param type
     * @param desc
     */
    ElectronicEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
