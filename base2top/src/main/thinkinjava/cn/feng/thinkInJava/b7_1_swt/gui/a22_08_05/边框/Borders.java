package cn.feng.thinkInJava.b7_1_swt.gui.a22_08_05.边框;
//: gui/Borders.java
// Different Swing borders.

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import static net.mindview.util.SwingConsole.run;

public class Borders extends JFrame {

    public Borders() {
        setLayout(new GridLayout(2, 4));
        add(showBorder(new TitledBorder("Title")));
        add(showBorder(new EtchedBorder()));
        add(showBorder(new LineBorder(Color.BLUE)));
        add(showBorder(new MatteBorder(5, 5, 30, 30, Color.GREEN)));
        add(showBorder(new BevelBorder(BevelBorder.RAISED)));
        add(showBorder(new SoftBevelBorder(BevelBorder.LOWERED)));
        add(showBorder(new CompoundBorder(new EtchedBorder(), new LineBorder(Color.RED))));
    }
    static JPanel showBorder(Border b) {
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        String nm = b.getClass().toString();
        nm = nm.substring(nm.lastIndexOf('.') + 1);
        jp.add(new JLabel(nm, JLabel.CENTER), BorderLayout.CENTER);
        jp.setBorder(b);
        return jp;
    }
    public static void main(String[] args) {
        run(new Borders(), 500, 300);
    }
} ///:~
