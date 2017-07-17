package cn.feng.thinkInJava.模式.适配器设计模式;

/**
 * 适配器设计模式
 */
public class FilterAdapter implements Processor {

    private Filter filter;

    /**
     * 构造器接受所有的接口Filter,让后生成所需要的Processor
     */
    public FilterAdapter(Filter filter) {
        super();
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.getClass().getSimpleName();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }

}
