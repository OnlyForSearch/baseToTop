package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_13_00.Foreach和迭代器.b_11_13_01;

//: holding/EnvironmentVariables.java

import java.util.Map;

/**
 * javaSE5中大量的类是Iterablel类型,主要包括所有的Collection类但是不包括各种Map
 * 显示所有操作系统的环境变量
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class EnvironmentVariables {

    @SuppressWarnings({"rawtypes"})
    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
} /* (Execute to see output) */// :~
