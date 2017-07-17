package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_02.泛化的class引用.a14_02_03;

//: typeinfo/WildcardClassReferences.java
public class WildcardClassReferences {

    public static void main(String[] args) {
        // 使用通配符?放松限制,在使用泛化的Class引用,Class<?>优于平凡的Class,即便它们是等价的
        // 并且平凡的Class不会产生编译器警告信息.
        //Class<?> 的好处是它表示你并非碰巧或者由于疏忽,而使用了非具体的类引用,你就是选择了非具体的版本
        Class<?> intClass = int.class;
        intClass = double.class;
    }
} // /:~
