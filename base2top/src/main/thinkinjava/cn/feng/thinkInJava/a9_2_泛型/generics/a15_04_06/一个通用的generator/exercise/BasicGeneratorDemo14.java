package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_06.一个通用的generator.exercise;// generics/BasicGeneratorDemo14.java
// TIJ3 Chapter Generics, Exercise 14, page 639
/* Modify BasicGeneratorDemo.java to use the explicit form of creation for the
* Generator (that is, use the explict constructor instead of the generic 
* create() method). 
*/

import cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_06.一个通用的generator.CountedObject;
import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

/**
 * 修改BasicGeneratorDemo.java 类,使其显式地构造Generator(也就是不用create()方法,而是使用显示的构造器)
 */

public class BasicGeneratorDemo14 {

    public static void main(String[] args) {
        Generator<CountedObject> gen = new BasicGenerator<CountedObject>(CountedObject.class);
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
    }
}