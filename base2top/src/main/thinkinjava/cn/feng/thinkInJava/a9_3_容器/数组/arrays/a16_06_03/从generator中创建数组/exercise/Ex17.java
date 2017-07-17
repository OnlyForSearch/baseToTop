package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_06_03.从generator中创建数组.exercise;// arrays/Ex17.java
// TIJ4 Chapter Arrays, Exercise 17, page 775
// Create and test a Generator for BigDecimal, and ensure 
// that it works with the Generated methods.
//创建并测试用于 BigDecimal, 的Generator,以确保它可以用于 Generated 中的方法

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.math.BigDecimal;
import java.util.Arrays;

class BigDecimalGenerator implements Generator<BigDecimal> {

    private BigDecimal bd = new BigDecimal(0.0);
    public BigDecimal next() {
        return bd = bd.add(new BigDecimal(1.0));
    }
}

public class Ex17 {

    public static void main(String[] args) {
        BigDecimal[] bda1 = new BigDecimal[4];
        Generated.array(bda1, new BigDecimalGenerator());
        System.out.println(Arrays.toString(bda1));
        BigDecimal[] bda2 = Generated.array(BigDecimal.class, new BigDecimalGenerator(), 5);
        System.out.println(Arrays.toString(bda2));
    }
}