//: reusing/CADSystem.java
// Ensuring proper cleanup.
package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_04_01.确保正确清理;

import static net.mindview.util.Print.print;

/**
 * 确保正确清理
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Shape {

    Shape(int i) {

        print("Shape constructor");
    }

    void dispose() {

        print("Shape dispose");
    }
}

class Circle extends Shape {

    Circle(int i) {

        super(i);
        print("Drawing Circle");
    }

    void dispose() {

        print("Erasing Circle");
        super.dispose();
    }
}

class Triangle extends Shape {

    Triangle(int i) {

        super(i);
        print("Drawing Triangle");
    }

    void dispose() {

        print("Erasing Triangle");
        super.dispose();
    }
}

class Line extends Shape {

    private int start, end;

    Line(int start, int end) {

        super(start);
        this.start = start;
        this.end = end;
        print("Drawing Line: " + start + ", " + end);
    }

    void dispose() {

        print("Erasing Line: " + start + ", " + end);
        super.dispose();
    }
}

public class CADSystem extends Shape {

    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];

    public CADSystem(int i) {

        super(i + 1);
        for (int j = 0; j < lines.length; j++)
            lines[j] = new Line(j, j * j);
        c = new Circle(1);
        t = new Triangle(1);
        print("Combined constructor");
    }
    public static void main(String[] args) {

        CADSystem x = new CADSystem(47);
        try {
            // Code and exception handling...
        } finally {//必须将清理动作放置于finally字句中,以预防异常的出现
            x.dispose();
        }
    }
    public void dispose() {

        print("CADSystem.dispose()");
        // The order of cleanup is the reverse
        // of the order of initialization:
        t.dispose();
        c.dispose();
        for (int i = lines.length - 1; i >= 0; i--)
            lines[i].dispose();
        super.dispose();
    }
} /* Output:
Shape constructor
Shape constructor
Drawing Line: 0, 0
Shape constructor
Drawing Line: 1, 1
Shape constructor
Drawing Line: 2, 4
Shape constructor
Drawing Circle
Shape constructor
Drawing Triangle
Combined constructor
CADSystem.dispose()
Erasing Triangle
Shape dispose
Erasing Circle
Shape dispose
Erasing Line: 2, 4
Shape dispose
Erasing Line: 1, 1
Shape dispose
Erasing Line: 0, 0
Shape dispose
Shape dispose
*///:~
