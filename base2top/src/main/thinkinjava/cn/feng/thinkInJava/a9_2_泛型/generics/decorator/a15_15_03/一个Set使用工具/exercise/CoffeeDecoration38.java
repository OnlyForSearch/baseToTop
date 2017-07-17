package cn.feng.thinkInJava.a9_2_泛型.generics.decorator.a15_15_03.一个Set使用工具.exercise;// generics/CoffeeDecoration38.java

// TIJ4 Chapter Generics, Exercise 38, page 719
// Create a simple Decorator system by starting with basic coffee, then
// providing decorators of steamed milk, foam, chocolate, caramel and 
// whipped cream.
//从基本的Coffee入手,创建一个简单的装饰器系统,然后提供可以导入牛奶,泡沫,巧克力,焦糖和生奶油的装饰器
class BasicCoffee {

    private static long counter = 0;
    private final long id = counter++;
    private String value;
    public void set(String val) { value = val; }
    public String get() { return value; }
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Decorator extends BasicCoffee {

    protected BasicCoffee basicCoffee;
    public Decorator(BasicCoffee basicCoffee) {
        this.basicCoffee = basicCoffee;
    }
    public void set(String val) { basicCoffee.set(val); }
    public String get() { return basicCoffee.get(); }
}

class SteamedMilk extends Decorator {

    private final String steamedMilk = "steamedMilk";
    public SteamedMilk(BasicCoffee basicCoffee) {
        super(basicCoffee);
    }
    public String getSteamedMilk() { return steamedMilk; }
}

class Foam extends Decorator {

    private final String foam = "foam";
    public Foam(BasicCoffee basicCoffee) {
        super(basicCoffee);
    }
    public String getFoam() { return foam; }
}

class Chocolate extends Decorator {

    private final String chocolate = "chocolate";
    public Chocolate(BasicCoffee basicCoffee) {
        super(basicCoffee);
    }
    public String getChocolate() { return chocolate; }
}

class Caramel extends Decorator {

    private final String caramel = "caramel";
    public Caramel(BasicCoffee basicCoffee) {
        super(basicCoffee);
    }
    public String getCaramel() { return caramel; }
}

class WhippedCream extends Decorator {

    private final String whippedCream = "whippedCream";
    public WhippedCream(BasicCoffee basicCoffee) {
        super(basicCoffee);
    }
    public String getWhippedCream() { return whippedCream; }
}

public class CoffeeDecoration38 {

    public static void main(String[] args) {
        SteamedMilk sm = new SteamedMilk(new BasicCoffee());
        SteamedMilk sm2 = new SteamedMilk(new Foam(new BasicCoffee()));
        Chocolate c = new Chocolate(new BasicCoffee());
        WhippedCream wc = new WhippedCream(new Caramel(new Chocolate(new Foam(new SteamedMilk(new BasicCoffee())))));
    }
}