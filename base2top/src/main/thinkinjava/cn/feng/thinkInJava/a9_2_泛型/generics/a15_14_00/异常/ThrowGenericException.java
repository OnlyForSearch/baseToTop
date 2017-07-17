package cn.feng.thinkInJava.a9_2_泛型.generics.a15_14_00.异常;

//: generics/ThrowGenericException.java

import java.util.ArrayList;
import java.util.List;

/**
 * 异常
 *由于擦除的原因，将泛型应用于异常是非常受限的。catch语句不能捕获泛型类型的异常，因为在编译期和运行期都必须知道异常的确切类型,泛型类也不能直接或间接继承自Throwable。但是，类型参数可能会在一个方法的throws子句中用到。
 * (这将阻止你去定义不能捕获的泛型异常,但是类型参数可能会在一个方法的throws子句中用到,这使得你可以编写随检查型
 * 异常的类型而发生变化的泛型代码
 * )
 * @param <T>
 *
 * @param <E>
 * @author fengyu
 * @date 2015年8月9日
 */
interface Processor<T, E extends Exception> {
    /**
     * Processor执行process(),并且可能会抛出具有类型E的异常,process()的结果存储在List<T> resultCollector中(这被称为,收集参数),
     * 如果不能参数化所抛出的异常,那么由于检查型异常的缘故,将不能编写出这种泛化的代码
     *
     * */
    void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {

    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<T>();
        for (Processor<T, E> processor : this)
            processor.process(resultCollector);
        return resultCollector;
    }
}

class Failure1 extends Exception {}

class Processor1 implements Processor<String, Failure1> {

    static int count = 3;

    public void process(List<String> resultCollector) throws Failure1 {
        if (count-- > 1)
            resultCollector.add("Hep!");
        else
            resultCollector.add("Ho!");
        if (count < 0)
            throw new Failure1();
    }
}

class Failure2 extends Exception {}

class Processor2 implements Processor<Integer, Failure2> {

    static int count = 2;

    public void process(List<Integer> resultCollector) throws Failure2 {
        if (count-- == 0)
            resultCollector.add(47);
        else {
            resultCollector.add(11);
        }
        if (count < 0)
            throw new Failure2();
    }
}

public class ThrowGenericException {

    public static void main(String[] args) {
        ProcessRunner<String, Failure1> runner = new ProcessRunner<String, Failure1>();
        for (int i = 0; i < 3; i++)
            runner.add(new Processor1());
        try {
            System.out.println(runner.processAll());
        } catch (Failure1 e) {
            System.out.println(e);
        }
        ProcessRunner<Integer, Failure2> runner2 = new ProcessRunner<Integer, Failure2>();
        for (int i = 0; i < 3; i++)
            runner2.add(new Processor2());
        try {
            System.out.println(runner2.processAll());
        } catch (Failure2 e) {
            System.out.println(e);
        }
    }
} // /:~
