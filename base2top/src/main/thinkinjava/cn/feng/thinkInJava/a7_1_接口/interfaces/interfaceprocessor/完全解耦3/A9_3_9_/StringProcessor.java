//: interfaces/interfaceprocessor/StringProcessor.java
package cn.feng.thinkInJava.a7_1_接口.interfaces.interfaceprocessor.完全解耦3.A9_3_9_;

import cn.feng.thinkInJava.a7_1_接口.interfaces.interfaceprocessor.完全解耦3.A9_3_7.Processor;
import cn.feng.thinkInJava.a7_1_接口.interfaces.interfaceprocessor.完全解耦3.A9_3_8.Apply;

import java.util.Arrays;

/**
 * 复用代码的第一中方式是客户端程序员遵循该接口来编写他们自己的类
 */
public abstract class StringProcessor implements Processor {

    public static String s = "If she weighs the same as a duck, she's made of wood";
    public static void main(String[] args) {
        Apply.process(new Upcase(), s);
        Apply.process(new Downcase(), s);
        Apply.process(new Splitter(), s);
    }
    public String name() {
        return getClass().getSimpleName();
    }
    public abstract String process(Object input);
}

class Upcase extends StringProcessor {

    public String process(Object input) { // Covariant return
        return ((String) input).toUpperCase();
    }
}

class Downcase extends StringProcessor {

    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {

    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
} /* Output:
Using Processor Upcase
IF SHE WEIGHS THE SAME AS A DUCK, SHE'S MADE OF WOOD
Using Processor Downcase
if she weighs the same as a duck, she's made of wood
Using Processor Splitter
[If, she, weighs, the, same, as, a, duck,, she's, made, of, wood]
*///:~
