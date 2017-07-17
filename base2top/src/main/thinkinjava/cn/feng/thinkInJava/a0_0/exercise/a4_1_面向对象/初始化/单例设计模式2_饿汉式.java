package cn.feng.thinkInJava.a0_0.exercise.a4_1_面向对象.初始化;

public class 单例设计模式2_饿汉式 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
/*
这个是先初始化对象。
称为：饿汉式。

Single类一进内存，就已经创建好了对象。
class Single
{
	private static Single s = new Single();
	private Single(){}
	public static Single getInstance()
	{
		return s;
	}
}
*/

//对象是方法被调用时，才初始化，也叫做对象的延时加载。成为：懒汉式。
//Single类进内存，对象还没有存在，只有调用了getInstance方法时，才建立对象。
class Single2 {

    private static Single2 s = null;
    private Single2() {}
    public static Single2 getInstance() {
        if (s == null) {
            synchronized (Single2.class) {
                if (s == null)
                    s = new Single2();
            }
        }
        return s;
    }
}

//记录原则：定义单例，建议使用饿汉式。

