package cn.feng.utils;

import org.junit.Test;

public class Validate {

    public static boolean isDouble(double digit) {
        // 二进制无法精确表示分数1/10,十进制无法无法精确表示1/3,精确使用BigDecimal
        return Double.isNaN(digit);
    }

    /**
     * 字符串非空
     *
     * @param str
     * @return
     */
    public static boolean isNotNull(String str) {
        //首先要检查str不为null.,如果在一个null值上调用
        return str != null && str.length() != 0;

    }

    @Test
    public void test() {
    }

}
