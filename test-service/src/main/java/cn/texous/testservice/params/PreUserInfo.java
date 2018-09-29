package cn.texous.testservice.params;

import cn.texous.testservice.annotation.EnumValueUtils;
import cn.texous.testservice.constants.PayTypeEnum;
import lombok.Data;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/9/29 11:49
 */
@Data
public class PreUserInfo {

    private String username;
    @EnumValueUtils(enumClass = PayTypeEnum.class, enumMethod = "isValidType", message = "支付类型不能为 null")
    private String payType;

}
