package figures;

import java.awt.*;

import java.awt.Graphics;

public abstract class Figure {
    public int x, y;
    public int w, h;
    public Color colorFill;

    public Figure(int x, int y, int w, int h, Color colorFill) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.colorFill = colorFill;
    }

    public void drag(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean clicked (int x, int y) {
        return (this.x <= x && x<= this.x + this.w && this.y <= y && y <= this.y + this.w);
    }

    public abstract void paint (Graphics g);

}