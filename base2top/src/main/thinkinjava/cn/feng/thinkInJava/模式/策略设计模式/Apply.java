package cn.feng.thinkInJava.模式.策略设计模式;

/**
 * 策略设计模式:创建一个能够根据所传递的参数对象的不同而具有不同行为的方法, 方法包含
 * 所要执行的算法中固定不变的部分,而"策略"就是包含变化的部分策略就是传递进去的参数对象,它包含要执行的代码
 */
public class Apply {

    public static String string = "Disagreement with beliefs is by definition incorrect";
    /* process()方法可以接受任何类型的Processor,并将其应用到Object对象上 */
    //
    public static void process(Processor p, Object input) {
        System.out.println(p.name() + ":" + p.process(input));

    }
    public static void main(String[] args) {
        //两种不同的策略应用到了String类型对象string上面
        process(new Upcase(), string);
        process(new LowerCase(), string);
    }

}

class Processor {

    public String name() {
        return this.getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {

    public Object process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class LowerCase extends Processor {

    public Object process(Object input) {
        return ((String) input).toLowerCase();
    }
}