package cn.feng.thinkInJava.模式.适配器设计模式;

import static cn.feng.utils.Print.print;
import static cn.feng.utils.Print.println;

public class Apply {

    public static void process(Processor processor, Object s) {
        println("User processor:" + processor.name() + "  ");
        print(processor.process(s));
    }
}
