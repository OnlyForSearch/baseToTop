package cn.feng.thinkInJava.b2_1_注解.annotations.a20_01_01.定义注解;
//: annotations/UseCase.java

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义注解

 包 java.lang.annotation 中包含所有定义自定义注解所需用到的原注解和接口。如接口 java.lang.annotation.Annotation 是所有注解继承的接口,并且是自动继承，不需要定义时指定，类似于所有类都自动继承Object。
 *
 * id和description类似方法定义.由于编译器会对id进行类型检查
 *
 *
 *
 * 定义注解时会需要一些元注解，@Target定义注解应用的地方；@Retention定义注解应用的级别。

 注解中，一般都会包含一些元素以表示某些值。当分析处理注解时，程序或工具可以利用这些值。注解的元素看起来就像接口的方法，唯一的区别是你可以为其指定默认值。没有元素的注解称为标记注解。

 description元素有一个default值，如果在注解某个方法时没有给出description的值，则该注解的处理器就会使用此元素的默认值。
 元注解

 元注解专职负责注解其他的注解。Java只内置了三种标准注解以及四种元注解。元注解定义如下：
 接口 	说明
 @Target 定义注解应用的地方。包括：CONSTRUCTOR-构造器声明；FIELD-域声明；LOCAL_VARIABLE-局部变量声明；METHOD-方法声明；PACKAGE-包声明；PARAMETER-参数声明；TYPE-类、接口或enum声明
 @Retention 定义注解应用的级别。包括：SOURCE-注解将被编译器丢弃；CLASS-注解在class文件中可用，但会被VM丢弃；RUNTIME-VM将在运行期也保留注解，因此可通过反射机制读取注解信息
 @Documented 将此注解包含在JavaDoc中
 @Inherited 允许子类继承父类中的注解
 * @author fengyu
 * @date 2015年8月9日
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {

    int id();

    //在注解某个方法时没有给出的description的值,则该注解处理器就会使用此元素的默认值
    String description() default "no description";
} ///:~

//注解元素可用的类型
//1所有的基本类型
//String
//Class
//enum
//Annotation
//以上类型数组
//使用了其他类型编译器就会报错.注意也不允许使用任何包装类型,不过由于自动打包的存在,这也算不上什么限制
