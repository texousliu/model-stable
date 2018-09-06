package cn.texous.common.utils;

import cn.texous.common.constants.CharsetName;
import cn.texous.common.params.SignParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/25 9:29
 */
public class SignUtil {

    private static final Logger log = Logger.getLogger("SignUtil");

    public static final ObjectMapper MAPPER = new ObjectMapper();
    final static SimpleModule SM=new SimpleModule();
    static{
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MAPPER.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
        MAPPER.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

        SM.addSerializer(java.sql.Date.class, new JsonSerializer<java.sql.Date>(){

            @Override
            public Class<java.sql.Date> handledType() {
                // TODO Auto-generated method stub
                return java.sql.Date.class;
            }

            @Override
            public void serialize(java.sql.Date value, JsonGenerator gen,
                                  SerializerProvider serializers) throws IOException,
                    JsonProcessingException {
                gen.writeNumber(value.getTime());
            }

        });
        MAPPER.registerModule(SM);
    }

    public static TreeMap<String, String> sign(SignParam signParam) {
        if (signParam == null)
            return new TreeMap<>();
        TreeMap<String, String> map = MAPPER.convertValue(signParam, new TypeReference<TreeMap<String, String>>(){});
        StringBuilder t = new StringBuilder();
        map.forEach((key, value) -> {
            try {
                t.append(key).append("=").append(URLEncoder.encode(value, CharsetName.UTF_8)).append("&");
            } catch (UnsupportedEncodingException e) {
                log.log(Level.WARNING, "URLEncoder error", e);
            }
        });
        t.append("consumer_secret=").append(signParam.getConsumer_secret());
        System.out.println(t);
        map.put("sign", MD5.MD5(t.toString()).toUpperCase());
        return map;
    }

    public static void main(String[] args) {
        SignParam signParam = new SignParam();
        //signParam.setConsumer_id("123132");
        signParam.setConsumer_secret("zxvzxc");
        signParam.setNonce_str(StringUtils.randomCharacter(6));
        signParam.setTime_stamp(String.valueOf(System.currentTimeMillis()));
        TreeMap<String, String> param = sign(signParam);
        param.forEach((k, v) ->
            System.out.println(k + ": " + v)
        );
    }

}
