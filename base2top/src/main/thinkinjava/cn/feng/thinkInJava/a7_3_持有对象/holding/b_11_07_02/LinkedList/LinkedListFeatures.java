package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_07_02.LinkedList;
//: holding/LinkedListFeatures.java

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Hamster;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pets;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Rat;

import java.util.LinkedList;

import static net.mindview.util.Print.print;

/**
 * 在List的中间插入和删除比ArrayList更高效,但是随机访问操作方面却要逊色
 */
public class LinkedListFeatures {

    public static void main(String[] args) {
        //将List集合交给构造器,以便使用它来组装LinkedList
        LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
        print(pets);
        // Identical:完全相同的事物,都返回列表的第一个元素,并不移除它,如果List为空则抛出NoSuchElementException
        print("pets.getFirst(): " + pets.getFirst());
        print("pets.element(): " + pets.element());
        // Only differs in empty-list behavior:唯一不同的空列表的行为
        print("pets.peek(): " + pets.peek());// 完全相同的事物,都返回列表的第一个元素,并不移除它,如果List为空则返回null
        // Identical; remove and return the first
        // element:返回列表的第一个元素,并移除它,如果List为空则抛出NoSuchElementException
        print("pets.remove(): " + pets.remove());
        print("pets.removeFirst(): " + pets.removeFirst());
        // Only differs in empty-list behavior:
        print("pets.poll(): " + pets.poll());// 全相同的事物,都返回列表的第一个元素,并移除它,如果List为空则返回null
        print(pets);
        pets.addFirst(new Rat());// 将某个元素插入到列表的头部
        print("After addFirst(): " + pets);
        pets.offer(Pets.randomPet());
        print("After offer(): " + pets);
        pets.add(Pets.randomPet());// 将某个元素插入到列表的尾部
        print("After add(): " + pets);
        pets.addLast(new Hamster());// 将某个元素插入到列表的尾部
        print("After addLast(): " + pets);
        print("pets.removeLast(): " + pets.removeLast());// 移除并返回列表的最后一个元素
    }
} /* Output:
[Rat, Manx, Cymric, Mutt, Pug]
pets.getFirst(): Rat
pets.element(): Rat
pets.peek(): Rat
pets.remove(): Rat
pets.removeFirst(): Manx
pets.poll(): Cymric
[Mutt, Pug]
After addFirst(): [Rat, Mutt, Pug]
After offer(): [Rat, Mutt, Pug, Cymric]
After add(): [Rat, Mutt, Pug, Cymric, Pug]
After addLast(): [Rat, Mutt, Pug, Cymric, Pug, Hamster]
pets.removeLast(): Hamster
*///:~
