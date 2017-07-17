package cn.feng.thinkInJava.a9_3_容器.containers.a17_11_03.Collection或Map的同步控制;
//: containers/Synchronization.java
// Using the Collections.synchronized methods.

import java.util.*;

/**
 * 设定Collection或Map为 同步控制
 *Collections类有办法能够自动同步整个容器。其语法与“不可修改的”方法相似。
 * @author fengyu
 * @date 2015年8月9日
 */
public class Synchronization {
    //最好的示例一样,直接将新生成的容器传递给了适当的"同步方法",这样做就不会有任何机会暴露不同步的版本
    public static void main(String[] args) {
        Collection<String> c = Collections.synchronizedCollection(new ArrayList<String>());
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        Set<String> s = Collections.synchronizedSet(new HashSet<String>());
        Set<String> ss = Collections.synchronizedSortedSet(new TreeSet<String>());
        Map<String, String> m = Collections.synchronizedMap(new HashMap<String, String>());
        Map<String, String> sm = Collections.synchronizedSortedMap(new TreeMap<String, String>());
    }
} ///:~
