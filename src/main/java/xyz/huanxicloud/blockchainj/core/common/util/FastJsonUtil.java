package xyz.huanxicloud.blockchainj.core.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;

/**
 * @author wuweifeng wrote on 2018/3/2.
 */
public class FastJsonUtil {
    private static final SerializeConfig CONFIG;

    static {
        CONFIG = new SerializeConfig();
        CONFIG.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
        CONFIG.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
    }

    private static final SerializerFeature[] FEATURES = {SerializerFeature.WriteMapNullValue, // 输出空置字段
            SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullStringAsEmpty // 字符类型字段如果为null，输出为""，而不是null
    };


    public static String toJSONString(Object object) {
        return JSON.toJSONString(object, CONFIG, FEATURES);
    }

    public static String toJSONNoFeatures(Object object) {
        return JSON.toJSONString(object, CONFIG);
    }


    public static Object toBean(String text) {
        return JSON.parse(text);
    }

    public static <T> T toBean(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    /**
     * 转换为数组
     */
    public static <T> Object[] toArray(String text) {
        return toArray(text, null);
    }

    /**
     *  转换为数组
     */
    public static <T> Object[] toArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz).toArray();
    }

    /**
     * 转换为List
      */
    public static <T> List<T> toList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    /**
     * 将string转化为序列化的json字符串
     */
    public static Object textToJson(String text) {
        return JSON.parse(text);
    }

    /**
     * json字符串转化为map
     */
    public static Map stringToCollect(String s) {
        return JSONObject.parseObject(s);
    }

    /**
     * 将map转化为string
     */
    public static String collectToString(Map m) {
        return JSONObject.toJSONString(m);
    }
}
