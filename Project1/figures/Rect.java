package figures;

import java.awt.*;

public class Rect extends Figure {
    public Color colorDraw; 

    
    public Rect(int x, int y, int w, int h, Color colorFill, Color colorDraw) {
        super(x, y, w, h, colorFill);
        this.colorDraw = colorDraw;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(colorFill);
        g2d.drawRect(this.x,this.y,this.w,this.h);
        
        g2d.setColor(colorDraw);
        g2d.fillRect(this.x,this.y,this.w,this.h);
    }
}