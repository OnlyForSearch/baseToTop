package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_05.基类劫持了接口;

//: generics/RestrictedComparablePets.java
//说明再次实现ComparablePet中相同的接口是可能的,只要它们\精确地相同,包括参数类型在内,但是只是覆盖基类中的方法相同
class Hamster extends ComparablePet implements Comparable<ComparablePet> {

    public int compareTo(ComparablePet arg) {
        return 0;
    }
}

// Or just:
class Gecko extends ComparablePet {

    public int compareTo(ComparablePet arg) {
        return 0;
    }
} /// :~
