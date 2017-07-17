package cn.feng.thinkInJava.a9_3_容器;

import org.junit.Test;

import java.util.*;

import static cn.feng.utils.Print.println;
import static net.mindview.util.Print.print;

/**
 * 一个独立元素的序列,这些元素都服从一条或者多条的规则,List必须按照插入顺序保存元素,Set不能有重复元素,
 * Queue按照排队规则来确定对象产生顺序 Collection接口概括了序列的概念
 */

/**
 * @author Administrator
 */
public class CollectionDemo {

    /**
     * 添加一组元素
     */
    @Test
    public void addingGroups() {

        /***********************************************/
        // Arrays.asList()接受数组或者可变参数列表,将其变成变成一个List对象
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] integers = {7, 8, 9,};
        // 数组使用Arrays.toString()打印,容器打印无需任何帮组
        println(Arrays.toString(integers));
        collection.addAll(Arrays.asList(integers));
        // Collections.addAll()接受一个Collection对象,数组,可变参数
        Collections.addAll(collection, 11, 12, 13);
        Collections.addAll(collection, integers);
        /***********************************************/
        // Arrays.asList()底层是数组因此不能调整尺寸,所以不能使用add()或者delete()方法
        List<Integer> list = Arrays.asList(15, 16, 17);
        list.set(1, 19);

        // list.add(21);发生java.lang.UnsupportedOperationException

    }

    /* List容器方法展示 */
    @Test
    public void listDemo() {
        ListDemo.listDemo();
    }

    /* Set容器方法展示 */
    @Test
    public void setDemo() {
        SetDemo.setDemo();
    }

    /* map容器方法展示 */
    @Test
    public void mapDemo() {
        //	MapDemo.HashMapDemo.statistics();
        MapDemo.HashMapDemo.mapOfList();
    }

}

/**
 * 按照输入顺序保存元素
 */
class ListDemo {

    public static void listDemo() {

        Random rand = new Random(47);
        List<String> pets = new ArrayList<>();
        pets.add("a");
        pets.add("b");
        pets.add("c");
        pets.add("d");
        pets.add("e");
        pets.add("f");

        println("1: " + pets.toString());
        String h = "h";
        pets.add(h);// 添加一个对象
        println("2: " + pets);
        println("3: " + pets.contains(h));// 确定某个对象是否在列表中
        pets.remove(h); // 移除一个对象
        String p = pets.get(2);
        println("4: " + p + " " + pets.indexOf(p));// 发现该对象在List中所处位置的索引编号,用equals()方法比较,未找到返回结果-1
        String cymric = new String("h");
        println("5: " + pets.indexOf(cymric));
        println("6: " + pets.remove(cymric));
        println("7: " + pets.remove(p));// 删除不存在的对象返回false
        println("8: " + pets);
        pets.add(3, new String());
        println("9: " + pets);
        List<String> sub = pets.subList(1, 4);// 从较大的列表中创建出一个片断,方法产生的列表的幕后就是初始化列表,对返回的列表经行修改都会反映在初始表中,反之亦然.
        println("subList: " + sub);
        println("10: " + pets.containsAll(sub));
        Collections.sort(sub); // In-place sort
        println("sorted subList: " + sub);
        // Order is not important in containsAll():
        println("11: " + pets.containsAll(sub));
        Collections.shuffle(sub, rand); // Mix it up
        println("shuffled subList: " + sub);
        println("12: " + pets.containsAll(sub));
        List<String> copy = new ArrayList<String>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        println("sub: " + sub);
        copy.retainAll(sub);// 取交集,产生的行为依赖equals()
        println("13: " + copy);
        copy = new ArrayList<String>(pets); // Get a fresh copy
        copy.remove(2); // Remove by index
        println("14: " + copy);
        copy.removeAll(sub); // 从copy中移除所有sub中的元素,产生的行为依赖equals()
        println("15: " + copy);
        copy.set(1, new String()); // Replace an element
        println("16: " + copy);
        copy.addAll(2, sub); // Insert a list in the middle
        println("17: " + copy);
        println("18: " + pets.isEmpty());
        pets.clear(); // Remove all elements
        println("19: " + pets);
        println("20: " + pets.isEmpty());
        pets.addAll(pets);
        println("21: " + pets);
        Object[] o = pets.toArray();
        // println("22: " + o[o.length-1]);

    }

    /* 长于随机访问元素,但是在List中间插入和移除元素时候较慢 */
    class ArrayLitDemo {

    }

    /* 较低代价的List中间进行插入和删除操作,随机访问方面较慢 */
    class LinkedListDemo {}
}

/**
 * 每个相同的项只保存一次,Set具有与Collection完全一样的接口没有任何额外的接口,实际上Set就是Collection,只是行为不同
 */
class SetDemo {

    public static void setDemo() {
        Set<String> set1 = new HashSet<String>();
        Collections.addAll(set1, "A B C D E F G H I J K L".split(" "));
        set1.add("M");
        print("H: " + set1.contains("H"));
        print("N: " + set1.contains("N"));
        Set<String> set2 = new HashSet<String>();
        Collections.addAll(set2, "H I J K L".split(" "));
        print("set2 in set1: " + set1.containsAll(set2));
        set1.remove("H");
        print("set1: " + set1);
        print("set2 in set1: " + set1.containsAll(set2));
        set1.removeAll(set2);
        print("set2 removed from set1: " + set1);
        Collections.addAll(set1, "X Y Z".split(" "));
        print("'X Y Z' added to set1: " + set1);
    }

    /**
     * 最快的获取元素的方式
     */
    class HashSetDemo {}

    /* 储存顺序很重要的时候时候用,按照比较结果升序保存 */
    class TreeSetDemo {}

    /* 按照添加的顺序保存元素 */
    class LinkedHashSetDemo {}
}

/**
 * Map也叫关联数组,Map自动调整尺寸 一组键值对对象,允许使用键来查找对象
 */
class MapDemo {

    /* 提供了最快的查找技术 */
    static class HashMapDemo {

        public static void statistics() {
            Random random = new Random(47);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i <= 1_000; i++) {
                /*自动包装机制自动转换*/
                Integer integer = random.nextInt(20);
                Integer count = map.get(integer);
                map.put(integer, count == null ? 0 : ++count);
            }
            println(map);
        }

        /**
         * Map与数组和的Collection一样可以扩张到多维的
         */
        public static void mapOfList() {
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            map.put("key1", Arrays.asList("value11", "value12"));
            map.put("key2", Arrays.asList("value21", "value22", "value23"));
            map.put("key3", Arrays.asList("value31"));
            map.put("key4", Arrays.asList("value41", "value42"));
            map.put("key5", Arrays.asList("value51", "value52", "value53"));
            println("keySet:" + map.keySet());
            println("values" + map.values());
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                println(key + "has:");
                for (String value : map.get(key)) {
                    print("  " + value);
                }
                println("");
            }

        }
    }

    /* 按照比较结果升序保存键 */
    class TreeMapDemo {}

    /* 按照插入顺序保存键,同时还保留了HashMap的查询速度 */
    class LinkedHashMapDemo {}

}