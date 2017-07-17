package cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_00.通配符;
//泛型的只要目标之一就是将错误移入到编译期
/*package cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_00;

//: generics/NonCovariantGenerics.java
// {CompileTimeError} (Won't compile)
import java.util.*;

public class NonCovariantGenerics
{	//泛型的只要目标之一就是将错误移入到编译期
	// Compile Error: incompatible types:
	List<Fruit> flist=new ArrayList<Apple>();
} // /:~

class Fruit
{
}

class Apple extends Fruit
{
}

class Jonathan extends Apple
{
}

class Orange extends Fruit
{
}
*/