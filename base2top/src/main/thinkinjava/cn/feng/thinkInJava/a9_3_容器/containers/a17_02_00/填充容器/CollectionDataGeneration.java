package cn.feng.thinkInJava.a9_3_容器.containers.a17_02_00.填充容器;

//: containers/CollectionDataGeneration.java
// Using the Generators defined in the Arrays chapter.

import net.mindview.util.CollectionData;
import net.mindview.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

public class CollectionDataGeneration {

    public static void main(String[] args) {
        System.out.println(new ArrayList<String>(CollectionData.list( // Convenience
                //RandomGenerator.String长度通过构造器参数控制的									// method
                new RandomGenerator.String(9), 10)));
        System.out.println(new HashSet<Integer>(new CollectionData<Integer>(new RandomGenerator.Integer(), 10)));
    }
} /* Output:
[YNzbrnyGc, FOWZnTcQr, GseGZMmJM, RoEsuEcUO, neOEdLsmw, HLGEahKcx, rEqUCBbkI, naMesbtWH, kjUrUkZPg, wsqPzDyCy]
[573, 4779, 871, 4367, 6090, 7882, 2017, 8037, 3455, 299]
*///:~
