package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_08_00.空对象.a14_08_01;
//: typeinfo/Robot.java

import net.mindview.util.Null;

import java.util.List;
//使用嵌套类来执行测试
public interface Robot {

    String name();

    String model();

    List<Operation> operations();

    class Test {

        public static void test(Robot r) {
            if (r instanceof Null)
                System.out.println("[Null Robot]");
            System.out.println("Robot name: " + r.name());
            System.out.println("Robot model: " + r.model());
            for (Operation operation : r.operations()) {
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
} ///:~
