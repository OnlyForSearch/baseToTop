package cn.feng.thinkInJava.a1_6_访问权限控制.access.a6_04_00.exercise.concention;

public class Connection {

    private static int counter = 0;
    private int id = counter++;
    Connection() {}
    public String toString() {
        return "Connection " + id;
    }
    public void doSomething() {}
} ///:~