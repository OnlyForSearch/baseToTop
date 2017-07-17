package cn.feng.thinkInJava.a9_3_容器.数组.arrays.在已排序的数组中查找.exercise;// arrays/Ex25.java
// TIJ4 Chapter Arrays, Exercise 25, page 789
// Rewrite PythonLists.py in Java.
//重写 PythonLists.py

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static net.mindview.util.Print.print;

//class MyList extends ArrayList<T> {
class MyList extends ArrayList {

    List myList = new ArrayList();
    MyList(List l) { myList = l; }
    @SuppressWarnings("unchecked")
    MyList getReversed() {
        ListIterator lit = myList.listIterator(myList.size());
        List reverseMyList = new ArrayList();
        while (lit.hasPrevious()) {
            reverseMyList.add(lit.previous());
        }
        return new MyList(reverseMyList);
    }
}

public class Ex25 {

    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        print(aList);
        print(aList.get(4));
        aList.add(new Integer(6));
        aList.addAll(new ArrayList<Integer>(Arrays.asList(7, 8)));
        print(aList);
        print(aList.subList(2, 4));
        MyList ml = new MyList(aList);
        print((ml.getReversed()).myList);
    }
}