package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Figure {
    public Color colorDraw;

    public Ellipse(int x, int y, int w, int h, Color colorFill, Color colorDraw) {
        super(x, y, w, h, colorFill);
        this.colorDraw = colorDraw;
    }
    
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(colorFill);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));

        g2d.setColor(colorDraw);
        g2d.fillOval(this.x,this.y, this.w,this.w);
    }
    
}