package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_02.在return中使用finally;
//: exceptions/MultipleReturns.java

import static net.mindview.util.Print.print;

public class MultipleReturns {
//因为finally子句总是会被执行,说所以在一个方法中,可以从对个点返回,并且保证中重要的清理工作仍旧会被执行
    public static void f(int i) {
        print("Initialization that requires cleanup");
        try {
            print("Point 1");
            if (i == 1)
                return;
            print("Point 2");
            if (i == 2)
                return;
            print("Point 3");
            if (i == 3)
                return;
            print("End");
            return;
        } finally {
            print("Performing cleanup");
        }
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++)
            f(i);
    }
} /* Output:
Initialization that requires cleanup
Point 1
Performing cleanup
Initialization that requires cleanup
Point 1
Point 2
Performing cleanup
Initialization that requires cleanup
Point 1
Point 2
Point 3
Performing cleanup
Initialization that requires cleanup
Point 1
Point 2
Point 3
End
Performing cleanup
*///:~
