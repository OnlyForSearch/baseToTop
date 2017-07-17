//: annotations/database/SQLInteger.java
package cn.feng.thinkInJava.b2_1_注解.annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {

    String name() default "";

    Constraints constraints() default @Constraints;
} ///:~
