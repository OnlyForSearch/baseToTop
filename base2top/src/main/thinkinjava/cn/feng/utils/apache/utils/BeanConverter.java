package cn.feng.utils.apache.utils;

import org.apache.commons.beanutils.Converter;

import java.util.Date;

/**
 * 日期转换:时间戳转日期
 *
 * @author fengyu
 * @Date 2015.7.23
 */
@SuppressWarnings({"rawtypes"})
public class BeanConverter implements Converter {

    public Object convert(Class type, Object value) {
        // TODO Auto-generated method stub
        return toDate(type, value);
    }

    /**
     * @param type
     * @param value 必须是时间戳格式
     * @return
     * @author Fangyw
     * 2015年7月23日 上午9:23:54
     */
    public static Object toDate(Class type, Object value) {
        if (value == null || "".equals(value))
            return null;
        if (value instanceof String) {
            String dateValue = value.toString().trim();
            if (type.equals(Date.class)) {
                try {
                    return new Date(Long.valueOf(dateValue));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }
}
