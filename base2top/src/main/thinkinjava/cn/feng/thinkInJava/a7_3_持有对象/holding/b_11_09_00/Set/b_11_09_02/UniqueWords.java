package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_09_00.Set.b_11_09_02;//: holding/UniqueWords.java

import net.mindview.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {

    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(
                //在构造器打开文件,并根据正则表达式"\\W+"(1个或多个字母)断开为单词
                new TextFile("io/SetOperations.java", "\\W+"));
        System.out.println(words);
    }
} /* Output:
[A, B, C, Collections, D, E, F, G, H, HashSet, I, J, K, L, M, N, Output, Print, Set, SetOperations, String, X, Y, Z, add, addAll, added, args, class, contains, containsAll,
false, from, holding, import, in, java, main, mindview, net, new, print, public, remove, removeAll, removed, set1, set2, split, static, to, true, util, void]
*///:~
