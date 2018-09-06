package cn.texous.common.params;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/25 10:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignParam {

    /**
     * 消费者 id
     */
    private String consumer_id;
    /**
     * 消费者 密钥
     */
    @JsonIgnore
    private String consumer_secret;
    /**
     * 是	int	正整数	1493468759	请求时间戳（毫秒级）
     */
    private String time_stamp;
    /**
     * 是	string	非空且长度上限32字节	fa577ce340859f9fe	随机字符串
     */
    private String nonce_str;
    /**
     * 是	string	非空且长度固定32字节	B250148B284956EC5218D4B0503E7F8A	签名信息，详见接口鉴权
     */
    private String sign;

}
