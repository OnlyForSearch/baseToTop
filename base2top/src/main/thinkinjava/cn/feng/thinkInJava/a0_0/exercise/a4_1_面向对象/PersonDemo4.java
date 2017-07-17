package cn.feng.thinkInJava.a0_0.exercise.a4_1_面向对象;

/*
 this语句 :用于构造函数之间进行互相调用。

 this语句只能定义在构造函数的第一行。因为初始化要先执行。
 */

class Person4 {

    private String name;
    private int age;

    {

        System.out.println("code run");
    }

    Person4() {
        this("hah");
        System.out.println("person run-->" + this.name);
    }

    Person4(String name) {
        // this();
        this.name = name;
    }

    Person4(String name, int age) {
        // this(name);
        // this.name = name;
        this.age = age;

    }

}

class PersonDemo4 {

    public static void main(String[] args) {
        new Person4();
        // Person p = new Person("lisi",30);
        // Person p1 = new Person("lisi2",36);

    }
}
