package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_03_00.添加一组元素.b_11_03_01;

//: holding/AsListInference.java
// Arrays.asList() makes its best guess about type.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {}

class Powder extends Snow {}

class Light extends Powder {}

class Heavy extends Powder {}

class Crusty extends Snow {}

class Slush extends Snow {}

/**
 * 添加一组元素
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class AsListInference {

    public static void main(String[] args) {
        /**Arrays.asList()并没有限制它赋值的类型**/
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());

        // Won't compile:
        // List<Snow> snow2 = Arrays.asList(
        // new Light(), new Heavy());
        // Compiler says:
        // found : java.util.List<Powder>
        // required: java.util.List<Snow>

        // Collections.addAll() doesn't get confused:
        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy());

        // Give a hint using an
        // explicit type argument specification:
        /**Arrays.asList()并没有限制它赋值的类型,所以进行类型参数声明**/
        //显示类型声明Arrays.<Snow>asList
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
    }
} // /:~
