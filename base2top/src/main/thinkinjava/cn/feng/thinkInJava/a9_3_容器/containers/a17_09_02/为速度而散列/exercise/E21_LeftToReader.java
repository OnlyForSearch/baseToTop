package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_02.为速度而散列.exercise;

//: containers/E21_LeftToReader.java

/**
 * *************** Exercise 21 *****************
 * Modify SimpleHashMap so that it reports the

 * number of "probes" necessary when collisions
 * occur. That is, how many calls to next() must
 * be made on the Iterators that walk the
 * LinkedLists looking for matches?
 * *********************************************
 *//**
 * 修改SimpleHashMap,令其报告要探询多少次才能发现冲突,也就是
 * */

public class E21_LeftToReader {

    public static void main(String args[]) {
        System.out.println("Exercise left to reader");
    }
} ///:~
//Hint:Modify the get()method the same way as put()in Exercise 20.