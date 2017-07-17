package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_01_00.初始化方式_4种方式.exercise;// reusing/Airplane.java
// TIJ4, Chapter Reusing, Exercise 1, page 241 
/* Create a simple class. Inside a second class, define a reference to an object of
* the first class. Use lazy initialization to instantiate this object.
*
*/

//用惰性初始化实例对象

import static cn.feng.utils.Print.println;
import static net.mindview.util.Print.print;

class Engine {

    private String s;
    Engine() {
        println("Engine()");
        s = "Constructed";
    }
    public String toString() { return s; }
}

public class Airplane {

    private String fuselage, wings, tail;
    private Engine e;
    public Airplane() {
        println("Inside Airplane()");
        fuselage = "Body";
        wings = "Airfoils";
        tail = "Empennage";
    }
    public static void main(String[] args) {
        Airplane N1234 = new Airplane();
        print(N1234);
    }
    public String toString() {
        if (e == null) // lazy (delayed) initialization:
            e = new Engine();
        return "fuselage = " + fuselage + ", " +
                "wings = " + wings + ", " +
                "tail = " + tail + ", " +
                "Engine = " + e;
    }
}