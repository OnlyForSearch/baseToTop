package cn.feng.thinkInJava.a6_1_多态.polymorphism.A8_5_0_1.用继承进行设计.exercise;// polymorphism/Transmogrify16.java
// TIJ4 Chapter Polymorphism, Exercise 16, page 306
/* Following the example in Transmogrify.java, create a Starship class
* containing an AlertStatus reference that can indicate three different states.
* Include methods to change the states.
*///包含一个Alerstatus引用,此引用可以指示三种不同的状态,

import static cn.feng.utils.Print.println;

class AlertStatus {

    public void alert() {}
}

class NormalAlert extends AlertStatus {

    public void alert() { println("AlertStatus Normal"); }

}

class HighAlert extends AlertStatus {

    public void alert() { println("AlertStatus High"); }
}

class MaximumAlert extends AlertStatus {

    public void alert() { println("AlertStatus Maximum"); }
}

class Starship {

    private AlertStatus alertStatus = new NormalAlert();
    public void normalAlert() { alertStatus = new NormalAlert(); }
    public void highAlert() { alertStatus = new HighAlert(); }
    public void maximumAlert() { alertStatus = new MaximumAlert(); }
    public void checkAlertStatus() { alertStatus.alert(); }
}

public class Transmogrify16 {

    public static void main(String[] args) {
        Starship ss = new Starship();
        ss.checkAlertStatus();
        ss.highAlert();
        ss.checkAlertStatus();
        ss.maximumAlert();
        ss.checkAlertStatus();
        ss.normalAlert();
        ss.checkAlertStatus();
    }
}

