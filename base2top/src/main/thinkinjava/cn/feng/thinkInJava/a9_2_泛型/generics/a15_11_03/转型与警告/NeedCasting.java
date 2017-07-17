package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_03.转型与警告;

//: generics/NeedCasting.java

import java.io.FileInputStream;
import java.io.ObjectInputStream;
/**有时候,泛型没有消除对转型的需要,这就会由编译器产生警告,而这个警告是不恰当的*/
public class NeedCasting {

    //	@SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
    }
} // /:~
