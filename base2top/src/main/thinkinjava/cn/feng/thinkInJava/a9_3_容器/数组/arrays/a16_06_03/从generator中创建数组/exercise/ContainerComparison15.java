package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_06_03.从generator中创建数组.exercise;// arrays/ContainerComparison15.java
// TIJ4 Chapter Arrays, Exercise 15, page 775
// Modify ContainerComparison.java by creating a Generator for 
// BerylliumSphere, and change main() to use that Generator
// with Generated.array().

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * 修改ContainerComparison.java,创建一个用于BerylliumSphere,的Generator并修改
 * main()方法,在将这个generator作用于Generated.array()
 */
class BerylliumSphere {

    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}

class BerylliumSphereGenerator implements Generator<BerylliumSphere> {

    public BerylliumSphere next() {
        return new BerylliumSphere();
    }
}

public class ContainerComparison15 {

    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[5];
        BerylliumSphereGenerator bsg = new BerylliumSphereGenerator();
        Generated.array(spheres, bsg);
        print(Arrays.toString(spheres));
        print(spheres[4]);
        List<BerylliumSphere> sphereList = new ArrayList<BerylliumSphere>();
        for (int i = 0; i < 5; i++)
            sphereList.add(bsg.next());
        print(sphereList);
        print(sphereList.get(4));
    }
}