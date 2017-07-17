package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_02.泛化的class引用.a14_02_05;

//: typeinfo/FilledList.java

import java.util.ArrayList;
import java.util.List;

class CountedInteger {

    private static long counter;
    private final long id = counter++;

    public String toString() {
        return Long.toString(id);
    }
}

public class FilledList<T> {

    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }
    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
        System.out.println(fl.create(15));
    }
    public List<T> create(int nElements) {
        List<T> result = new ArrayList<T>();
        try {
            for (int i = 0; i < nElements; i++)
                //必须具有一个无参数的默认构造器
                //将泛型运用到Class对象,会发生一个有趣的事情,newInstance()将返回该对象的确切类型
                result.add(type.newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
} /* Output:
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
*///:~
