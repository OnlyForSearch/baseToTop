package cn.feng.thinkInJava.a9_2_泛型.generics.a15_07_04.边界处的擦除.a15_07_05;
//: generics/GenericHolder.java

public class GenericHolder<T> {

    private T obj;
    public static void main(String[] args) {
        GenericHolder<String> holder = new GenericHolder<String>();
        holder.set("Item");
        String s = holder.get();
    }
    public void set(T obj) { this.obj = obj; }
    public T get() { return obj; }
} ///:~
