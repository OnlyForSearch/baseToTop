package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_08_02.controller.内部类与控制框架.A10_08_03;
//: innerclasses/GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}

import cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_08_02.controller.内部类与控制框架.Event;

/**
 * 命令设计模式
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class GreenhouseController {

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {gc.new ThermostatNight(0), gc.new LightOn(200), gc.new LightOff(400), gc.new WaterOn(600), gc.new WaterOff(800), gc.new ThermostatDay(1400)};
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1)
            gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
        gc.run();
    }
} /* Output:
Bing!
Thermostat on night setting
Light is on
Light is off
Greenhouse water is on
Greenhouse water is off
Thermostat on day setting
Restarting system
Terminating
*///:~
