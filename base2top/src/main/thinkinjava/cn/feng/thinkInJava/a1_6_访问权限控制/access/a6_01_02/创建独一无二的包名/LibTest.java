package cn.feng.thinkInJava.a1_6_访问权限控制.access.a6_01_02.创建独一无二的包名;
//: access/LibTest.java
// Uses the library.

import net.mindview.simple.List;
import net.mindview.simple.Vector;

/**
 * 创建独一无二的包名:Java包的命名规则全部使用小写字母，第一部分是创建者的反顺序的域名。
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class  LibTest {

    public static void main(String[] args) {
        Vector v = new Vector();
        List l = new List();
    }
} /* Output:
net.mindview.simple.Vector
net.mindview.simple.List
*///:~
