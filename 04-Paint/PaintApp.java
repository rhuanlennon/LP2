import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1;
    Rect r2;
    Rect r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures with Java2d");

        this.setSize(350, 350);
        this.r1 = new Rect(150,150,150,180);
        this.r2 = new Rect(250,250,100,150);
        this.r3 = new Rect(350,80,100,180);
    }


    public void paint (Graphics g) {
        super.paint(g);

        this.r1.paint(g, Color.black, Color.red);
        this.r2.paint(g, Color.gray, Color.orange);
        this.r3.paint(g, Color.cyan, Color.blue);
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

    void paint (Graphics g, Color colorFill, Color colorDraw ) {
        g.setColor(colorFill);
        g.fillRect(this.x,this.y, this.w,this.h);
        g.setColor(colorDraw);
        g.drawRect(this.x,this.y, this.w,this.h);  
    }
}