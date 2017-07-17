package cn.feng.thinkInJava.a9_2_泛型.generics.a15_07_04.边界处的擦除.a15_07_05;
//: generics/SimpleHolder.java

public class SimpleHolder {

    private Object obj;
    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.set("Item");
        String s = (String) holder.get();
    }
    public void set(Object obj) { this.obj = obj; }
    public Object get() { return obj; }
} ///:~
