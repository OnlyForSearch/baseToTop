package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_07_04.数组的排序;

//: arrays/StringSorting.java
// Sorting an array of Strings.

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;

import static net.mindview.util.Print.print;

/**
 * 数组排序
 *使用内置的排序方法，可以对任意的基本类型数组排序，也可以对对象数组排序，只要该
 * 对象实现了Comparable接口，或者具有相关联的Comparator
 Java标准库中的排序算法针对正排序的特殊类型进行了优化： 针对基本类型的快速排序；
 针对对象设计的“稳定归并排序”。所以无需担心排序的性能问，除非确实确定了排序部分是程序效率的瓶颈。
 * @author fengyu
 * @date 2015年8月9日
 */
public class StringSorting {

    public static void main(String[] args) {
        String[] sa = Generated.array(new String[20], new RandomGenerator.String(5));
        print("Before sort: " + Arrays.toString(sa));
        //String排序算法是依据词典编排顺序排序,所以大写字母开头的词都放在前面,然后才是小写字母
        Arrays.sort(sa);
        print("After sort: " + Arrays.toString(sa));
        Arrays.sort(sa, Collections.reverseOrder());
        print("Reverse sort: " + Arrays.toString(sa));
        //忽略大小写排序使用String.CASE_INSENSITIVE_ORDER
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        print("Case-insensitive sort: " + Arrays.toString(sa));
    }
} /* Output:
Before sort: [YNzbr, nyGcF, OWZnT, cQrGs, eGZMm, JMRoE, suEcU, OneOE, dLsmw, HLGEa, hKcxr, EqUCB, bkIna, Mesbt, WHkjU, rUkZP, gwsqP, zDyCy, RFJQA, HxxHv]
After sort: [EqUCB, HLGEa, HxxHv, JMRoE, Mesbt, OWZnT, OneOE, RFJQA, WHkjU, YNzbr, bkIna, cQrGs, dLsmw, eGZMm, gwsqP, hKcxr, nyGcF, rUkZP, suEcU, zDyCy]
Reverse sort: [zDyCy, suEcU, rUkZP, nyGcF, hKcxr, gwsqP, eGZMm, dLsmw, cQrGs, bkIna, YNzbr, WHkjU, RFJQA, OneOE, OWZnT, Mesbt, JMRoE, HxxHv, HLGEa, EqUCB]
Case-insensitive sort: [bkIna, cQrGs, dLsmw, eGZMm, EqUCB, gwsqP, hKcxr, HLGEa, HxxHv, JMRoE, Mesbt, nyGcF, OneOE, OWZnT, RFJQA, rUkZP, suEcU, WHkjU, YNzbr, zDyCy]
*///:~
