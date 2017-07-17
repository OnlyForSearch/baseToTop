package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_06_02.ListIterator.exercise;// holding/Ex12.java
// TIJ4 Chapter Holding, Exercise 12, page 410
/* Create and populate a List<Integer>. Create a second List<Integer> of the
* same size as the first, and use ListIterator to read elements of the first
* List and insert them into the second in reverse order. (You may want to 
* explore a number of different ways to solve this problem.)
*/
/**
 * 创建并组装一个i额List<Integer>,然后创建第二个具有相同尺寸的List<Integer>
 *     ,并使用ListIterator读取第一个List中的元素,然后在将他们以反序列插入到第二个
 *     列表中
 * )*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static cn.feng.utils.Print.println;

public class Ex12 {

    public static void main(String[] args) {
        List<Integer> li1 = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));
        List<Integer> li2 = new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8, 9));
        ListIterator<Integer> it1 = li1.listIterator();
        ListIterator<Integer> it2 = li2.listIterator();
        println("li1: " + li1);
        println("li2: " + li2);
        // move it1 to end:
        while (it1.hasNext())
            it1.next();
        // now use it2 to re-set li2:
        while (it2.hasNext()) {
            it2.next();
            it2.set(it1.previous());
        }
        println("li1: " + li1);
        println("li2: " + li2);

    }
}