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
    Point mouse = null;
    Point PositionMouse = null;
    Figure focus = null;

    ListFrame() {
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
        
                this.addMouseListener(
                    new MouseAdapter() {
                        public void mousePressed(MouseEvent evt){
                            mouse = getMousePosition();
                            focus = null;
        
                            for (int i = 0; i < figs.size(); i++){
                                if (figs.get(i).clicked(mouse.x,mouse.y)) {
                                    focus = figs.get(i); 
                                }
                                else {
                                    if(figs.get(i).getClass().getSimpleName().equals("Texto")){
                                        figs.get(i).colorFill = Color.white;
                                    }
                                    else{
                                        figs.get(i).colorFill = Color.black; 
                                    }
                                }  
                            }
                            if (focus != null){ 
                                figs.remove(focus);
                                figs.add(focus);
                                focus.colorFill = Color.red;
                            }
                            repaint();
                        }
                    });
        this.addMouseMotionListener( 
            new MouseAdapter() {
                public void mouseDragged (MouseEvent evt) {
                    if(focus != null){
                        int dx = evt.getX() - mouse.x;
                        int dy = evt.getY() - mouse.y;
                        focus.drag(dx, dy);
                        repaint();
                    }
                    mouse = evt.getPoint();
                }
            }
        );

        this.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent evt) {

                        Color colorFill = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                        Color colorDraw = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));

                        PositionMouse = getMousePosition();

                        int x = PositionMouse.x;
                        int y = PositionMouse.y;
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        
                        if (evt.getKeyChar() == 'r') {
                            figs.add(new Rect(x, y, w, h, colorFill, colorDraw));
                            focus = figs.get(figs.size()-1);
                            
                        } 
                        else if (evt.getKeyChar() == 'e') {
                            figs.add(new Ellipse(x, y, w, h, colorFill, colorDraw)); 
                            focus = figs.get(figs.size()-1);
                        }  
                        else if (evt.getKeyChar() == 'p') {
                            figs.add(new Poligono(x, y, w, h, colorFill, colorDraw));
                            focus = figs.get(figs.size()-1);
                          }
                        else if (evt.getKeyChar() == 'l') {
                            figs.add(new Line(x, y, w, h, colorFill));
                            focus = figs.get(figs.size()-1);
                          }
                        repaint();
                    }
                });

        this.setTitle("Projeto 1 - Lista de Figuras");
        this.setSize(700, 700);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
