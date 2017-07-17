package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_05_00.List;

//: holding/ListFeatures.java

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.*;

import java.util.*;

import static net.mindview.util.Print.print;

/**
 * List承诺可以将元素维护在特定的序列中,
 * List特点:重要价值所在:一种可修改的序列
 * 需要注意:List的行为根据equals()行为不同而有所变化
 * <p>
 * 两种类型的List:
 * 基本的ArrayList,它长于随机访问,但是在List中间插入和移除元素时较慢
 * LinkedList:较低代价的插入和删除操作,,随机访问方面相对较慢,特性集比ArrayList更大
 */
public class ListFeatures {

    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = Pets.arrayList(7);
        print("1: " + pets);
        Hamster h = new Hamster();
        pets.add(h); // Automatically resizes 自动调整尺寸
        print("2: " + pets);
        print("3: " + pets.contains(h));
        pets.remove(h); // Remove by object 移除元素
        Pet p = pets.get(2);
        print("4: " + p + " " + pets.indexOf(p)); // 发现该对象的在List中的所处位置的索引号
        Pet cymric = new Cymric();
        print("5: " + pets.indexOf(cymric));// 返回-1表示未找到
        print("6: " + pets.remove(cymric));// 调用remove()尝试删除这个对象,不存在返回false
        // Must be the exact object:
        print("7: " + pets.remove(p));
        print("8: " + pets);
        pets.add(3, new Mouse()); // Insert at an index
        print("9: " + pets);
        List<Pet> sub = pets.subList(1, 4);// 允许你很容从较大的列表中创建出一个片段,产生的列表是背后是一个初始化列表,对返回列表的修改都会反映到初始化列表上,反之亦然
        print("subList: " + sub);
        print("10: " + pets.containsAll(sub));// 检测是否包含整个
        Collections.sort(sub); // In-place sort
        print("sorted subList: " + sub);
        // Order is not important in containsAll()://顺序不重要的在containsAll():
        print("11: " + pets.containsAll(sub));
        Collections.shuffle(sub, rand); // Mix it up
        print("shuffled subList: " + sub);
        print("12: " + pets.containsAll(sub));
        List<Pet> copy = new ArrayList<Pet>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        print("sub: " + sub);
        copy.retainAll(sub);// 取交集的操作
        print("13: " + copy);
        copy = new ArrayList<Pet>(pets); // Get a fresh copy
        copy.remove(2); // Remove by index
        print("14: " + copy);
        copy.removeAll(sub); // Only removes exact objects表示将从List中移除在参数列表中所有的元素,方法的行为基于equals()方法的
        print("15: " + copy);
        copy.set(1, new Mouse()); // Replace an element替换元素
        print("16: " + copy);
        copy.addAll(2, sub); // Insert a list in the middle在中间插入一个列表
        print("17: " + copy);
        print("18: " + pets.isEmpty());
        pets.clear(); // Remove all elements//移除所有元素
        print("19: " + pets);
        print("20: " + pets.isEmpty());
        pets.addAll(Pets.arrayList(4));
        print("21: " + pets);
        Object[] o = pets.toArray();//将任意的Collection转换为一个数组
        print("22: " + o[3]);
        Pet[] pa = pets.toArray(new Pet[0]);
        print("23: " + pa[3].id());
    }
} /*
 * Output: 1: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug] 2: [Rat, Manx, Cymric,
 * Mutt, Pug, Cymric, Pug, Hamster] 3: true 4: Cymric 2 5: -1 6: false 7: true
 * 8: [Rat, Manx, Mutt, Pug, Cymric, Pug] 9: [Rat, Manx, Mutt, Mouse, Pug,
 * Cymric, Pug] subList: [Manx, Mutt, Mouse] 10: true sorted subList: [Manx,
 * Mouse, Mutt] 11: true shuffled subList: [Mouse, Manx, Mutt] 12: true sub:
 * [Mouse, Pug] 13: [Mouse, Pug] 14: [Rat, Mouse, Mutt, Pug, Cymric, Pug] 15:
 * [Rat, Mutt, Cymric, Pug] 16: [Rat, Mouse, Cymric, Pug] 17: [Rat, Mouse,
 * Mouse, Pug, Cymric, Pug] 18: false 19: [] 20: true 21: [Manx, Cymric, Rat,
 * EgyptianMau] 22: EgyptianMau 23: 14
 */// :~
