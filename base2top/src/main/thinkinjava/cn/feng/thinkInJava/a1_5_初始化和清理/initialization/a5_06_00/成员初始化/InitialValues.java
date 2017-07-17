package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_06_00.成员初始化;
//: initialization/InitialValues.java
// Shows default initial values.

import static net.mindview.util.Print.print;

/**
 * 成员初始化
 *Java尽力保证：所有变量在使用前都能得到恰当的初始化。对于局部变量,java以编译时错误形式来保证,
 * @author fengyu
 * @date 2015年8月9日
 */
public class InitialValues {
    /**对于局部变量,java以编译时错误形式来保证,强制程序员提供一个初始化值*/
    void setF(){
        //int i;
        //i++;
    }

    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;
    public static void main(String[] args) {
        InitialValues iv = new InitialValues();
        iv.printInitialValues();
    /* You could also say:
    new Initi1alValues().printInitialValues();
    */
    }
    void printInitialValues() {
        print("Data type      Initial value");
        print("boolean        " + t);
        print("char           [" + c + "]");
        print("char(int)      [" + (int)c + "]");
        print("byte           " + b);
        print("short          " + s);
        print("int            " + i);
        print("long           " + l);
        print("float          " + f);
        print("double         " + d);
        print("reference      " + reference);
    }/**类的每个基本类型数据成员保证都会有一个初始值
     * 。在类里定义一个对象引用时，如果不将其初始化，此引用就会获得一个特殊值null。*/
} /* Output:
Data type      Initial value
boolean        false
char           [ ]
byte           0
short          0
int            0
long           0
float          0.0
double         0.0
reference      null
*///:~
