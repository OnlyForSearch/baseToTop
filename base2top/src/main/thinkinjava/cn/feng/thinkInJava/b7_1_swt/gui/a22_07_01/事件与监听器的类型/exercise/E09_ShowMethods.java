package cn.feng.thinkInJava.b7_1_swt.gui.a22_07_01.事件与监听器的类型.exercise;
//: gui/E09_ShowMethods.java
/**
 * *************** Exercise 9 *****************
 * Starting with ShowAddListeners.java, create a
 * program with the full functionality of
 * typeinfo.ShowMethods.java.
 * *********************************************
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;

import static net.mindview.util.SwingConsole.run;

class ShowMethodsClean extends JFrame {

    private static Pattern qualifier = Pattern.compile("\\w+\\.");
    String[] n;
    JTextField name = new JTextField(25), searchFor = new JTextField(25);
    JTextArea results = new JTextArea(40, 65);
    JScrollPane scrollPane = new JScrollPane(results);

    class NameL implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String nm = name.getText().trim();
            if (nm.length() == 0) {
                results.setText("No match");
                return;
            }
            Class<?> cl;
            try {
                cl = Class.forName(nm);
            } catch (ClassNotFoundException ex) {
                results.setText("No match");
                return;
            }
            Method[] m = cl.getMethods();
            Constructor<?>[] ctor = cl.getConstructors();
            // Convert to an array of cleaned Strings:
            n = new String[m.length + ctor.length];
            for (int i = 0; i < m.length; i++)
                n[i] = m[i].toString();
            for (int i = 0; i < ctor.length; i++)
                n[i + m.length] = ctor[i].toString();
            reDisplay();
        }
    }
    void reDisplay() {
        results.setText("");
        if (searchFor.getText().trim().length() == 0)
            // Include everything:
            for (String s : n)
                results.append(s + "\n");
            // OR:
            // results.append(
            // qualifier.matcher(s).replaceAll("") + "\n");
        else {
            // Include only methods that have ALL the
            // words listed in searchFor:
            java.util.List<String> lookFor = Arrays.asList(searchFor.getText().split("\\s+"));
            for (String s : n) {
                Iterator<String> it = lookFor.iterator();
                boolean include = true;
                while (it.hasNext())
                    if (s.indexOf(it.next()) == -1)
                        include = false;
                if (include == true)
                    results.append(s + "\n");

                // OR:
                // results.append(
                // qualifier.matcher(s).replaceAll("") + "\n");
            }
        }
        // Force the scrollpane back to the top:
        scrollPane.getViewport().setViewPosition(new Point(0, 0));
    }
    public ShowMethodsClean() {
        name.addActionListener(new NameL());
        // There is no need to parse the class file again when
        // only the search conditions have changed:
        searchFor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reDisplay();
            }
        });
        JPanel top1 = new JPanel();
        top1.add(new JLabel("Qualified.class.name (press ENTER):"));
        top1.add(name);
        JPanel top2 = new JPanel();
        top2.add(new JLabel("Words to search for (optional):"));
        top2.add(searchFor);
        JPanel top = new JPanel(new GridLayout(2, 1));
        top.add(top1);
        top.add(top2);
        add(BorderLayout.NORTH, top);
        add(scrollPane);
    }
}

public class E09_ShowMethods {

    public static void main(String args[]) {
        run(new ShowMethodsClean(), 600, 400);
    }
} ///:~
/**
 * We add a second JTextField called searchFor to hold a list of words to find.
 Then we copy the methods and constructors from the Class object into n (the
 Strings array of all possible names), and call reDisplay( ) to choose methods
 to display the names. If there are no words in the searchFor field, the program
 shows everything. If there are words in the searchFor field, the String from
 that field must be broken up into words using String.split( ). We put each
 708 Thinking in Java, 4th Edition Annotated Solution Guide
 word into java.util.List lookFor, then use the flag include to examine each
 method/constructor, making sure it contains all the words in lookFor, and
 place it into the JTextArea. Remember, the search is case-sensitive.
 The JTextArea can appear blank when elements in the output have just
 scrolled off the page, so we move the scroll-pane back to the top whenever
 JTextArea data is modified. You must modify the Viewport, and not the
 JScrollPane directly, as you can see in the line of code at the end of
 reDisplay( ).
 Optionally, you can remove the pertinent comments from the code to strip off
 the qualifiers, and resize the main application window if the UI displays
 awkwardly.
 *
 * */