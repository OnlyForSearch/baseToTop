package cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_01.编译器有多聪明;

//: generics/CompilerIntelligence.java

import java.util.Arrays;
import java.util.List;
/**(协变就是子类型可以被当作基类型使用。

 如果实际数组类型是Apple[]，你应该只能在其中放置Apple或Apple的子类型，这在编译期和运行期都可以工作。编译器也允许放入Fruit类型但是运行时会抛出异常。与数组不同，泛型没有内建的协变类型。这是因为数组在语言中是完全定义的，因此可以内建了编译期和运行时的检查。
 查看ArrayList文档，add()方法接受泛型类型的参数，contains
 ()和indexOf()方法接受Object类型的参数。因此，当指定ArrayList<? extends Fruit>时，add()的参数就变成”? extends Fruit”。从这个描述中，编译器并不知道确切的类型，因此它不接受任何类型的Fruit。contains()和indexOf()
 方法参数类型是Object类型。不涉及任何通配符，编译器将允许这个调用。*/
public class CompilerIntelligence {

    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0); // No warning
        flist.contains(new Apple()); // Argument is 'Object'
        flist.indexOf(new Apple()); // Argument is 'Object'
    }
} /// :~

class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}
