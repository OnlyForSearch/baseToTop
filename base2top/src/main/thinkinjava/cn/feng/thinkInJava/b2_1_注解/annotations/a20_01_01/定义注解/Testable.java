//: annotations/Testable.java
package cn.feng.thinkInJava.b2_1_注解.annotations.a20_01_01.定义注解;

import net.mindview.atunit.Test;

/**
 * 基本语法
 *注解：注解把元数据与源代码文件结合起来，使得我们能够以由编译器来测试和验证格式，存储有关程序的额外信息。注解在实际的源代码级别保存所有的信息，而不是某种注释性文字。
 Java SE5内置了三种，定义在java.lang中的注解：

 @Override，表示当前的方法定义将覆盖超类中的方法。如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
 @Deprecated，如果程序员使用了注解为它的元素，那么编译器会发出警告信息
 @SuppressWarnings，关闭不当的编译器警告信息。在Java SE5之前的版本中，也可以使用该注解，不过会被忽略不起作用。

 每当你创建描述符性质的类或接口时，一旦其中包括了重复性的工作，那就可以考虑使用注解来简化与自动化该过程。


 从语法角度看，注解的使用方式几乎和修饰符的使用一样。
 *
 *  @author fengyu
 * @date 2015年8月9日
 */
public class Testable {

    public void execute() {
        System.out.println("Executing..");
    }

    /**
     * 注解本身并不做任何事情,但是编译器要确保在构造路径上必须有@Test注解定义,被注解的方法与其他方法没有区别
     * 注解@Test可以与任何修饰符共同作用于方法,例如publi,static或void,从语法的角度,注解的使用方式机会与修饰符
     * 的一模一样
     */
    @Test
    void testExecute() {
        execute();
    }
} /// :~
