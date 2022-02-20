import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    // Rect r1;
    Ellipse e1, e2, e3;

    RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect and Ellipse");
        this.setSize(350, 350);
        // this.r1 = new Rect(50,50, 100,30);
        this.e1 = new Ellipse(200,100, 140,30);
        this.e2 = new Ellipse(300,150, 150, 30);
        this.e3 = new Ellipse(400,200, 160,30);
    }

    public void paint (Graphics g) {
        super.paint(g);
        // this.r1.paint(g);
        this.e1.paint(g, Color.black, Color.green);
        this.e2.paint(g, Color.blue, Color.orange);
        this.e3.paint(g, Color.green, Color.red);
    }
}

class Rect {
    int x, y;
    int w, h;

    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

   public void paint (Graphics g) {
        g.drawRect(this.x,this.y, this.w,this.h);
       
    }
}

class Ellipse {
    int x, y;
    int w, h;

    Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g, Color colorFill, Color colorDraw) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(colorDraw);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setColor(colorFill);
        g2d.fillOval(this.x, this.y, this.w, this.h);

    }
}
