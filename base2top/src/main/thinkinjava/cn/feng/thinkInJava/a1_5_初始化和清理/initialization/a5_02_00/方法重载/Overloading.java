package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_02_00.方法重载;

//: initialization/Overloading.java
// Demonstration of both constructor
// and ordinary method overloading.

import static net.mindview.util.Print.print;

class Tree {

    int height;

    Tree() {
        print("Planting a seedling");
        height = 0;
    }

    Tree(int initialHeight) {
        height = initialHeight;
        print("Creating new Tree that is " + height + " feet tall");
    }

    void info() {
        print("Tree is " + height + " feet tall");
    }

    void info(String s) {
        print(s + ": Tree is " + height + " feet tall");
    }
}

/**
 * 方法重载
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Overloading {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("overloaded method");
        }
        // Overloaded constructor:构造器重载
        new Tree();
    }
} /* Output:
Creating new Tree that is 0 feet tall
Tree is 0 feet tall
overloaded method: Tree is 0 feet tall
Creating new Tree that is 1 feet tall
Tree is 1 feet tall
overloaded method: Tree is 1 feet tall
Creating new Tree that is 2 feet tall
Tree is 2 feet tall
overloaded method: Tree is 2 feet tall
Creating new Tree that is 3 feet tall
Tree is 3 feet tall
overloaded method: Tree is 3 feet tall
Creating new Tree that is 4 feet tall
Tree is 4 feet tall
overloaded method: Tree is 4 feet tall
Planting a seedling
*///:~
