package cn.feng.thinkInJava.a9_3_容器.containers.a17_10_02.对List的选择.exercise;
//: containers/E31_StringContainer.java
/**
 * *************** Exercise 31 ******************
 * Create a container that encapsulates an array of
 * String, and that only allows adding Strings and
 * getting Strings, so that there are no casting
 * issues during use. If the internal array isn’t big
 * enough for the next add, your container should
 * automatically resize it. In main(), compare the
 * performance of your container with an
 * ArrayList<String>.
 * *********************************************
 */
/**
 * 创建一个封装Stirng数组的容器,该容器只允许添加和读取String,因此使用过程中
 * 不存在任何转型问题,如果再添加下一个元素时候,内部数据没有足够的空间,该容器应该自动
 * 调整尺寸,在main()中比较你的容器与ArrayList的性能
 * */
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.Test;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.TestParam;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.Tester;

import java.util.ArrayList;
import java.util.List;


class StringContainer {

    private static final int INCR = 255;
    private String[] array;
    private int index;
    public StringContainer() {
        array = new String[10];
    }
    public StringContainer(int sz) {
        array = new String[sz];
    }
    public void add(String s) {
        if (index >= array.length) {
            String[] tmp = new String[array.length + INCR];
            for (int i = 0; i < array.length; i++)
                tmp[i] = array[i];
            index = array.length;
            array = tmp;
        }
        array[index++] = s;
    }
    public String get(int i) { return array[i]; }
    public int size() { return index; }
}

public class E31_StringContainer {

    static final int LOOPS = 10000;
    static List<Test<List<String>>> alTests = new ArrayList<Test<List<String>>>();
    static List<Test<StringContainer>> scTests = new ArrayList<Test<StringContainer>>();

    static {
        alTests.add(new Test<List<String>>("addget") {
            public int test(List<String> list, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    list.add(Integer.toString(i));
                    list.get(i);
                }
                return LOOPS;
            }
        });
        scTests.add(new Test<StringContainer>("addget") {
            public int test(StringContainer sc, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    sc.add(Integer.toString(i));
                    sc.get(i);
                }
                return LOOPS;
            }
        });
    }

    public static void main(String[] args) {
        // Parameters are also hard-coded inside tests.
        Tester.defaultParams = TestParam.array(LOOPS, 1);
        Tester.run(new ArrayList<String>(LOOPS), alTests);
        Tester.run(new StringContainer(LOOPS), scTests);
    }
} /* Output: (Sample)
- ArrayList -
size addget
10000 1266
StringContainer
size addget
10000 574
*///:~
/**
 * This simple though somewhat inaccurate test is from TIJ4. Note that the
 * ArrayList performance is close to what you might hand-code; this emphasizes
 * that you shouldn’t waste time writing containers yourself when you can use the
 * standard library. Wait to optimize code until you find the bottleneck by
 * thoroughly profiling your application.
 */