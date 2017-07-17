package cn.feng.thinkInJava.a1_2_操作符.operators.a3_07_01.关系操作符.exerciese;

/**
 * Created by fengyu on 2015-09-29.
 */
public class Dog {

    String name;
    String says;
    public static void main(String args[]) {
        Dog dog = new Dog();
        dog.name = "spot";
        dog.says = "Ruff";
        System.out.println("dog = " + dog);
        Dog dog1 = new Dog();
        dog1.name = "scruff";
        dog1.says = "Wurff";
        System.out.println("dog1 = " + dog1);

        Dog dog2 = new Dog();
        dog2 = dog;
        System.out.println("dog2 = " + dog2);
        System.out.println("(dog2==dog) = " + (dog2 == dog));
        System.out.println("dog2.equals(dog)  = " + dog2.equals(dog));
    }
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", says='" + says + '\'' +
                '}';
    }
}
