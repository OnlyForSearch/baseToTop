package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_00.散列与散列码;
//: containers/SpringDetector.java
// What will the weather be?

import cn.feng.thinkInJava.a9_3_容器.containers.Prediction;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.Print.print;

public class  SpringDetector {

    // Uses a Groundhog or class derived from Groundhog:
    //detectSpring方法使用反射机制来实例化以及使用Groundhod类以及子类
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<Groundhog, Prediction>();
        for (int i = 0; i < 10; i++)
            map.put(ghog.newInstance(i), new Prediction());
        print("map = " + map);
        Groundhog gh = ghog.newInstance(3);
        print("Looking up prediction for " + gh);
        if (map.containsKey(gh))
            print(map.get(gh));
        else
            print("Key not found: " + gh);
    }
    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
    }
} /* Output:
map = {Groundhog #3=Early Spring!, Groundhog #7=Early Spring!, Groundhog #5=Early Spring!, Groundhog #9=Six more weeks of Winter!, Groundhog #8=Six more weeks of Winter!,
Groundhog #0=Six more weeks of Winter!, Groundhog #6=Early Spring!, Groundhog #4=Six more weeks of Winter!, Groundhog #1=Six more weeks of Winter!, Groundhog #2=Early Spring!}
Looking up prediction for Groundhog #3
Key not found: Groundhog #3
*///:~
