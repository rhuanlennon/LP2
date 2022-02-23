package figures;
import java.awt.Color;

import java.awt.*;

public class Rect {
    private int x, y;
    private int w, h;
    private Color RColorFill;
    private Color RColorDraw;
    

    public Rect (int x, int y, int w, int h, Color RColorFill, Color RColorDraw ) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.RColorDraw = RColorDraw;
        this.RColorFill = RColorFill;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(RColorDraw);
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(RColorFill);
        g2d.fillRect(this.x, this.y, this.w, this.h);
    }
}