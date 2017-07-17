package cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_03.无界通配符;

//: generics/UnboundedWildcards2.java

import java.util.HashMap;
import java.util.Map;

/**
 * 展示无界通配符的一个重要应用,当你在处理多个泛型参数时,有时允许一个参数可以是任何类型,同时为其他参数确定某种特定类型的这种能力会显得很重要
 *
 * @author fengyu
 * @date 2015年8月13日
 */
public class UnboundedWildcards2 {

    static Map map1;
    //但是拥有的全部都是无界通配符时,就像Map<?,?>,编译器看起来就无法将其 与原生Map区分开来
    static Map<?, ?> map2;
    static Map<String, ?> map3;

    static void assign1(Map map) {
        map1 = map;
    }

    static void assign2(Map<?, ?> map) {
        map2 = map;
    }

    static void assign3(Map<String, ?> map) {
        map3 = map;
    }

    public static void main(String[] args) {
        assign1(new HashMap());
        assign2(new HashMap());
        // assign3(new HashMap()); // Warning:
        // Unchecked conversion. Found: HashMap
        // Required: Map<String,?>
        assign1(new HashMap<String, Integer>());
        assign2(new HashMap<String, Integer>());
        assign3(new HashMap<String, Integer>());
    }
} /// :~
