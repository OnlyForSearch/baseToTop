package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_06_00.迭代器.b_11_06_01;

//: holding/CrossContainerIteration.java

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pets;

import java.util.*;

/**
 * 迭代器展示
 */
public class CrossContainerIteration {

    /**
     * 这个展示Iterator的真正威力:能够将遍历序列的操作与底层结构分离-->迭代器统一了对容器的访问方式
     */
    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Pet> pets = Pets.arrayList(8);
        LinkedList<Pet> petsLL = new LinkedList<Pet>(pets);
        HashSet<Pet> petsHS = new HashSet<Pet>(pets);
        TreeSet<Pet> petsTS = new TreeSet<Pet>(pets);
        display(pets.iterator());
        display(petsLL.iterator());
        display(petsHS.iterator());
        display(petsTS.iterator());
    }
} /*
 * Output: 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 0:Rat 1:Manx
 * 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 4:Pug 6:Pug 3:Mutt 1:Manx
 * 5:Cymric 7:Manx 2:Cymric 0:Rat 5:Cymric 2:Cymric 7:Manx 1:Manx 3:Mutt 6:Pug
 * 4:Pug 0:Rat
 */// :~
