import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main(String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    Point PositionMouse = null;

    ListFrame() {
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });

           
        this.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent evt) {
                        PositionMouse = getMousePosition();
                        int x = PositionMouse.x;
                        int y = PositionMouse.y;

                        int w = rand.nextInt(80);
                        int h = rand.nextInt(80);
                        if (evt.getKeyChar() == 'r') {
                            Rect r = new Rect(x, y, w, h);
                            figs.add(r);
                        } 
                        else if (evt.getKeyChar() == 'e') {
                            figs.add(new Ellipse(x, y, w, h));
                        }  
                        else if (evt.getKeyChar() == 'p') {
                            figs.add(new Poligono(x, y, w, h));
                          }
                        else if (evt.getKeyChar() == 'l') {
                            figs.add(new Line(x, y, w, h));
                          }
                        repaint();
                    }
                });

        this.setTitle("Projeto 1 - Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (Figure fig : this.figs) {
            fig.paint(g);
        }
    }
}
