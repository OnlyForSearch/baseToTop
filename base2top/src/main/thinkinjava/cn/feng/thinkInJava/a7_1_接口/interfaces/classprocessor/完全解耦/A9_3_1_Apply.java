//: interfaces/classprocessor/Apply.java
package cn.feng.thinkInJava.a7_1_接口.interfaces.classprocessor.完全解耦;

import java.util.Arrays;

import static net.mindview.util.Print.print;

class Processor {

    public String name() {
        return getClass().getSimpleName();
    }
    Object process(Object input) { return input; }
}

class Upcase extends Processor {

    String process(Object input) { // Covariant return
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {

    String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {

    String process(Object input) {
        // The split() argument divides a String into pieces:
        return Arrays.toString(((String) input).split(" "));
    }
}

public class A9_3_1_Apply {

    /**可以接受任何类型的Processor并将其应用到一个Object对象上*/
    public static String s = "Disagreement with beliefs is by definition incorrect";
    /**
     * 创建一个能够根据所传递的参数对象的不同而具有不同的行为的方法,成为策略设计模式,这类方法包含所要执行的算法中固定不变的部分,而策略包含
     * 变化的部分.策略就是传递进去的对象(p),它包含所要执行的代码
     */
    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }
    public static void main(String[] args) {
        //下面就是三种不同类型的策略应用到了String对象s上
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
} /* Output:
Using Processor Upcase
DISAGREEMENT WITH BELIEFS IS BY DEFINITION INCORRECT
Using Processor Downcase
disagreement with beliefs is by definition incorrect
Using Processor Splitter
[Disagreement, with, beliefs, is, by, definition, incorrect]
*///:~
