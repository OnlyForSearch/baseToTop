package cn.feng.thinkInJava.b2_1_注解.annotations.a20_03_00.默认值限制;
//: annotations/SimulatingNull.java

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 默认值限制
 *默认值限制

 注解元素不能有不确定的值，也就是说，元素必须要么具有默认值，要么使用注解时提供元素的值。
 不能以null作为其值。为了绕开这个约束，可以定义一些特殊的值，例如空字符串或负数，以表示某个元素不存在。
 *
 * 编译器对默认值有些过分的挑剔,首先,元素不能有不确定的值,也就是说,元素必须要么具有默认值,要么在使用注解的时候提供元素的值
 * 其次,对于非基本类型的元素,无论是在源代码中声明时,或者还是在注解接口中定义默认值时,都不能以null作为其值,这个约束使得处理器很难
 * 表现一个元素的存在或缺失的状态,因为在每个注解的声明中,所有的元素都存在,并且都具有相对应的值,为了绕开这个约束,我们只能定义一些特殊的
 * 值,例如空字符串或者负数,以表示某个元素不存在,在定义注解上的一个习惯性用法
 *
 * @author fengyu
 * @date 2015年8月9日
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatingNull {

    int id() default -1;

    String description() default "";
} ///:~
