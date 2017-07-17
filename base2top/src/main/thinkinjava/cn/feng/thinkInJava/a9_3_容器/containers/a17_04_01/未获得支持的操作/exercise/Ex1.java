package cn.feng.thinkInJava.a9_3_容器.containers.a17_04_01.未获得支持的操作.exercise;// containers/Ex1.java
// TIJ4 Chapter Containers, Exercise 1, page 809
/* Create a List (try both ArrayList and LinkedList) and fill it using
* Countries. Sort the list and print it, then apply Collections.shuffle()
* to the list repeatedly, printing it each time so that you can see how 
* the shuffle() method randomizes the list differently each time.
*/

import net.mindview.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static cn.feng.utils.Print.println;

/**
 * 创建一个List(用ArrayList和LinkedList都尝试一下),然后用Countries来填充,对该列表排序并打印
 * ,然后Collections.shuffle()方法重复地应用于该列表,并且每次都打印它,这样你就可以看到shuffle()
 * 方法每次都将列表随机打乱的了
 */
public class Ex1 {

    public static void main(String[] args) {
        List<String> al = new ArrayList<String>();
        List<String> ll = new LinkedList<String>();
        for (int i = 0; i < Countries.DATA.length; i++) {
            al.add(Countries.DATA[i][0]);
            ll.add(Countries.DATA[i][1]);
        }
        Collections.sort(al);
        Collections.sort(ll);
        println("Countries: " + al);
        println("Capitals: " + ll);
        for (int i = 0; i < 2; i++) {
            Collections.shuffle(al);
            Collections.shuffle(ll);
            println("Countries " + i + ": " + al);
            println("Capitals " + i + ": " + ll);
        }
        List<String> al2 = new ArrayList<String>();
        List<String> ll2 = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            al2.add(Countries.DATA[i][0]);
            ll2.add(Countries.DATA[i][1]);
        }
        for (int i = 0; i < 5; i++) {
            Collections.shuffle(al2);
            Collections.shuffle(ll2);
            println("Countries " + i + ": " + al2);
            println("Capitals " + i + ": " + ll2);
            Collections.sort(al2);
            Collections.sort(ll2);
        }
    }
}