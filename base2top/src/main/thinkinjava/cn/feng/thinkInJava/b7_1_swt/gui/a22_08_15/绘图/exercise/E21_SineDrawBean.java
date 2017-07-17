package cn.feng.thinkInJava.b7_1_swt.gui.a22_08_15.绘图.exercise;
//: gui/E21_SineDrawBean.java
/**
 * *************** Exercise 21 ******************
 * Modify SineWave.java to turn SineDraw into a
 * JavaBean by adding "getter" and "setter" methods.
 * *********************************************
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

import static net.mindview.util.SwingConsole.run;

class SineDrawBean extends JPanel {

    private static final int SCALEFACTOR = 200;
    private int cycles;
    private int points;
    private double[] sines;
    private int[] pts;
    public SineDrawBean() { setCycles(5); }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int maxWidth = getWidth();
        double hstep = (double) maxWidth / (double) points;
        int maxHeight = getHeight();
        pts = new int[points];
        for (int i = 0; i < points; i++)
            pts[i] = (int) (sines[i] * maxHeight / 2 * .95 + maxHeight / 2);
        g.setColor(Color.RED);
        for (int i = 1; i < points; i++) {
            int x1 = (int) ((i - 1) * hstep);
            int x2 = (int) (i * hstep);
            int y1 = pts[i - 1];
            int y2 = pts[i];
            g.drawLine(x1, y1, x2, y2);
        }
    }
    public void setCycles(int newCycles) {
        cycles = newCycles;
        points = SCALEFACTOR * cycles * 2;
        sines = new double[points];
        for (int i = 0; i < points; i++) {
            double radians = (Math.PI / SCALEFACTOR) * i;
            sines[i] = Math.sin(radians);
        }
        repaint();
    }
    public int getCycles() { return cycles; }
}

class SineWave extends JFrame {

    private SineDrawBean sines = new SineDrawBean();
    private JSlider adjustCycles = new JSlider(1, 30, 5);
    public SineWave() {
        add(sines);
        adjustCycles.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                sines.setCycles(((JSlider) e.getSource()).getValue());
            }
        });
        add(BorderLayout.SOUTH, adjustCycles);
    }
}

public class E21_SineDrawBean {

    public static void main(String[] args) {
        run(new SineWave(), 700, 400);
    }
} ///:~
/**
 There’s a trick to this exercise. We added only the method getCycles( ), but no
 getters and setters for SCALEFACTOR, points, sines, or pts. Those
 dependent variables are calculated on other values within the object, so you
 can’t allow them to be set from outside of the bean.
 Be careful when designing beans so that you don’t mistake getters and setters for
 trivial access methods to variables inside an object. setCycles( ), for example,
 does much more than modify cycles.
 * */