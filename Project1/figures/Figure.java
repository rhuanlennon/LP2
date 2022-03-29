package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
    public abstract void paint (Graphics g);
}