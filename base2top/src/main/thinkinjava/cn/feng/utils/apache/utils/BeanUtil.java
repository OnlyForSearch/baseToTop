package cn.feng.utils.apache.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 对象进行封装
 *
 * @author fengyu
 */
public class BeanUtil {

    static {
        // 在封装之前 注册转换器
        ConvertUtils.register(new BeanConverter(), java.util.Date.class);
    }

    /**
     * @param destClazz 需要的目标类
     * @param orig      原对象
     * @return
     * @author Fangyw 2015年7月23日 上午8:43:02
     */
    public static <D> D copyProperties(Class<D> destClazz, Object orig) {

        D obj = null;
        try {
            obj = destClazz.newInstance();
            BeanUtilsBean.getInstance().copyProperties(obj, orig);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;

    }

    /**
     * 请求信息封装到对象
     *
     * @param request 请求信息
     * @param clazz   封装对象
     */
    @SuppressWarnings("unchecked")
    public static <E> E get(HttpServletRequest request, Class<E> clazz) {
        if (request == null)
            throw new IllegalArgumentException("FormBeanUtil.get中的request为空");
        E obj = null;
        try {
            obj = clazz.newInstance();
            Map<String, String[]> parameterMap = request.getParameterMap();
            BeanUtils.populate(obj, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
