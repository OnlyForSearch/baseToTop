package cn.feng.thinkInJava.a9_3_容器.containers.a17_04_01.未获得支持的操作.exercise;// containers/Ex3.java
// TIJ4 Chapter Containers, Exercise 3, page 809
/* Using Countries, fill a Set multiple times with the same data 
* and verify that the Set ends up with only one of each instance.
* Try this with HashSet, LinkedHashSet, and TreeSet.
*/

import net.mindview.util.Countries;

import java.util.*;
import java.util.regex.Pattern;

import static cn.feng.utils.Print.println;

/**
 * 使用Countries,用同样的数据多次填充Set,然后验证此Set中没有重复
 * 的元素,使用HashSet, LinkedHashSet, and TreeSet.作此测试
 */
public class Ex3 {

    public static void main(String[] args) {
        Set<String> hs = new HashSet<String>();
        Set<String> lhs = new LinkedHashSet<String>();
        Set<String> ts = new TreeSet<String>();
        println("HashSet hs = " + hs);
        println("LinkedHashSet lhs = " + lhs);
        println("TreeSet ts = " + ts);
        Map<String, String> hm = new HashMap<String, String>(0);
        Pattern p = Pattern.compile("Z[a-zA-Z]*");
        for (int i = 0; i < Countries.DATA.length; i++) {
            if (p.matcher(Countries.DATA[i][0]).matches())
                hm.put(Countries.DATA[i][0], Countries.DATA[i][0]);
        }
        println("hm.keySet() = " + hm.keySet());
        println("Adding hm.keySet()");
        hs.addAll(hm.keySet());
        lhs.addAll(hm.keySet());
        ts.addAll(hm.keySet());
        println("hs: " + hs);
        println("lhs: " + lhs);
        println("ts: " + ts);
        println("Adding 10 more times");
        for (int i = 0; i < 10; i++) {
            hs.addAll(hm.keySet());
            lhs.addAll(hm.keySet());
            ts.addAll(hm.keySet());
        }
        println("hs: " + hs);
        println("lhs: " + lhs);
        println("ts: " + ts);
    }
}