//: annotations/database/SQLString.java
package cn.feng.thinkInJava.b2_1_注解.annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * SQLString中元素constraints的类型就是一个注解。
 * */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {

    int value() default 0;

    String name() default "";

    Constraints constraints() default @Constraints;//都使用了嵌入的@Constraints注解的默认值
} ///:~
