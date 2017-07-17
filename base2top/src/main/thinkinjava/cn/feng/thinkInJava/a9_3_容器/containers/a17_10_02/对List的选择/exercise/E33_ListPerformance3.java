package cn.feng.thinkInJava.a9_3_容器.containers.a17_10_02.对List的选择.exercise;

//: containers/E33_ListPerformance3.java
// {RunByHand} (Takes too long during the build process)
/**
 * ***************** Exercise 33 ************************
 * Create a FastTraversalLinkedList that internally uses a
 * LinkedList for rapid insertions and removals, and an
 * ArrayList for rapid traversals and get() operations.
 * Test it by modifying ListPerformance.java.
 * *******************************************************
 */
/**
 * 创建一个FastTraversalLinkedList,为了快速插入与移除,他的内部使用一个LinkedList,
 * 而为了快速遍历和get()操作,则使用了一个ArrayList,通过修改ListPerformance来测试它
 * */
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.Test;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.TestParam;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.Tester;
import net.mindview.util.CountingIntegerList;

import java.util.*;

class FastTraversalLinkedList<T> extends AbstractList<T> {

    private class FlaggedArrayList {

        private FlaggedLinkedList companion;
        boolean changed = false;
        private ArrayList<T> list = new ArrayList<T>();
        public void addCompanion(FlaggedLinkedList other) {
            companion = other;
        }
        private void synchronize() {
            if (companion.changed) {
                list = new ArrayList<T>(companion.list);
                companion.changed = false;
            }
        }
        public T get(int index) {
            synchronize();
            return list.get(index);
        }
        public int size() {
            synchronize();
            return list.size();
        }
        public T remove(int index) {
            synchronize();
            changed = true;
            return list.remove(index);
        }
        public boolean remove(Object item) {
            synchronize();
            changed = true;
            return list.remove(item);
        }
        // Always broadcasted to the companion container, too.
        public void clear() {
            list.clear();
            changed = false;
        }
    }

    private class FlaggedLinkedList {

        private FlaggedArrayList companion;
        boolean changed = false;
        LinkedList<T> list = new LinkedList<T>();
        public void addCompanion(FlaggedArrayList other) {
            companion = other;
        }
        private void synchronize() {
            if (companion.changed) {
                list = new LinkedList<T>(companion.list);
                companion.changed = false;
            }
        }
        public void add(int index, T item) {
            synchronize();
            changed = true;
            list.add(index, item);
        }
        public boolean add(T item) {
            synchronize();
            changed = true;
            return list.add(item);
        }
        public Iterator<T> iterator() {
            synchronize();
            return list.iterator();
        }
        // Always broadcasted to the companion container, too.
        public void clear() {
            list.clear();
            changed = false;
        }
    }

    private FlaggedArrayList aList = new FlaggedArrayList();
    private FlaggedLinkedList lList = new FlaggedLinkedList();

    // Connect the two so they can synchronize:
    {
        aList.addCompanion(lList);
        lList.addCompanion(aList);
    }

    public int size() { return aList.size(); }
    public T get(int arg) { return aList.get(arg); }
    public void add(int index, T item) {
        lList.add(index, item);
    }
    public boolean add(T item) {
        return lList.add(item);
    }
    // Through testing, we discovered that the ArrayList is
    // actually much faster for removals than the LinkedList:
    public T remove(int index) {
        return aList.remove(index);
    }
    public boolean remove(Object item) {
        return aList.remove(item);
    }
    public Iterator<T> iterator() {
        return lList.iterator();
    }
    public void clear() {
        aList.clear();
        lList.clear();
    }
}

public class E33_ListPerformance3 {

    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();

    static {
        tests.add(new Test<List<Integer>>("iter") {
            public int test(List<Integer> list, TestParam tp) {
                for (int i = 0; i < tp.loops; i++) {
                    Iterator<Integer> it = list.iterator();
                    while (it.hasNext())
                        it.next(); // Produces value
                }
                return tp.loops;
            }
        });
        tests.add(new Test<List<Integer>>("get") {
            public int
            test(List<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.get(rand.nextInt(listSize));
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("insert") {
            public int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                for (int i = 0; i < loops; i++)
                    list.add(5, 47); // Minimize random-access cost
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("remove_I ") {
            public int test(List<Integer> list, TestParam tp) {
                int count = 0;
                for (int i = list.size() / 2; i < list.size(); i++) {
                    ++count;
                    list.remove(i);
                }
                return count;
            }
        });
        tests.add(new Test<List<Integer>>("remove_O") {
            public int test(List<Integer> list, TestParam tp) {
                int count = 0;
                for (int i = list.size() / 2; i < list.size(); i++) {
                    ++count;
                    list.remove(list.get(i));
                }
                return count;
            }
        });
    }

    static class ListTester extends Tester<List<Integer>> {

        public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
            super(container, tests);
        }
        // Fill to the appropriate size before each test:
        @Override
        protected List<Integer> initialize(int size) {
            container.clear();
            container.addAll(new CountingIntegerList(size));
            return container;
        }
        // Convenience method:
        public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }
    public static void main(String[] args) {
        ListTester.run(new ArrayList<Integer>(), tests);
        ListTester.run(new LinkedList<Integer>(), tests);
        ListTester.run(new FastTraversalLinkedList<Integer>(), tests);
    }
} ///:~
/**
 * When you perform an operation on either FlaggedArrayList or
 FlaggedLinkedList, it checks for changes in the other and self-updates, setting
 or clearing both lists’ changed flags. You can see the two lists connected in the
 instance initialization clause.
 We implement only the methods used in the tests in FlaggedArrayList and
 FlaggedLinkedList. The FastTraversalLinkedList forwards method calls
 to the most efficient list.
 The insertion and removal tests don’t use the iterator (which would confound
 the results). Also, we distinguish “remove at location” as ‘remove_I’ and “remove
 by object” as ‘remove_O’. The results of one run are as follows:
 ----------------- ArrayList -----------------
 size iter get insertremove_I remove_O
 10 1302 106 4231 12329 16513
 100 4104 96 3701 1005 47717
 1000 33924 95 4846 1108 9171
 10000 339132 92 14295 4124 85110
 ----------------- LinkedList -----------------
 size iter get insertremove_I remove_O
 10 1104 125 676 118204 120866
 100 2489 165 68 783 34911
 1000 24384 769 69 1071 10800
 10000 245605 13097 87 14333 98771
 ---------- FastTraversalLinkedList ----------
 size iter get insertremove_I remove_O
 10 512 108 235 26553 20298
 100 2491 108 195 1553 2008
 1000 24158 107 80 1292 12888
 10000 243113 103 97 4062 94922
 Surprisingly, removing an element in the middle of an ArrayList turns out to be
 far less damaging than removing one from the middle of a LinkedList.
 Iteration is somewhat better in LinkedList, which is noticeably faster only with
 insertions.
 FastTraversalLinkedList’s repeated insertion and removal entails list
 copying which can negatively affect overhead.
 * */