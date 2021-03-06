package cn.feng.thinkInJava.a9_3_容器.containers.a17_10_02.对List的选择.exercise;
//: containers/E30_SortPerformance.java
// {Args: 1000 500}
/**
 * *************** Exercise 30 *****************
 * Compare the performance of Collections.sort()
 * between an ArrayList and a LinkedList.
 * *********************************************
 */
/**在ArrayList 和  LinkedList.之间测试 Collections.sort()的性能*/
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.Test;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.TestParam;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.Tester;
import net.mindview.util.CollectionData;
import net.mindview.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class E30_SortPerformance {

    static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();

    static {
        tests.add(new Test<List<Integer>>("sort") {
            public int test(List<Integer> list, TestParam tp) {
                for (int i = 0; i < tp.loops; i++) {
                    list.clear();
                    list.addAll(CollectionData.list(new RandomGenerator.Integer(), tp.size));
                    Collections.sort(list);
                }
                return tp.loops;
            }
        });
    }
    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        ListTester.run(new ArrayList<Integer>(), tests);
        ListTester.run(new LinkedList<Integer>(), tests);
    }

    static class ListTester extends Tester<List<Integer>> {

        public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
            super(container, tests);
        }
        // Convenience method:
        public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }
        // Fill to the appropriate size before each test:
        @Override
        protected List<Integer> initialize(int size) {
            container.clear();
            container.addAll(CollectionData.list(new RandomGenerator.Integer(), size));
            return container;
        }
    }
} /* Output: (Sample)
- ArrayList -
size sort
1000 529815
- LinkedList -
size sort
1000 527436
*///:~