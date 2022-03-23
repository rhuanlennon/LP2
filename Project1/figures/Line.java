package figures;

import java.awt.*;

public class Line extends Figure {
    
    public Line(int x, int y, int w, int h) {
        super(x, y, w, h);
    }
    
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(this.x, this.y, this.x+w, this.y+h);
    }
}