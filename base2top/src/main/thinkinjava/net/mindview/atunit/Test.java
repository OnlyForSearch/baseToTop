//: net/mindview/atunit/Test.java
// The @Test tag.
package net.mindview.atunit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义注解
 *
 * @author fengyu
 * @date 2015年8月9日
 * 注解也可以编译成class文件,没有元素的注解称为标记注解(market annotation)例如@Test
 */
@Target(ElementType.METHOD)//@Target用来定义你的注解将用于什么地方(例如是一个方法或一个域)
@Retention(RetentionPolicy.RUNTIME)//@Rectetion用来定义该注解在哪一级别可用,在源代码中(SOURCE),类文件中(CLASS)或者运行时(RUNTIME)
public @interface Test {} ///:~
