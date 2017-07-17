package cn.feng.thinkInJava.a9_3_容器.containers.a17_13_00.Vector和Enumeration;
//: containers/Enumerations.java
// Java 1.0/1.1 Vector and Enumeration.

import net.mindview.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

/**
 * vector和Enumeration
 *避免使用Vector,Enumeration,Hashtable,Stack,BitSet，尽量使用ArrayList,Iterator,HashMap,
 * LinkedList,EnumSet来替代它们。
 * @author fengyu
 * @date 2015年8月9日
 */
public class Enumerations {

    public static void main(String[] args) {
        Vector<String> v = new Vector<String>(Countries.names(10));
        Enumeration<String> e = v.elements();
        while (e.hasMoreElements())
            System.out.print(e.nextElement() + ", ");
        // Produce an Enumeration from a Collection:
        e = Collections.enumeration(new ArrayList<String>());
    }
} /* Output:
ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC,
*///:~
