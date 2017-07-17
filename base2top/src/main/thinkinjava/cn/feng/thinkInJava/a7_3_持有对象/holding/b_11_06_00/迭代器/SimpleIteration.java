package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_06_00.迭代器;

//: holding/SimpleIteration.java

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pets;

import java.util.Iterator;
import java.util.List;

/**
 * 迭代器展示:一种设计模式，在不知道或不关心序列底层结构的情况下，遍历序列，选择每一个元素。迭代器是一种轻量级对象：创建代价低。
 * Java的Iterator只能单向移动，用法：
 * <p>
 * 1使用iterator()方法返回Collection的迭代器；迭代器准备返回序列的第一个元素；
 * 2使用next()方法获取下一个元素；
 * 注意：iterator()返回的迭代器是”准备返回序列的第一个元素”，而不是已经指向了第一个元素，因此要获取第一个元素也得调用一次next()，即c.iterator().next()得到的是第一个元素。
 * 3 hasNext()方法检验序列是否还有元素；
 * 4使用remove()方法删除迭代器返回的最后一个元素。注意，remove()是一种可选方法，依赖于具体实现，但Java标准容器类库都实现了这个方法。
 * <p>
 * 当仅仅是遍历并获取每个元素，用foreach语法更简练。调用remove()之前必须调用next()方法。注意ConcurrentModificationException异常（所谓的fail-fast iterator）。
 * <p>
 * 迭代器的威力：将遍历序列的操作与序列的底层结构分离，统一了对容器的访问方式。
 */
public class SimpleIteration {

    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(12);

        // java 的Iterator只能单向移动
        Iterator<Pet> it = pets.iterator();// iterator();返回一个Iterator
        while (it.hasNext()) {// 检查序列中是否还有元素
            Pet p = it.next();// 获取序列的下个元素
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
        // A simpler approach, when
        // possible:如果只是向前遍历List,并不打算修改List对象本身,可以使用foreach语法,会显得更加简洁
        for (Pet p : pets)
            System.out.print(p.id() + ":" + p + " ");
        System.out.println();
        // An Iterator can also remove elements:
        it = pets.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove();// 将迭代器新近返回的元素删除
        }
        System.out.println(pets);
    }
} /*
 * Output: 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 8:Cymric
 * 9:Rat 10:EgyptianMau 11:Hamster 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric
 * 6:Pug 7:Manx 8:Cymric 9:Rat 10:EgyptianMau 11:Hamster [Pug, Manx, Cymric,
 * Rat, EgyptianMau, Hamster]
 */// :~
