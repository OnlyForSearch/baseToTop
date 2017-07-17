package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_10_00.常量相关的方法;
//: enumerated/ConstantSpecificMethod.java

import java.text.DateFormat;
import java.util.Date;

/**
 * 常量相关的方法:需要为enum定义一个或多个abstract方法,然后为每个enum实例实现该抽象方法,
 * 通过相应的enum实例,我们可以调用其上的方法,这通常也称为表驱动的代码(table driven code)
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public enum ConstantSpecificMethod {
    DATE_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };
    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values())
            System.out.println(csm.getInfo());
    }
    abstract String getInfo();
} /* (Execute to see output) *///:~
