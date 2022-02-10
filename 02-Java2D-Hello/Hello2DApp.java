import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.black);
        int w = getWidth();
        int h = getHeight();
        g2d.fillRect(0, 0, w, h);
        g2d.setPaint(Color.white);
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
        g2d.drawPolygon(new int[] {20, 175, 330}, new int[] {340, 50, 340}, 3);
        Font myFont = new Font ("Serif", 1, 15);
        g.setFont (myFont);
        g.setColor(Color.CYAN);
        g2d.drawString("Rhuan Lennon ", 135, 250);
    }
}