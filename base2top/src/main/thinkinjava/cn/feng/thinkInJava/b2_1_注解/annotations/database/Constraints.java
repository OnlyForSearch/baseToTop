//: annotations/database/Constraints.java
package cn.feng.thinkInJava.b2_1_注解.annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 修饰javaBean域准备的注解
 *生成外部文件

 部分Framework需要提供额外信息如XML描述文件才能与源代码协同工作，此时同一个类拥有两个单独的信息源，这常导致代码同步问题。但是使用注解，则可将所有信息都保存在JavaBean源文件中。

 @Target注解中指定的每一个ElementType就是一个约束，它告诉编译器，这个自定义的注解只能应用于该类型。程序员可以指定enum ElementType中的某个值，或者以逗号分隔的形式指定多个值。如果想要将注解应用于所有ElementType，那么可以省去@Target元注解，不过这并不常见。

 注解嵌套：
 * @author fengyu
 * @date 2015年8月9日
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {

    boolean primaryKey() default false;

    boolean allowNull() default true;

    boolean unique() default false;
} ///:~
