package cn.texous.testservice.constants;

import java.util.Arrays;

/**
 * @author: Seraphim
 * @date: 2018/8/21 11:42
 * @description:
 */
public enum PayTypeEnum {

    DOLLEXCHANGEALIPAY("dollExchangeAliPay", "兑币机娃娃机支付宝支付"),
    DOLLEXCHANGEWECHAT("dollExchangeWechat", "兑币机娃娃机微信支付"),
    GASHAPONALIPAY("gashaponAliPay", "扭蛋机支付宝支付"),
    GASHAPONWECHAT("gashaponWechat", "扭蛋机微信支付"),
    LIFECLASSALIPAY("lifeClassAliPay", "生活类设备支付宝支付"),
    LIFECLASSWECHAT("lifeClassWechat", "生活类设备微信支付"),
    INTEGRALDELVERYWECHAT("integralDeliveryWechat", "积分充值直接赠送支付"),
    INTEGRALRECHARGEWECHAT("integralRechargeWechat", "积分充值加积分支付"),
    CHILDRENEALIPAY("childrenAliPay", "儿童类支付宝支付"),
    CHILDRENEWECHAT("childrenWechat", "儿童类微信支付"),
    DOLLEXCHANGEWECHATMINI("dollExchangeWechatMini", "兑币机娃娃机小程序支付");

    String type;

    String description;

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    PayTypeEnum(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public static boolean isValidType(String value) {
        return Arrays.stream(PayTypeEnum.values())
                .anyMatch(payTypeEnum -> payTypeEnum.getType().equals(value));
    }
}
