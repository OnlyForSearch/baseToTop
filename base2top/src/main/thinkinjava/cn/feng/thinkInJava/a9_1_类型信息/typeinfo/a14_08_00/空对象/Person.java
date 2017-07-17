package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_08_00.空对象;

//: typeinfo/Person.java
// A class with a Null Object.

import net.mindview.util.Null;

/**
 * 空对象
 *通过空对象，你可以假设所有的对象都是有效的，而不必浪费编程精力去检查null。到处使用空对象没有任何意义—有时检查null就可以了，有时可以合理假设不会遇到null，有时探测NullPointerException异常也可以。空对象最有用的地方在于它更靠近数据，因为对象表示的是问题空间内的实体。
 * @author fengyu
 * @date 2015年8月9日
 */
class Person {
    //通常都是单例的,因此这里将其作为静态final实例创建
    public static final Person NULL = new NullPerson();
    public final String first;
    public final String last;
    public final String address;

    // etc.
    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }
    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }

    public static class NullPerson extends Person implements Null {

        private NullPerson() {
            super("None", "None", "None");
        }

        public String toString() {
            return "NullPerson";
        }
    }
} // /:~
