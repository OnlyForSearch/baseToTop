package cn.feng.thinkInJava.b7_1_swt.gui.a22_05_00.文本区域.exercise;
//: gui/E08_Cursors.java
/**
 * *************** Exercise 8 *****************
 * Almost every Swing component is derived from
 * Component, which has a setCursor() method.
 * Look this up in the JDK documentation. Create
 * an application and change the cursor to one of
 * the stock cursors in the Cursor class.
 * *********************************************
 */

import javax.swing.*;
import java.awt.*;

import static net.mindview.util.SwingConsole.run;

class Cursors extends JFrame {

    JTextField txt = new JTextField(10);
    JButton b1 = new JButton("Button 1");
    Cursor hand = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    public Cursors() {
        setLayout(new FlowLayout());
        add(txt);
        txt.setCursor(hand);
        add(b1);
        setCursor(hand);
    }
}

public class E08_Cursors {

    public static void main(String args[]) {
        run(new Cursors(), 200, 100);
    }
} ///:~

/**
 The constants in the Cursor class are ints, not Cursor objects, so you must use
 either the Cursor constructor or getPredefinedCursor( ) method to generate
 a Cursor object from the int (this seems a bit strange, but cursors are system
 resources which, on Windows anyway, can be used up easily—this may be the
 reason for the design).
 Note that if you don’t also set the cursor in the JTextField, it goes back to the
 default cursor.
 * ***/