package cn.feng.thinkInJava.a9_3_容器.containers.a17_04_01.未获得支持的操作.exercise;// containers/Ex2.java
// TIJ4 Chapter Containers, Exercise 2, page 809
// Produce a Map and a Set containing all the countries that begin
// with 'A'.

import net.mindview.util.Countries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import static cn.feng.utils.Print.println;

/**
 * 生成一个Map和Set,使其包含所有以字母A开头的国家
 */
public class Ex2 {

    public static void main(String[] args) {
        Map<String, String> hm = new HashMap<String, String>();
        Set<String> hs = hm.keySet();
        Pattern p = Pattern.compile("A[a-zA-Z]*");
        for (int i = 0; i < Countries.DATA.length; i++) {
            if (p.matcher(Countries.DATA[i][0]).matches())
                hm.put(Countries.DATA[i][0], Countries.DATA[i][1]);
        }
        println(hm);
        println(hs);
    }
}