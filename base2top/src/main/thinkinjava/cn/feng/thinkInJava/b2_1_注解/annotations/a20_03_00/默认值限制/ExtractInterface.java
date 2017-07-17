//: annotations/ExtractInterface.java
// APT-based annotation processing.
package cn.feng.thinkInJava.b2_1_注解.annotations.a20_03_00.默认值限制;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用apt处理注解



 apt工具及其关联的API已被javac和标准注释处理API javax.annotation.processing 和 javax.lang.model取代。

 与Javac一样，apt被设计为操作Java源文件，而不是编译后的类；自定义的每个注解都需要自己的处理器，而apt工具能够很容易的将多个注解处理器组合在一起。使用apt时必须指明一个工厂类，或者指明能找到apt所需工厂类的路径，apt需要工厂类来为其指明正确的处理器；使用apt生成注解处理器时，无法利用Java反射机制，因为操作的是源代码。

 使用apt，以书中的annotations包为例。
 首先，确保CLASSPATH变量中有tools.jar包，然后cd TIJ4-code，执行javac annotations\InterfaceExtractorProcessorFactory.java编译完成后，然后执行apt -factory annotations.InterfaceExtractorProcessorFactory
 annotations\Multiplier.java -s annotations
 将观察者模式应用于apt

 mirror API提供了对访问者设计模式的支持。
 一个访问者会遍历某个数据结构或一个对象的集合，对其中的每一个对象执行一个操作，该数据结构无需有序，而你对每个对象执行的操作，都是特定于此对象的类型。这就是操作与对象解耦，也就是说，你可以添加新的操作，而无需向类的定义中添加方法。
 * @author fengyu
 * @date 2015年8月9日
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {

    String value();
} ///:~
