package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.interfacea.a14_09_00.接口与类型信息.exercise;// typeinfo/Finder25.java
// TIJ4 Chapter Typeinfo, Exercise 25, page 613
/* Create a class containing private, protected and package-access methods. 
* Write code to access these methods from outside of the class's package.
*/

/* Solution includes, in another package:
* package typeinfo.secret;
* public interface A {
*	void e();
* }
* // and:
* package typeinfo.secret;
* import static org.greggordon.tools.Print.*;
*
* class Secret implements A {
*	public void e() { println("public Secret.e()"); } 
*	void f() { println("package Secret.f()"); }
*	protected void g() { println("protected Secret.g()"); }
*	private void h() { println("private Secret.h()"); }
* }
*
* public class SecretMaker {
*	public static A makeSecret() { return new Secret();  }
* }
*/


import java.lang.reflect.Method;

import static cn.feng.utils.Print.println;

/**
 * 创建一个包含private,protected和包访问权限方法的类,编写代码在该类所处的包外调用这些方法
 */
interface A {

    void e();
}

class Secret implements A {

    public void e() { println("public Secret.e()"); }
    void f() { println("package Secret.f()"); }
    protected void g() { println("protected Secret.g()"); }
    private void h() { println("private Secret.h()"); }
}

class SecretMaker {

    public static A makeSecret() { return new Secret(); }
}

public class Finder25 {

    public static void main(String[] args) throws Exception {
        A a = SecretMaker.makeSecret();
        println("a is of class type: " + a.getClass().getName());
        for (Method m : a.getClass().getDeclaredMethods()) {
            m.setAccessible(true);
            m.invoke(a);
        }
    }
}