package cn.feng.thinkInJava.a9_2_泛型;

//泛型定义在接口上。
interface Inter2<T> {

    void show(T t);
}

/*
class InterImpl implements Inter<String>
{
	public void show(String t)
	{
		System.out.println("show :"+t);
	}
}

*/

class InterImpl2<T> implements Inter2<T> {

    public void show(T t) {
        System.out.println("show :" + t);
    }
}

class GenericDemo5 {

    public static void main(String[] args) {

        InterImpl2<Integer> i = new InterImpl2<Integer>();
        i.show(4);
        //InterImpl i = new InterImpl();
        //i.show("haha");
    }
}
