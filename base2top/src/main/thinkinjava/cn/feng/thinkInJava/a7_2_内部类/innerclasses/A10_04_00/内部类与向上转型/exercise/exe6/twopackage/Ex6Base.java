package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_04_00.内部类与向上转型.exercise.exe6.twopackage;

import cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_04_00.内部类与向上转型.exercise.exe6.Ex6Interface;
/**
 * 在第一个包中创建一个至少有一个方法的接口,然后在第二包中创建一个类.在其中
 * 添加一个protected的内部类以实现那个接口.在第三个包中,继承这个类,并在一个方法中返回该protected内部类的对象,在返回的时候向上转型为第一个包中的接口的类型
 * ***********
 */
/**
 * Created by Administrator on 2015/11/22.
 */ // and in a second package:
public class Ex6Base {

    protected class Ex6BaseInner implements Ex6Interface {

        // need public constructor to create one in Ex6Base child:
        public Ex6BaseInner() { }
        public String say() { return "Hi"; }
    }
}
