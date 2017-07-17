package cn.feng.thinkInJava.a9_2_泛型.generics.a15_08_00.擦除的补偿;
//: generics/ClassTypeCapture.java

class Building {}

class House extends Building {}
/**Java泛型在instanceof、创建类型实例，创建数组、转型时都会有问题。有时必须通过引入类型标签（即你的类型的Class对象）进行补偿。使用动态的isInstance()方法，而不是instanceof。
 * */
public class ClassTypeCapture<T> {

    Class<T> kind;
    //引入类型标签,就可以转而使用动态的isInstance,编译器将确保类型标签可以匹配泛型参数
    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }
    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }
} /* Output:
true
true
false
true
*///:~
