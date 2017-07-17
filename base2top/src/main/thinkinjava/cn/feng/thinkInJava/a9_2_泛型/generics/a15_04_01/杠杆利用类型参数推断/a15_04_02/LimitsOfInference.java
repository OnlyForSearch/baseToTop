package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_01.杠杆利用类型参数推断.a15_04_02;

//: generics/LimitsOfInference.java

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Person;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;
/**
 * ava7的泛型类型推断改进
 在以前的版本中使用泛型类型，需要在声明并赋值的时候，两侧都加上泛型类型。例如：

 1



 Map<String, String> myMap = new HashMap<String, String>();

 在Java SE 7中，这种方式得以改进，现在你可以使用如下语句进行声明并赋值：

 1



 Map<String, String> myMap = new HashMap<>(); //注意后面的"<>"

 在这条语句中，编译器会根据变量声明时的泛型类型自动推断出实例化HashMap时的泛型类型。再次提醒一定要注意new HashMap后面的“<>”，只有加上这个“<>”才表示是自动类型推断，否则就是非泛型类型的HashMap，并且在使用编译器编译源代码时会给出一个警告提示。

 但是：Java SE 7在创建泛型实例时的类型推断是有限制的：只有构造器的参数化类型在上下文中被显著的声明了，才可以使用类型推断，否则不行。例如：下面的例子在java 7无法正确编译（但现在在java8里面可以编译，因为根据方法参数来自动推断泛型的类型）：

 1
 2
 3



 List<String> list = new ArrayList<>();
 list.add("A");// 由于addAll期望获得Collection<? extends String>类型的参数，因此下面的语句无法通过
 list.addAll(new ArrayList<>());
 *Java8的泛型类型推断改进
 java8里面泛型的目标类型推断主要2个：

 支持通过方法上下文推断泛型目标类型
 支持在方法调用链路当中，泛型类型推断传递到最后一个方法
 让我们看看官网的例子

 1
 2
 3
 4
 5



 class List<E> {
 static <Z> List<Z> nil() { ... };
 static <Z> List<Z> cons(Z head, List<Z> tail) { ... };
 E head() { ... }
 }

 根据JEP101的特性，我们在调用上面方法的时候可以这样写

 1
 2
 3
 4
 5
 6
 7
 8



 //通过方法赋值的目标参数来自动推断泛型的类型，这个不是新特性
 List<String> l = List.nil();
 //而不是显示的指定类型
 //List<String> l = List.<String>nil();
 //通过前面方法参数类型推断泛型的类型
 List.cons(42, List.nil());
 //而不是显示的指定类型
 //List.cons(42, List.<Integer>nil());
 * */
public class LimitsOfInference {

    //将一个泛型方法调用的结果作为参数的时候,传递个另外一个方法,这时候编译器并不会执行类型推断
    //编译器认为:调用泛型方法后,其返回值被赋给一个Object类型的变量
    static void f(Map<Person, List<? extends Pet>> petPeople) {
    }

    public static void main(String[] args) {
        // f(New.map()); // Does not compile
    }
} /// :~
