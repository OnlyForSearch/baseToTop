package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_06_03.从generator中创建数组.exercise;//arrays/Ex13.java
// TIJ4 Chapter Arrays, Exercise 13, page 774
// Fill a String using CountingGenerator.Character.

import net.mindview.util.CountingGenerator;

//用 CountingGenerator.Character.填充一个String
public class Ex13 {

    public static String fillString(int len) {
        CountingGenerator.Character cg = new CountingGenerator.Character();
        char[] ca = new char[len];
        for (int i = 0; i < len; i++)
            ca[i] = cg.next();
        return new String(ca);
    }
    public static void main(String[] args) {
        System.out.println(fillString(7));
        System.out.println(fillString(10));
    }
}