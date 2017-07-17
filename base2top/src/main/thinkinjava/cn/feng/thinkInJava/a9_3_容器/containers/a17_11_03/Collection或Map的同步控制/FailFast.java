package cn.feng.thinkInJava.a9_3_容器.containers.a17_11_03.Collection或Map的同步控制;
//: containers/FailFast.java
// Demonstrates the "fail-fast" behavior.

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
/**
 *快速报错
 Java容器有一种保护机制，能够防止多个进程同时修改同一个容器的内容。Java容器类类库采用快速报错机制(fail-fast)
 。它会探查容器上的任何除了你的进程所进行的操作以外的所有变化，一旦它发现其他进程修改了容器，就会立刻抛出ConcurrentModificationException异常。这就是“快速报错”的意思——即，不是使用复制的算法在事后来检查问题。
 “快速报错”机制的工作原理：只需创建一个迭代器，然后向迭代器所指向的Collection添加点什么

 在容器取得迭代器之后，又有东西被放入到了该容器中。当程序的不同部分修改同一个容器时，就可能导致容器的状态不一致，所以，此异常提醒你，应该修改代码。在此例中，应该添加完所有的元素之后，再获取迭代器。

 ConcurrentHashMap、CopyOnWriteArrayList、CopyOnWriteArraySet都使用了可以避免ConcurrentModificationException 的技术
 *
 * */
public class FailFast {

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        Iterator<String> it = c.iterator();
        c.add("An object");
        try {
            String s = it.next();
        } catch (ConcurrentModificationException e) {
            System.out.println(e);
        }
    }
} /* Output:
java.util.ConcurrentModificationException
*///:~
