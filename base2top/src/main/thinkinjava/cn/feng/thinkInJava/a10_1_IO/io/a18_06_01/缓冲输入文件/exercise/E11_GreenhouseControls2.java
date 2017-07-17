package cn.feng.thinkInJava.a10_1_IO.io.a18_06_01.缓冲输入文件.exercise;
//: io/E11_GreenhouseControls2.java
// {Args: 5000000}
/**
 * *************** Exercise 11 ***************************
 * (Intermediate) In the
 * innerclasses/GreenhouseController.java example,
 * GreenhouseController contains a hard-coded set of events.
 * Change the program so that it reads the events and their
 * relative times from a text file. (Challenging: Use a
 * Factory Method design pattern to build the events—see
 * Thinking in Patterns (with Java) at www.MindView.net.)
 * *******************************************************
 */
/**
 * 在innerclasses/GreenhouseController.java 示例中,GreenhouseController包含一个硬编码的事件集.修改该程序,使其从一个文本文件中读取事件和它们相关联的次数
 *
 *
 * */
import cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_08_02.controller.内部类与控制框架.A10_08_03.GreenhouseControls;
import cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_08_02.controller.内部类与控制框架.Event;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.LinkedList;

class GreenhouseControls2 extends GreenhouseControls {

    GHEventFactory gheFactory;

    public GreenhouseControls2(String initFile) {
        gheFactory = new GHEventFactory(initFile);
        // Now we need some logic to setup the system.
        // The restart event requires a special attention.
        LinkedList<Event> restartableEvents = new LinkedList<Event>();
        Iterator<Event> it = gheFactory.iterator();
        while (it.hasNext()) {
            Event e = it.next();
            if (e instanceof Bell || e instanceof Restart)
                continue;
            restartableEvents.add(e);
        }
        it = gheFactory.iterator();
        while (it.hasNext()) {
            Event e = it.next();
            addEvent(e);
            if (e instanceof Restart)
                ((Restart) e).setEventList(restartableEvents.toArray(new Event[0]));
        }
    }

    class Restart extends Event {

        private Event[] eventList;
        public Restart(long delayTime) { super(delayTime); }
        public void action() {
            for (Event e : eventList) {
                e.start(); // Rerun each event
                addEvent(e);
            }
            start();
            addEvent(this); // Rerun this Event
        }
        public String toString() {
            return "Restarting system";
        }
        public void setEventList(Event[] eventList) {
            this.eventList = eventList;
        }
    }

    class GHEventFactory {

        LinkedList<EventCreator> events = new LinkedList<EventCreator>();

        @SuppressWarnings("unchecked")
        public GHEventFactory(String eventFile) {
            try {
                BufferedReader in = new BufferedReader(new FileReader(eventFile));
                String s;
                while ((s = in.readLine()) != null) {
                    int colon = s.indexOf(':');
                    // Must use '$' instead of '.' to
                    // describe inner classes:
                    String className = s.substring(0, colon).trim();
                    Class<?> outer = className.equals("Restart") ? GreenhouseControls2.class : GreenhouseControls.class;
                    String type = outer.getSimpleName() + "$" + className;
                    long offset = Long.parseLong(s.substring(colon + 1).trim());
                    // Use Reflection to find and call
                    // the right constructor:
                    Class<Event> eventClass = (Class<Event>) Class.forName(type);
                    // Inner class constructors implicitly
                    // take the outer-class object as a
                    // first argument:
                    Constructor<Event> ctor = eventClass.getConstructor(new Class<?>[]{outer, long.class});
                    events.add(new EventCreator(ctor, offset));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        Iterator<Event> iterator() {
            return new Iterator<Event>() {
                Iterator<EventCreator> it = events.iterator();
                public boolean hasNext() {
                    return it.hasNext();
                }
                public Event next() {
                    EventCreator ec = it.next();
                    Event returnVal = null;
                    try {
                        returnVal = ec.ctor.newInstance(new Object[]{GreenhouseControls2.this, ec.offset});
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return returnVal;
                }
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        class EventCreator {

            Constructor<Event> ctor;
            long offset;
            public EventCreator(Constructor<Event> ctor, long offset) {
                this.ctor = ctor;
                this.offset = offset;
            }
        }
    }
}

public class E11_GreenhouseControls2 {

    public static void main(String[] args) {
        GreenhouseControls2 gc = new GreenhouseControls2("GreenhouseConfig.dat");
        try {
            if (args.length == 1)
                gc.addEvent(new GreenhouseControls.Terminate(Long.parseLong(args[0])));
        } catch (NumberFormatException e) {
            System.err.println("Terminate event is not added!");
            e.printStackTrace();
        }
        gc.run();
    }
} /* Output: (Sample)
Thermostat on night setting
Light is on
Light is off
Greenhouse water is on
Greenhouse water is off
Bing!
Thinking in Java, 4 510 th Edition Annotated Solution Guide
Thermostat on day setting
Restarting system
Bing!
Thermostat on night setting
Light is on
Light is off
Greenhouse water is on
Greenhouse water is off
Bing!
Thermostat on day setting
Restarting system
Bing!
Thermostat on night setting
Light is on
Light is off
Greenhouse water is on
Greenhouse water is off
Terminating
*///:~

/**
 * The GHEventFactory class contains a LinkedList to hold an EventCreator
 * object for each line in the configuration file. Each EventCreator holds a
 * Constructor and the offset value for each event. The Constructor is a
 * java.lang.reflection object that represents a constructor for a class, which you
 * can use to dynamically create new objects. The trick is in producing the
 * Constructor object, which we see in the GHEventFactory constructor.
 * The GHEventFactory constructor takes a text configuration file argument. It
 * opens that file, finds the colon in each line, and divides the line on the colon into
 * the class name and offset value. Since these are inner classes, you must prepend
 * GreenhouseControls to qualify the name, but never separate it with a ‘.’
 * I/O 511
 * because Class.forName( ) actually looks for the filename to load, so you must
 * separate the names with the ‘$’ (which separates class names in the compilergenerated internal name for an inner class).
 * Class.forName( ) uses the string we provide to produce a reference to the
 * Class object. The method getConstructor( ) produces the Constructor
 * object, but needs an argument list to match with the appropriate constructor.
 * Give it an array of Class objects matching your argument list; then you can add
 * the EventCreator.
 * The program could throw several exceptions here, which we convert to
 * RuntimeExceptions. If anything fails, it reports everything to the console.
 * We use an iterator to move through the EventCreator objects and produce new
 * Event objects, which we define as anonymous inner classes built on top of the
 * events LinkedList. Every time you call next( ), the iterator fetches the next
 * EventCreator in the list and uses its Constructor and offset to build a new
 * Event object. The newInstance method is called on the Constructor object;
 * it requires the correct number and type of arguments passed to it as a
 * dynamically created array of Objects. The offset is added to the current time
 * each time you call next( ).
 * We initialize the Restart class with a new setEventList( ) method. During
 * startup it hands eligible events to the matching Restart object (e.g., the Bell
 * restarts itself automatically).
 * <p>
 * *
 */