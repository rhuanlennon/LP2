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
    Rect r1, r2, r3;
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
        this.r1 = new Rect(50,50, 100,30, Color.red, Color.black);
        this.r2 = new Rect(250,250,100,150, Color.blue, Color.orange);
        this.r3 = new Rect(450,250,100,180, Color.green, Color.red);

        this.e1 = new Ellipse(200,100, 140,30, Color.black, Color.green);
        this.e2 = new Ellipse(300,150, 150, 30, Color.blue, Color.orange);
        this.e3 = new Ellipse(400,200, 160,30, Color.green, Color.red);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);

        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    Color colorFill, colorDraw;

    Rect (int x, int y, int w, int h, Color colorFill, Color colorDraw) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.colorFill = colorFill;
        this.colorDraw = colorDraw;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

   public void paint (Graphics g) {
        g.setColor(colorFill);
        g.fillRect(this.x,this.y, this.w,this.h);
        g.setColor(colorDraw);
        g.drawRect(this.x,this.y, this.w,this.h);    
    }
}

class Ellipse {
    int x, y;
    int w, h;
    Color colorFill, colorDraw;

    Ellipse (int x, int y, int w, int h, Color colorFill, Color colorDraw) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.colorFill = colorFill;
        this.colorDraw = colorDraw;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(colorDraw);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setColor(colorFill);
        g2d.fillOval(this.x, this.y, this.w, this.h);
    }
}
