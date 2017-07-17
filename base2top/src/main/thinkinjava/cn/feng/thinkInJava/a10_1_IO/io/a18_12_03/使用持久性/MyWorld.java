package cn.feng.thinkInJava.a10_1_IO.io.a18_12_03.使用持久性;
//: io/MyWorld.java

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * 使用持久性
 *针对一个字节数组应用对象的序列化，从而实现对任何 Serializable（可序列化）对象的一
 * 个“全面复制”（全面复制意味着复制的是整个对象网，而不仅是基本对象和它的句柄）。

 只要将所有东西都序列化到单独一个数据流里，就能恢复获得与以前写入时完全一样的对象
 网，不会不慎造成对象的重复（实际两个引用都是指向同一个对象，但是如果分开写入不同
 的流，恢复时，会重复恢复出不同的对象）。

 如果想保存系统状态，最安全的做法是当作一种“原子”操作序列化。应将构成系统状态的所
 有对象都置入单个容器内，并在一次操作里完成那个容器的写入。这样一来，同样只需一次方法调用，即可成功恢复之。


 如将一个 static 字段置入基础类，结果只会产生一个字段，因为 static 字段未在衍生类
 中复制。假如想序列化 static 值，必须亲自动手。
 * @author fengyu
 * @date 2015年8月9日
 */
class House implements Serializable {}

class Animal implements Serializable {

    private String name;
    private House preferredHouse;
    Animal(String nm, House h) {
        name = nm;
        preferredHouse = h;
    }
    public String toString() {
        return name + "[" + super.toString() +
                "], " + preferredHouse + "\n";
    }
}

public class MyWorld {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("Bosco the dog", house));
        animals.add(new Animal("Ralph the hamster", house));
        animals.add(new Animal("Molly the cat", house));
        print("animals: " + animals);
        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream o1 = new ObjectOutputStream(buf1);
        o1.writeObject(animals);
        o1.writeObject(animals); // Write a 2nd set
        // Write to a different stream:
        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream o2 = new ObjectOutputStream(buf2);
        o2.writeObject(animals);
        // Now get them back:
        ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
        List animals1 = (List) in1.readObject(),
                animals2 = (List) in1.readObject(),
                animals3 = (List) in2.readObject();
        print("animals1: " + animals1);
        print("animals2: " + animals2);
        print("animals3: " + animals3);
    }
} /* Output: (Sample)
animals: [Bosco the dog[Animal@addbf1], House@42e816
, Ralph the hamster[Animal@9304b1], House@42e816
, Molly the cat[Animal@190d11], House@42e816
]
animals1: [Bosco the dog[Animal@de6f34], House@156ee8e
, Ralph the hamster[Animal@47b480], House@156ee8e
, Molly the cat[Animal@19b49e6], House@156ee8e
]
animals2: [Bosco the dog[Animal@de6f34], House@156ee8e
, Ralph the hamster[Animal@47b480], House@156ee8e
, Molly the cat[Animal@19b49e6], House@156ee8e
]
animals3: [Bosco the dog[Animal@10d448], House@e0e1c6
, Ralph the hamster[Animal@6ca1c], House@e0e1c6
, Molly the cat[Animal@1bf216a], House@e0e1c6
]
*///:~
