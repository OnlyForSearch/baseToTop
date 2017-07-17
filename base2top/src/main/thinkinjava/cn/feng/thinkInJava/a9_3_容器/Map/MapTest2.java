package cn.feng.thinkInJava.a9_3_容器.Map;

/*
需求：对学生对象的年龄进行升序排序。

因为数据是以键值对形式存在的。
所以要使用可以排序的Map集合。TreeMap。
*/

import java.util.*;

class StuNameComparator implements Comparator<Student1> {

    public int compare(Student1 s1, Student1 s2) {
        int num = s1.getName().compareTo(s2.getName());
        if (num == 0)
            return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));

        return num;
    }
}


class MapTest2 {

    public static void main(String[] args) {
        TreeMap<Student1, String> tm = new TreeMap<Student1, String>(new StuNameComparator());

        tm.put(new Student1("blisi3", 23), "nanjing");
        tm.put(new Student1("lisi1", 21), "beijing");
        tm.put(new Student1("alisi4", 24), "wuhan");
        tm.put(new Student1("lisi1", 21), "tianjin");
        tm.put(new Student1("lisi2", 22), "shanghai");


        Set<Map.Entry<Student1, String>> entrySet = tm.entrySet();

        Iterator<Map.Entry<Student1, String>> it = entrySet.iterator();

        while (it.hasNext()) {
            Map.Entry<Student1, String> me = it.next();

            Student1 stu = me.getKey();
            String addr = me.getValue();
            System.out.println(stu + ":::" + addr);
        }
    }
}
