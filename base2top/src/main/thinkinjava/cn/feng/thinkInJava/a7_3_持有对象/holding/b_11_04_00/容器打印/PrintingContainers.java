package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_04_00.容器打印;

//: holding/PrintingContainers.java
// Containers print themselves automatically.

import java.util.*;

import static net.mindview.util.Print.print;

/**
 * 打印容器:可以直接打印容器
 * 打印数组:需要借助Arrays.toString()
 *
 * @author fengyu
 * @date 2015年8月8日
 */

/**
 * 展示java容器类库的主要类型
 */
public class PrintingContainers {

    /**
     * 作用与所有的Collection类型
     */
    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    public static void main(String[] args) {
        print(fill(new ArrayList<String>()));//
        print(fill(new LinkedList<String>()));//LinkedList的操作多于ArrayList
        print(fill(new HashSet<String>()));//最快的获取获取元素方式
        print(fill(new TreeSet<String>()));//按照比较结果升序保存队形
        print(fill(new LinkedHashSet<String>()));//按照添加顺序保存对象
        print(fill(new HashMap<String, String>()));//最快的查找技术
        print(fill(new TreeMap<String, String>()));//按照比较结果升序保存键
        print(fill(new LinkedHashMap<String, String>()));//按照插入顺序保存键,保留HashMap的查询速度
    }
} /*
 * Output: [rat, cat, dog, dog] [rat, cat, dog, dog] [dog, cat, rat] [cat, dog,
 * rat] [rat, cat, dog] {dog=Spot, cat=Rags, rat=Fuzzy} {cat=Rags, dog=Spot,
 * rat=Fuzzy} {rat=Fuzzy, cat=Rags, dog=Spot}
 */// :~
