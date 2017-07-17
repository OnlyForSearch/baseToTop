package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_04_02.名称屏蔽.exercise;// reusing/Overload.java
// TIJ4 Chapter Reusing, Exercise 13, page 256
/* Create a class with a method that is overloaded three times. Inherit a new 
* class, add a new overloading of the method, and show that all four methods are
* available in the derived class.
*/

import static cn.feng.utils.Print.println;

class ThreeWay {//重载3次
    void number(byte b) { println(b); }
    void number(short s) { println(s); }
    void number(int i) { println(i); }
}

class Overload extends ThreeWay {//再次重载
    public static void main(String[] args) {
        //展示四个方法在导出类中都是可以用的
        Overload ov = new Overload();
        ov.number((byte) 0);
        ov.number((short) 1);
        ov.number(2);
        ov.number(3.0f);
    }
    void number(float f) { println(f); }
}