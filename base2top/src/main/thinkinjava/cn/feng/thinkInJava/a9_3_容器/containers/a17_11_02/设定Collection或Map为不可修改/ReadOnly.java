package cn.feng.thinkInJava.a9_3_容器.containers.a17_11_02.设定Collection或Map为不可修改;
//: containers/ReadOnly.java
// Using the Collections.unmodifiable methods.

import net.mindview.util.Countries;

import java.util.*;

import static net.mindview.util.Print.print;

/**
 * 设定Collection或Map为 不可修改
 *特定类型的“不可修改的”方法的调用并不会产生编译时的检查，但是转换完成后，任何会改变容器内容的操作都会引起UnsupportedOperationException异常。
 无论哪一种情况，在将容器设为只读之前，必须填入有意义的数据。装载数据后，就应该使用“不可修改的”方法返回的引用去替换掉原本的引用。这样，就不必担心无意中修改了只读的内容。另一方面，此方法允许你保留一份可修改的容器，作为类的private成员，然后通过某个方法调用返回该容器的“只读”的引用。这样一来，就只有你可以修改容器的内容，而别人只能读取。
 * @author fengyu
 * @date 2015年8月9日
 */
public class ReadOnly {

    static Collection<String> data = new ArrayList<String>(Countries.names(6));
    public static void main(String[] args) {
        //返回值是容器的只读版本
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<String>(data));
        print(c); // Reading is OK
        //! c.add("one"); // Can't change it

        List<String> a = Collections.unmodifiableList(new ArrayList<String>(data));
        ListIterator<String> lit = a.listIterator();
        print(lit.next()); // Reading is OK
        //! lit.add("one"); // Can't change it

        Set<String> s = Collections.unmodifiableSet(new HashSet<String>(data));
        print(s); // Reading is OK
        //! s.add("one"); // Can't change it

        // For a SortedSet:
        Set<String> ss = Collections.unmodifiableSortedSet(new TreeSet<String>(data));

        Map<String, String> m = Collections.unmodifiableMap(new HashMap<String, String>(Countries.capitals(6)));
        print(m); // Reading is OK
        //! m.put("Ralph", "Howdy!");

        // For a SortedMap:
        Map<String, String> sm = Collections.unmodifiableSortedMap(new TreeMap<String, String>(Countries.capitals(6)));
    }
} /* Output:
[ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO]
ALGERIA
[BULGARIA, BURKINA FASO, BOTSWANA, BENIN, ANGOLA, ALGERIA]
{BULGARIA=Sofia, BURKINA FASO=Ouagadougou, BOTSWANA=Gaberone, BENIN=Porto-Novo, ANGOLA=Luanda, ALGERIA=Algiers}
*///:~
