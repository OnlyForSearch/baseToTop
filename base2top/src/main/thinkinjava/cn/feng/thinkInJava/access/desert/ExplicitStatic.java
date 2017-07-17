package cn.feng.thinkInJava.access.desert;

import static cn.feng.utils.Print.print;
import static cn.feng.utils.Print.println;

class Cup {

    public Cup(int marker) {
        println("Cup:" + marker + ";");
    }

    void f(int marker) {
        println("f:" + marker + "");
    }

}

class Cups {

    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        println("Cups");
    }

}

public class ExplicitStatic {

    public static void main(String args[]) {

        print("inside mainI()");
        Cups.cup1.f(1);
    }

}