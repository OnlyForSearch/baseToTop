package cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_03.无界通配符;

//: generics/UnboundedWildcards1.java

import java.util.ArrayList;
import java.util.List;

/**
 * 无界通配符<?>看起来意味着"任何事物",因此使用无界通配符好像等价于使用原生类型,事实上,编译器初看起来是支持这种判断的
 * .实际上是在声明:我是想用将java的泛型来编写这段代码,我在这里并不是原生类型,但是在当前这种情况下,泛型参数可以持有任何类型
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class UnboundedWildcards1 {

    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;

    static void assign1(List list) {
        list1 = list;
        list2 = list;
        // list3 = list; // Warning: unchecked conversion
        // Found: List, Required: List<? extends Object>
    }

    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }
/**List实际上表示“持有任何Object类型的原生List”，而List<?>表示“具有某种特定类型的非原生List，只是我们不知道那种类型是什么。”*/
    public static void main(String[] args) {
        assign1(new ArrayList());
        assign2(new ArrayList());
        // assign3(new ArrayList()); // Warning:
        // Unchecked conversion. Found: ArrayList
        // Required: List<? extends Object>
        assign1(new ArrayList<String>());
        assign2(new ArrayList<String>());
        assign3(new ArrayList<String>());
        // Both forms are acceptable as List<?>:
        List<?> wildList = new ArrayList();
        wildList = new ArrayList<String>();
        assign1(wildList);
        assign2(wildList);
        assign3(wildList);
    }
} // /:~
