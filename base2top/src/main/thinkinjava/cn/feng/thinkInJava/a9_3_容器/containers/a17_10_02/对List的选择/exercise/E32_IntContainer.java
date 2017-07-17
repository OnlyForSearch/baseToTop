package cn.feng.thinkInJava.a9_3_容器.containers.a17_10_02.对List的选择.exercise;

//: containers/E32_IntContainer.java
/**
 * *************** Exercise 32 ******************
 * Repeat the previous exercise for a container of
 * int, and compare the performance to an
 * ArrayList<Integer>. In your performance comparison,
 * include the process of incrementing each object
 * in the container.
 * *********************************************
 */
/**重复前一个练习,使容器中包含int,并与与ArrayList<Integer>比较性能,在性能比较中
 * ,包括递增容器中每个对象的处理
 *
 * */
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.Test;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.TestParam;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.Tester;

import java.util.ArrayList;
import java.util.List;


class IntContainer {

    private static final int INCR = 255;
    private int[] array;
    private int index;
    public IntContainer() {
        array = new int[10];
    }
    public IntContainer(int sz) {
        array = new int[sz];
    }
    public void add(int i) {
        if (index >= array.length) {
            int[] tmp = new int[array.length + INCR];
            for (int j = 0; j < array.length; j++)
                tmp[j] = array[j];
            index = array.length;
            array = tmp;
        }
        array[index++] = i;
    }
    public int get(int i) { return array[i]; }
    public void set(int i, int val) { array[i] = val; }
    public int size() { return index; }
}

public class E32_IntContainer {

    static final int LOOPS = 10000;
    static List<Test<List<Integer>>> alTests = new ArrayList<Test<List<Integer>>>();
    static List<Test<IntContainer>> icTests = new ArrayList<Test<IntContainer>>();

    static {
        alTests.add(new Test<List<Integer>>("addget") {
            public int test(List<Integer> list, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    list.add(i);
                    list.set(i, list.get(i) + 1);
                }
                return LOOPS;
            }
        });
        icTests.add(new Test<IntContainer>("addget") {
            public int test(IntContainer ic, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    ic.add(i);
                    ic.set(i, ic.get(i) + 1);
                }
                return LOOPS;
            }
        });
    }

    public static void main(String[] args) {
        // Parameters are also hard-coded inside tests.
        Tester.defaultParams = TestParam.array(LOOPS, 1);
        Tester.run(new ArrayList<Integer>(LOOPS), alTests);
        Tester.run(new IntContainer(LOOPS), icTests);
    }
} /* Output: (Sample)
- ArrayList -
size addget
10000 8975
IntContainer
size addget
10000 491
*///:~
//IntContainer is significantly faster than ArrayList.