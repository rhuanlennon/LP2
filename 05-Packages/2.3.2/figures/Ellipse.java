package figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ellipse {
    private int x, y;
    private int w, h;
    private Color EColorFill;
    private Color EColorDraw;

    public Ellipse (int x, int y, int w, int h, Color EColorFill, Color EColorDraw) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.EColorFill = EColorFill;
        this.EColorDraw = EColorDraw;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(EColorDraw);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setColor(EColorFill);
        g2d.fillOval(this.x, this.y, this.w, this.h);
    }
}
