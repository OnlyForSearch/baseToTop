package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_07_02.使用嵌套类放置测试代码;

//: innerclasses/TestBed.java
// Putting test code in a nested class.
// {main: TestBed$Tester}

public class TestBed {

    public void f() {
        System.out.println("f()");
    }

    public static class Tester {

        /**
         * 在嵌套类中放置测试代码
         */
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }
} /*
 * Output: f()
 */// :~
