package cn.feng.thinkInJava.b2_1_注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {

    int id() default -1;
    //description有一个default值,如果在注解某个方法是否没有给出description值,这该注解处理器就会使用默认值

    /*	默认值限制:对于非基本的元素默认值都不能使用null作为其值*/
    String description() default "no description";


    //注解元素可用的类型
    //1所有的基本类型
    //String
    //Class
    //enum
    //Annotation
    //以上类型数组
    //使用了其他类型编译器就会报错.注意也不允许使用任何包装类型,不过由于自动打包的存在,这也算不上什么限制
}
