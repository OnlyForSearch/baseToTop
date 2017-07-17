package cn.feng.thinkInJava.b2_1_注解;

import net.mindview.atunit.Test;

/*
 * 注解(也被称为元数据)为我们在代码中添加信息提供了一种形式化的方法,使我们可以在稍后某个时刻非常方便地使用这些数据    JDK中内置的三种标准注解
 * 
 * @Override 表示当前的方法定义将覆盖超类中的方法,如果不小心拼写错误,或者方法签名对不上被覆盖的方法,编译器就会发出错误提示
 * @Deprecated 程序员是用来它注解的元素,那么编译器就会发出警告
 * 
 * @SuppressWainings 关闭不当的警告
 */
/*
 * 四种元注解:元注解专职负责注解其它的注解 
 * @Target 表示注解可以用于什么地方,ElementType常量 
 * 	表示该注解可以用于干什么.可能的ElementType参数包括: 
 *	CONSTRUCTOR:构造器的声明 
 * 	FIELD:域声明(包括enum实例)
 *  LOCAL_VARIABLE:局部变量声明
 *  METHOD:方法声明
 *  PACKAGE:包声明
 *  PARAMETER:参数声明 
 *	TYPE:类,接口(包括注解类型)或enum声明	
 * 
 * 
 * 
 * 
 * @Retention 表示注解需要在什么级别保存该注解信息 RetentionPolicy常量
 * 表示需要在什么级别保存该注解信息.可选的RetentionPolicy参数包括: 
 *	SOURCE:注解将被编译器丢弃 
 *	CLASS:注解在class文件中可用,但会被VM丢弃 
 *	RUNTIME:VM将在运行期也保留注解,因此可以通过反射机制读取注解的信息
 * 
 * 
 *  @Documented 将此注解包含在javadoc中 
 * @Inherited 允许子类继承父中的注解
 */

public class 注解 {

    public void execute() {
        System.out.println("Executing..");
    }
    //从语法的角度来看,注解的使用方式几乎与修饰符使用一模一样
    @Test
    void testExecute() {
        execute();
    }
}
