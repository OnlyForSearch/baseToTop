//: enumerated/EnumSets.java
// Operations on EnumSets
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_08_00.使用EnumSet替代标志;

import java.util.EnumSet;

import static net.mindview.util.Print.print;

/**使用EnumSet替代标志
 * EnumSet（可能）就是将一个long值作为比特向量，所以EnumSet非常快速高效。

 allOf(Class elementType) 创建一个包含指定元素类型的所有元素的 EnumSet。
 clone() 返回set的副本
 complementOf(EnumSet s) 创建一个其元素类型与指定 EnumSet 相同的 EnumSet，最初包含指定 set 中所不包含的此类型的所有元素。
 copyOf(Collection c) 创建一个从指定 collection 初始化的枚举 set。
 copyOf(EnumSet s) 创建一个其元素类型与指定 EnumSet 相同的 EnumSet，最初包含相同的元素（如果有的话）。
 noneOf(Class elementType) 创建一个具有指定元素类型的空 EnumSet。
 of() 创建一个最初包含指定元素的EnumSet。有很多个重载版本，接收1到5个参数的，以及可变参数的，表现出EnumSet对性能的注重。
 range(E from, E to) 创建一个最初包含由两个指定端点所定义范围内的所有元素的EnumSet。
 *
 *
 * 使用EnumSet代替标志:EnumSet是为了通过enum创建一种替代品,以替代传统的基于int的"位标志"
 * 这种标志可以用来表示某种"开/关"信息,不过这种标志,最终操作的只是一些bit,而不是zhexiebit想要表达的概念,因此很容易写出令人
 * 难以理解的代码
 * <p>
 * EnumSet的设计充分的考虑到了速度因素,因为它必须与非常搞笑的bit标志相竞争(其操作与HashSet相比非常的快)
 * 使用EnumSet的优点是,它在说明一个二进制位是否存在存在时,具有更好的表达能力,并且无需担心性能
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class EnumSets {

    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class); // Empty set
        points.add(AlarmPoints.BATHROOM);
        print(points);
        points.addAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        print(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        print(points);
        points.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
        print(points);
        points = EnumSet.complementOf(points);
        print(points);
    }
} /* Output:
[BATHROOM]
[STAIR1, STAIR2, BATHROOM, KITCHEN]
[LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY]
[LOBBY, BATHROOM, UTILITY]
[STAIR1, STAIR2, OFFICE1, OFFICE2, OFFICE3, OFFICE4, KITCHEN]
*///:~
