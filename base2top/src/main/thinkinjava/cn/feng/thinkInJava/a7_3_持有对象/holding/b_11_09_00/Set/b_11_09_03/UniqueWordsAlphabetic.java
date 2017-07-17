package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_09_00.Set.b_11_09_03;
//: holding/UniqueWordsAlphabetic.java
// Producing an alphabetic listing.

import net.mindview.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

public class UniqueWordsAlphabetic {

    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);//构造器传入一个比较器,按字母顺序排序
        words.addAll(new TextFile("SetOperations.java", "\\W+"));
        System.out.println(words);
    }
} /* Output:
[A, add, addAll, added, args, B, C, class, Collections, contains, containsAll, D, E, F, false, from, G, H, HashSet, holding, I, import, in, J, java, K, L, M, main, mindview, N,
net, new, Output, Print, public, remove, removeAll, removed, Set, set1, set2, SetOperations, split, static, String, to, true, util, void, X, Y, Z]
*///:~
