package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_03.toys;
//: typeinfo/NullRobot.java
// Using a dynamic proxy to create a Null Object.

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_08_00.空对象.a14_08_01.Operation;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_08_00.空对象.a14_08_01.Robot;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_08_00.空对象.a14_08_01.Robot.Test;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_08_00.空对象.a14_08_01.SnowRemovalRobot;
import net.mindview.util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

class NullRobotProxyHandler implements InvocationHandler {

    private String nullName;
    private Robot proxied = new NRobot();

    NullRobotProxyHandler(Class<? extends Robot> type) {
        nullName = type.getSimpleName() + " NullRobot";
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }

    private class NRobot implements Null, Robot {

        public String name() {
            return nullName;
        }

        public String model() {
            return nullName;
        }

        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }
}

public class NullRobot {

    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(), new Class[]{Null.class, Robot.class}, new NullRobotProxyHandler(type));
    }

    public static void main(String[] args) {
        Robot[] bots = {new SnowRemovalRobot("SnowBee"), newNullRobot(SnowRemovalRobot.class)};
        for (Robot bot : bots)
            Test.test(bot);
    }
} /* Output:
Robot name: SnowBee
Robot model: SnowBot Series 11
SnowBee can shovel snow
SnowBee shoveling snow
SnowBee can chip ice
SnowBee chipping ice
SnowBee can clear the roof
SnowBee clearing roof
[Null Robot]
Robot name: SnowRemovalRobot NullRobot
Robot model: SnowRemovalRobot NullRobot
*///:~
