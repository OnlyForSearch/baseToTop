//: net/mindview/util/Sets.java
package net.mindview.util;

import java.util.HashSet;
import java.util.Set;

/**
 * 一个Set的实用工具
 *
 * @author fengyu
 * @date 2015年8月12日
 */
public class Sets {

    /**
     * 将第一个参数Set赋值了一份,将set中所有的引用都存入一个新的HashSet对象中,,因此并为直接修改参数中的Set它将两个参数合并在一起
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }
    /**
     * 将第一个参数Set赋值了一份,将set中所有的引用都存入一个新的HashSet对象中,,因此并为直接修改参数中的Set
     * 返回Set中只包含两个参数共有的部分
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }
    /**
     * 将第一个参数Set赋值了一份,将set中所有的引用都存入一个新的HashSet对象中,,因此并为直接修改参数中的Set
     * 从sperset中移除subset包含的元素
     */
    // Subtract subset from superset:
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = new HashSet<T>(superset);
        result.removeAll(subset);
        return result;
    }

    // Reflexive--everything not in the intersection:
    /**
     * 返回Set包含除了交集之外的所有元素
     */
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
} /// :~
