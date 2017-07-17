package cn.feng.thinkInJava.a9_2_泛型.generics.a15_08_01.创建类型的实例;
//: generics/InstantiateGenericType.java

import static net.mindview.util.Print.print;
/**代码可以编译,但是会因为 ClassAsFactory<Integer>失败,因为Integer没有任何默认的构造器.
 * 因为这个构造器不会再编译期被捕获,
 * */
class ClassAsFactory<T> {

    T x;

    /**
     * 解决方案,传递一个工厂对象,并使用它来创建新的实例,最便利的工厂对象就是class对象,因此如果使用
     * 类型标签,就么就可以使用newInstance()来创建这个类型的新对象,
     *
     * @param kind
     * @author fengyu
     * @date 2015年8月12日
     */
    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {}

public class InstantiateGenericType {

    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
        print("ClassAsFactory<Employee> succeeded");
        try {
            //这个会编译失败,因为Integer没有任何默认的构造器,因为这个错误在编译期捕获的,
            ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
        } catch (Exception e) {
            print("ClassAsFactory<Integer> failed");
        }
    }
} /* Output:
ClassAsFactory<Employee> succeeded
ClassAsFactory<Integer> failed
*///:~
