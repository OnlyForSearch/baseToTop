package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_05.基类劫持了接口;
//: generics/HijackedInterface.java
// {CompileTimeError} (Won't compile)

/*class Cat extends ComparablePet implements Comparable<Cat>{
  // Error: Comparable cannot be inherited with
  // different arguments: <Cat> and <Pet>
  public int compareTo(Cat arg) { return 0; }
} ///:~
*/