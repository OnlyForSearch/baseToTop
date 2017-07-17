package cn.feng.thinkInJava.a9_3_容器.Map;

/*
每一个学生都有对应的归属地。
学生Student1，地址String。
学生属性：姓名，年龄。
注意：姓名和年龄相同的视为同一个学生。
保证学生的唯一性。



1，描述学生。

2，定义map容器。将学生作为键，地址作为值。存入。

3，获取map集合中的元素。

*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Student1 implements Comparable<Student1> {

    private String name;
    private int age;
    Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Student1 s) {
        int num = new Integer(this.age).compareTo(new Integer(s.age));

        if (num == 0)
            return this.name.compareTo(s.name);
        return num;
    }

    public int hashCode() {
        return name.hashCode() + age * 34;
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof Student1))
            throw new ClassCastException("类型不匹配");

        Student1 s = (Student1) obj;

        return this.name.equals(s.name) && this.age == s.age;


    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String toString() {
        return name + ":" + age;
    }
}


class MapTest {

    public static void main(String[] args) {
        HashMap<Student1, String> hm = new HashMap<Student1, String>();

        hm.put(new Student1("lisi1", 21), "beijing");
        hm.put(new Student1("lisi1", 21), "tianjin");
        hm.put(new Student1("lisi2", 22), "shanghai");
        hm.put(new Student1("lisi3", 23), "nanjing");
        hm.put(new Student1("lisi4", 24), "wuhan");

        //第一种取出方式 keySet

        Set<Student1> keySet = hm.keySet();

        Iterator<Student1> it = keySet.iterator();

        while (it.hasNext()) {
            Student1 stu = it.next();
            String addr = hm.get(stu);
            System.out.println(stu + ".." + addr);
        }


        //第二种取出方式 entrySet
        Set<Map.Entry<Student1, String>> entrySet = hm.entrySet();

        Iterator<Map.Entry<Student1, String>> iter = entrySet.iterator();

        while (iter.hasNext()) {
            Map.Entry<Student1, String> me = iter.next();
            Student1 stu = me.getKey();
            String addr = me.getValue();
            System.out.println(stu + "........." + addr);
        }
    }
}
