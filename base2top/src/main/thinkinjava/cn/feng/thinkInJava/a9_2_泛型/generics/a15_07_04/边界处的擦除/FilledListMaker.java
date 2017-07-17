package cn.feng.thinkInJava.a9_2_泛型.generics.a15_07_04.边界处的擦除;//: generics/FilledListMaker.java
import java.util.*;
/**上面代码实现了非泛型和泛型版本的相似的两个类通过javap -c 命令反编译可以发现字节码是相同的，就是说在运行时使用泛型的代码和普通代码没有什么区别。泛型中的所有动作都发生在边界处—对传递进来的值进行额外的编译期检查，并插入对传递出去的值的转型。这有助于澄清对擦除的混淆，记住，“边界就是发生动作的地方”。*/
public class FilledListMaker<T> {
  List<T> create(T t, int n) {
    List<T> result = new ArrayList<T>();
    for(int i = 0; i < n; i++)
      result.add(t);
    return result;
  }
  public static void main(String[] args) {
    FilledListMaker<String> stringMaker =
      new FilledListMaker<String>();
    List<String> list = stringMaker.create("Hello", 4);
    System.out.println(list);
  }
} /* Output:
[Hello, Hello, Hello, Hello]
*///:~
