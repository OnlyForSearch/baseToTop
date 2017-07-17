package cn.feng.thinkInJava.a9_3_容器.containers.a17_10_04.对Set的选择.exercise;
//: containers/E34_StringSetPerformance.java
// {Args: 1000 500} Medium to keep build testing reasonable
/**
 * ***************** Exercise 34 ************************
 * Modify SetPerformance.java so that the Sets hold String
 * objects instead of Integers. Use a Generator from the
 * Arrays chapter to create test values.
 * *******************************************************
 */
/**
 * 修改SetPerformance,使Set持有String而不是Integer,对象,使用Generator来创建测试值
 *
 * */
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.Test;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.TestParam;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.Tester;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;

import java.util.*;


public class E34_StringSetPerformance {

    static List<Test<Set<String>>> tests = new ArrayList<Test<Set<String>>>();

    static {
        tests.add(new Test<Set<String>>("add") {
            public int test(Set<String> set, TestParam tp) {
                Generator<String> gen;
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    set.clear();
                    // Always starts the sequence from the beginning.
                    gen = new CountingGenerator.String();
                    for (int j = 0; j < size; j++)
                        set.add(gen.next());
                }
                return loops * size;
            }
        });
        tests.add(new Test<Set<String>>("contains") {
            public int test(Set<String> set, TestParam tp) {
                Generator<String> gen = new CountingGenerator.String(5);
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++)
                        set.contains(gen.next());
                return loops * span;
            }
        });
        tests.add(new Test<Set<String>>("iterate") {
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<String> it = set.iterator();
                    while (it.hasNext())
                        it.next();
                }
                return loops * set.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<String>(), tests);
        Tester.run(new HashSet<String>(), tests);
        Tester.run(new LinkedHashSet<String>(), tests);
    }
} /* Output: (Sample)
------------- TreeSet -------------
size add contains iterate
1000 687 497 58
------------- HashSet -------------
size add contains iterate
1000 517 360 66
---------- LinkedHashSet ----------
size add contains iterate
1000 528 338 110
*///:~