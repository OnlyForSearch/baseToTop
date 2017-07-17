package cn.feng.thinkInJava.a9_2_泛型.generics.a15_12_01.古怪的泛型循环;

//: generics/CRGWithBasicHolder.java

/**
 * 创建一个新类,它继承自一个泛型类型,这个泛型类型接受我的类的名字作为参数
 */
class Subtype extends BasicHolder<Subtype> {}

/**
 * 古怪的循环泛型CRG:基类用导出类替代其参数,这意味着泛型基类变成了一种其所有导出类的公共功能的模板,但是这些功能对于其所有参数和返回值,
 * 将使用导出类,也就是说,在所产生的类中将使用确切类型而不是基本类型,因此,在Subtype,中传递给set()的参数和从
 * get()返回的类型都是确切的Subtype
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class CRGWithBasicHolder {

    public static void main(String[] args) {
        Subtype st1 = new Subtype(), st2 = new Subtype();
        st1.set(st2);
        //返回的都是确切类型
        Subtype st3 = st1.get();
        st1.f();
    }
} /*
 * Output: Subtype
 */// :~
