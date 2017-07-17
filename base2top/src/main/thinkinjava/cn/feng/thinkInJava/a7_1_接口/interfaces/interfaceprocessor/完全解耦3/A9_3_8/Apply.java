//: interfaces/interfaceprocessor/Apply.java
package cn.feng.thinkInJava.a7_1_接口.interfaces.interfaceprocessor.完全解耦3.A9_3_8;

import cn.feng.thinkInJava.a7_1_接口.interfaces.interfaceprocessor.完全解耦3.A9_3_7.Processor;

import static net.mindview.util.Print.print;

public class Apply {

    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }
} ///:~
