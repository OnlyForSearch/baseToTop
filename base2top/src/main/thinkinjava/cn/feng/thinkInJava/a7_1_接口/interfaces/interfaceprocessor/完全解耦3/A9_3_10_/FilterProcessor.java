//: interfaces/interfaceprocessor/FilterProcessor.java
package cn.feng.thinkInJava.a7_1_接口.interfaces.interfaceprocessor.完全解耦3.A9_3_10_;

import cn.feng.thinkInJava.a7_1_接口.interfaces.filters.完全解耦2.*;
import cn.feng.thinkInJava.a7_1_接口.interfaces.interfaceprocessor.完全解耦3.A9_3_7.Processor;
import cn.feng.thinkInJava.a7_1_接口.interfaces.interfaceprocessor.完全解耦3.A9_3_8.Apply;

/**
 * 适配器设计模式,适配器中的代码将接受你所拥有的接口,并产生你所需要的接口
 */
class FilterAdapter implements Processor {

    Filter filter;
    //构造器接受你所有的接口Filter然后生成具有你所需要的Processor接口对象
    public FilterAdapter(Filter Filter) {
        this.filter = Filter;
    }
    public String name() { return filter.name(); }
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }//用到了代理了
}

public class FilterProcessor {

    public static void main(String[] args) {
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
        Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
    }
} /* Output:
Using Processor LowPass
Waveform 0
Using Processor HighPass
Waveform 0
Using Processor BandPass
Waveform 0
*///:~
