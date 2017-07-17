package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_01.任何基本类型都不能作为类型参数;
//: generics/ByteSet.java

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 泛型的问题:
 *
 * @author fengyu
 * @date 2015年8月13日
 */
public class ByteSet {

    Byte[] possibles = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Set<Byte> mySet = new HashSet<Byte>(Arrays.asList(possibles));
    // But you can't do this:
    // Set<Byte> mySet2 = new HashSet<Byte>(
    //   Arrays.<Byte>asList(1,2,3,4,5,6,7,8,9));
} ///:~
