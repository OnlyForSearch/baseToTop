package cn.feng.thinkInJava.b7_1_swt.gui.a22_08_15.绘图.exercise;
//: gui/E23_RotatingSquare.java
/**
 * *************** Exercise 23 *****************
 * Using SineWave.java as a starting point, create
 * a program that displays a rotating square on the
 * screen. One slider should control the speed of
 * rotation, and a second slider should control the
 * size of the box.
 * *********************************************
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import static net.mindview.util.SwingConsole.run;

class SquareRotate extends JPanel {

    private Rectangle2D square = new Rectangle2D.Float(-50f, -50f, 100f, 100f);

    private AffineTransform rot = new AffineTransform(), scale = new AffineTransform();
    private volatile int speed;
    private int boxSize;
    public SquareRotate() {
        setSpeed(5);
        setBoxSize(10);
        new Thread(new Runnable() {
            public void run() {
                for (; ; ) {
                    SquareRotate.this.repaint();
                    try {
                        Thread.sleep(1000 / speed);
                    } catch (InterruptedException ignore) {}
                }
            }
        }).start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // Makes point (0,0) as the center of this canvas
        g2.translate(getWidth() / 2, getHeight() / 2);
        g2.scale(boxSize / 10.0, boxSize / 10.0);
        g2.setPaint(Color.blue);
        rot.rotate(Math.toRadians(20));
        g2.transform(rot);
        g2.draw(square);
    }
    public void setSpeed(int speed) { this.speed = speed; }
    public void setBoxSize(int boxSize) {
        this.boxSize = boxSize;
    }
}

class RotatingSquare extends JFrame {

    private SquareRotate sq = new SquareRotate();
    private JSlider adjustSpeed = new JSlider(1, 10, 5);
    private JSlider adjustBoxSize = new JSlider(1, 20, 10);
    public RotatingSquare() {
        add(sq);
        adjustSpeed.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                sq.setSpeed(adjustSpeed.getValue());
            }
        });
        adjustBoxSize.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                sq.setBoxSize(adjustBoxSize.getValue());
            }
        });
        JPanel sliders = new JPanel();
        sliders.setLayout(new GridLayout(2, 1));
        sliders.add(adjustSpeed);
        sliders.add(adjustBoxSize);
        add(BorderLayout.SOUTH, sliders);
    }
}

public class E23_RotatingSquare {

    public static void main(String args[]) {
        run(new RotatingSquare(), 400, 400);
    }
} ///:~

/**

 This solution demonstrates the Java 2D API. Consult the JDK for more
 information about the classes used here. Notice how the AffineTransform
 class spares you from complex mathematics by handling all aspects of rotation
 and scaling.
 A dedicated thread controls the speed of rotation.
 You can safely call the repaint( ) method from any thread.
 As an additional exercise, try to solve this without the Java 2D API and compare
 the two versions.

 * */