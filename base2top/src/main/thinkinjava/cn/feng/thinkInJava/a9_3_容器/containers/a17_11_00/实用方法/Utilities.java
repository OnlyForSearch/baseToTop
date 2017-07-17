package cn.feng.thinkInJava.a9_3_容器.containers.a17_11_00.实用方法;
//: containers/Utilities.java
// Simple demonstrations of the Collections utilities.

import java.util.*;

import static net.mindview.util.Print.print;

/**
 * 实用方法
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Utilities {

    public static List<String> list = Arrays.asList("one Two three Four five six one".split(" "));
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        print(list);
        print("'list' disjoint (Four)?: " + Collections.disjoint(list, Collections.singletonList("Four")));
        //返回参数Collection中最大或最小的元素——采用Collection内置的自然比较法
        /**注意：min()和max()能作用于Collection对象，所以你无需担心Collection是否应该被排序(只有在执行binar
         * ySearch()之前，才确实需要对List或数组进行排序)
         与使用数组进行查询和排序一样，如果使用Comparator进行排序，那么binarySearch()必须使用相同的Comparator。*/
        print("max: " + Collections.max(list));
        print("min: " + Collections.min(list));
        //回参数Collection中最大或最小的元素——采用Comparator进行比较,由于大小写的缘故造成的
        print("max w/ comparator: " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
        print("min w/ comparator: " + Collections.min(list, String.CASE_INSENSITIVE_ORDER));
        List<String> sublist = Arrays.asList("Four five six".split(" "));
        //返回target在source中第一次出现的位置，或者在找不到时返回-1
        print("indexOfSubList: " + Collections.indexOfSubList(list, sublist));
        //返回target在source中最后一次出现的位置，或者在找不到时返回-1
        print("lastIndexOfSubList: " + Collections.lastIndexOfSubList(list, sublist));
        //使用newVal替换所有的oldVal
        Collections.replaceAll(list, "one", "Yo");
        print("replaceAll: " + list);
        //逆转所有元素的次序
        Collections.reverse(list);
        print("reverse: " + list);
        //所有元素向后移动distance个位置，将末尾的元素循环到前面来
        Collections.rotate(list, 3);
        print("rotate: " + list);
        List<String> source = Arrays.asList("in the matrix".split(" "));
        //将src中的元素复制到dest
        Collections.copy(list, source);
        print("copy: " + list);
        //交换list中位置i和位置j的元素。通常比你自己写的代码快。
        Collections.swap(list, 0, list.size() - 1);
        print("swap: " + list);
      //  随机改变指定列表的顺序。第一种形式提供了其自己的随机机制，你可以通过第二种形式提供自己的随机机制
        Collections.shuffle(list, new Random(47));
        print("shuffled: " + list);
        //用对象x替换list中的所有元素
        Collections.fill(list, "pop");
        print("fill: " + list);
        print("frequency of 'pop': " + Collections.frequency(list, "pop"));
        //返回大小为n的List<T>,此List不可改变，其中的引用都指向x。
        List<String> dups = Collections.nCopies(3, "snap");
        print("dups: " + dups);
        //当两个集合没有任何相同元素时，返回true
        print("'list' disjoint 'dups'?: " + Collections.disjoint(list, dups));
        // Getting an old-style Enumeration:
        //为参数生成一个旧式的enumeration<T>
        Enumeration<String> e = Collections.enumeration(dups);
        Vector<String> v = new Vector<String>();
        while (e.hasMoreElements())
            v.addElement(e.nextElement());
        // Converting an old-style Vector
        // to a List via an Enumeration:
        //产生一个ArrayList<T>，它包含的元素的顺序，与（旧式的）Enumeration(Iterator的前身)返回这些元素的顺序相同。用来转换遗留的老代码。
        ArrayList<String> arrayList = Collections.list(v.elements());
        print("arrayList: " + arrayList);
    }
} /* Output:
[one, Two, three, Four, five, six, one]
'list' disjoint (Four)?: false
max: three
min: Four
max w/ comparator: Two
min w/ comparator: five
indexOfSubList: 3
lastIndexOfSubList: 3
replaceAll: [Yo, Two, three, Four, five, six, Yo]
reverse: [Yo, six, five, Four, three, Two, Yo]
rotate: [three, Two, Yo, Yo, six, five, Four]
copy: [in, the, matrix, Yo, six, five, Four]
swap: [Four, the, matrix, Yo, six, five, in]
shuffled: [six, matrix, the, Four, Yo, five, in]
fill: [pop, pop, pop, pop, pop, pop, pop]
frequency of 'pop': 7
dups: [snap, snap, snap]
'list' disjoint 'dups'?: true
arrayList: [snap, snap, snap]
*///:~
