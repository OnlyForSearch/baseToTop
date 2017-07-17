package cn.feng.thinkInJava.b2_1_注解.annotations.a20_02_00.编写注解处理器;

//: annotations/UseCaseTracker.java

import cn.feng.thinkInJava.b2_1_注解.annotations.a20_01_01.定义注解.PasswordUtils;
import cn.feng.thinkInJava.b2_1_注解.annotations.a20_01_01.定义注解.UseCase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 编写注解处理器
 *使用注解的过程中，重要的部分是创建与使用注解处理器。Java SE5扩展了反射机制API，以帮助构造该类工具；同时，提供外部工具apt帮助解析带有注解的Java代码。
 *
 * 反射方法getDeclaredMethods()与getAnnotation()均属于AnnotationElement接口，Class、Method、Field均实现了该接口。getAnnotation()方法返回指定类型的注解对象。使用反射获取到注解对象之后，类似使用调用方法的方式获取注解的值，如uc.id()等。
 注解元素

 注解元素可用基本类型包括：所有基本类型、String、Class、enum、Annotation以及所有前面这些类型的数组。不允许使用任何包装类型，注解可以嵌套。

 因为注解是由编译器计算而来的，因此，所有元素值必须是编译期常量。

 如果元素值是一个数组，要将它的值用大括号括起来@Test(array={"a","b"})，如果只有一个值，也可以省去括号。
 * @author fengyu
 * @date 2015年8月9日
 */
public class UseCaseTracker {    //getDeclaredMethods和getAnnotation都属于AnnotatedElement接口

    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {    //getDeclaredMethods
        for (Method m : cl.getDeclaredMethods()) {//getAnnotation方法返回指定类型的注解对象,在这里就是UseCase,如果被注解的方法上没有该类型的注解,则返回null值
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {    //调用id()和description()方法从返回的UserCase对象中提取元素的值
                System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);

        //读取PasswordUtils并用反射机制查找@UseCase
        trackUseCases(useCases, PasswordUtils.class);
    }
} /* Output:
Found Use Case:47 Passwords must contain at least one numeric
Found Use Case:48 no description
Found Use Case:49 New passwords can't equal previously used ones
Warning: Missing use case-50
*///:~
