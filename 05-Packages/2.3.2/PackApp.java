import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;
import figures.Polygon;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1, r2, r3;
    Ellipse e1, e2, e3;
    Polygon p1, p2;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);

        this.r1 = new Rect(50,50, 100,30, Color.red, Color.black);
        this.r2 = new Rect(250,250, 100,150, Color.yellow, Color.red);
        this.r3 = new Rect(150,150, 100,30, Color.pink, Color.red);
        
        this.e1 = new Ellipse(200,100, 140,30, Color.black, Color.green);
        this.e2 = new Ellipse(300,150, 150,30, Color.blue, Color.orange);
        this.e3 = new Ellipse(400,200, 160,30, Color.green, Color.red);

        this.p1 = new Polygon(new int[] {100,130,160}, new int[] {430, 290, 450}, 3, Color.yellow, Color.pink);
        this.p2 = new Polygon(new int[] {60,90,120}, new int[] {300, 90, 300}, 3, Color.cyan, Color.red);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
        this.p1.paint(g);
        this.p2.paint(g);
    }
}
