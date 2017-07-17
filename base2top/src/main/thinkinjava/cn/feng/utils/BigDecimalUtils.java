package cn.feng.utils;

import java.math.BigDecimal;

public class BigDecimalUtils {

    /**
     * 默认除法运算精度
     */
    private static final int DEF_DIV_SCALE = 2;

    /**
     * 提供精确加法计算的add方法
     *
     * @param <T>
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static <T> String add(T value1, T value2) {
        BigDecimal b1 = null;
        BigDecimal b2 = null;
        if (value1 instanceof String) {
            b1 = new BigDecimal((String) value1);
        } else if (value1 instanceof Number) {

            b1 = new BigDecimal(value1.toString());
        }

        if (value2 instanceof String) {
            b2 = new BigDecimal((String) value2);
        } else if (value2 instanceof Number) {
            b2 = new BigDecimal(value2.toString());
        }

        return b1.add(b2).toString();
    }

    /**
     * 提供精确减法运算的sub方法
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static <T> String sub(T value1, T value2) {
        BigDecimal b1 = null;
        BigDecimal b2 = null;
        if (value1 instanceof String) {
            b1 = new BigDecimal((String) value1);
        } else if (value1 instanceof Number) {
            b1 = new BigDecimal(value1.toString());
        }

        if (value2 instanceof String) {
            b2 = new BigDecimal((String) value2);
        } else if (value2 instanceof Number) {
            b2 = new BigDecimal(value2.toString());
        }
        return b1.subtract(b2).toString();
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static <T> String mul(T value1, T value2) {
        BigDecimal b1 = null;
        BigDecimal b2 = null;
        if (value1 instanceof String) {
            b1 = new BigDecimal((String) value1);
        } else if (value1 instanceof Number) {
            b1 = new BigDecimal(value1.toString());
        }

        if (value2 instanceof String) {
            b2 = new BigDecimal((String) value2);
        } else if (value2 instanceof Number) {
            b2 = new BigDecimal(value2.toString());
        }

        return b1.multiply(b2).toString();
    }

    private static <T> String divTemplate(T value1, T value2, Integer length, int rount) throws IllegalAccessException {
        // 如果精确范围小于0，抛出异常信息
        if (length < 0) {
            throw new IllegalAccessException("精确度不能小于0");
        }
        BigDecimal b1 = null;
        BigDecimal b2 = null;
        if (value1 instanceof String) {
            b1 = new BigDecimal((String) value1);
        } else if (value1 instanceof Number) {

            b1 = new BigDecimal(value1.toString());
        }

        if (value2 instanceof String) {
            b2 = new BigDecimal((String) value2);
        } else if (value2 instanceof Number) {
            b2 = new BigDecimal(value2.toString());
        }
        // return b1.divide(b2, scale).doubleValue();
        return b1.divide(b2, length, rount).toString();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后2位，以后的数字四舍五入。
     *
     * @param value1 被除数
     * @param value2 除数
     * @return 两个参数的商
     */
    public static <T> String div(T value1, T value2) throws IllegalAccessException {

        return divTemplate(value1, value2, DEF_DIV_SCALE, BigDecimal.ROUND_DOWN);
    }

    /**
     * 提供精确的除法运算方法div,去掉精确位数后的数字,并且进1
     *
     * @param value1 被除数
     * @param value2 除数
     * @param length 精确范围
     * @return 两个参数的商
     * @throws IllegalAccessException
     */
    public static <T> String divRoundUp(T value1, T value2, int length) throws IllegalAccessException {

        return divTemplate(value1, value2, length, BigDecimal.ROUND_UP);

    }

    /**
     * 提供精确的除法运算方法div,去掉精确位数后的数字
     *
     * @param value1 被除数
     * @param value2 除数
     * @param length 精确范围
     * @return 两个参数的商
     * @throws IllegalAccessException
     */
    public static <T> String divRoundDown(T value1, T value2, int length) throws IllegalAccessException {

        return divTemplate(value1, value2, length, BigDecimal.ROUND_DOWN);

    }

    /**
     * 提供精确的除法运算方法div,四舍五入
     *
     * @param value1 被除数
     * @param value2 除数
     * @param length 精确范围
     * @return 两个参数的商
     * @throws IllegalAccessException
     */
    public static <T> String divHalfUP(T value1, T value2, Integer length) throws IllegalAccessException {

        return divTemplate(value1, value2, length, BigDecimal.ROUND_HALF_UP);

    }
}
