package figures;

import java.awt.*;

public class Poligono extends Figure {
	private Polygon p = new Polygon();
    public Color colorDraw;
	public Poligono(int x, int y, int w, int h, Color colorFill, Color colorDraw) {
		super(x, y, w, h, colorFill);
        
        this.colorDraw = colorDraw;
        
        p.npoints = 3;
        p.xpoints[0] = (int) (x + w/2);
        p.xpoints[1] = x + w;
        p.xpoints[2] = (int) (x + w*0.75);
        
        p.ypoints[0] = y;
        p.ypoints[1] = (int) (y + h*0.40);
        p.ypoints[2] = y+h;
    }

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(colorDraw);
        g2d.drawPolygon(p.xpoints, p.ypoints, p.npoints);
        g2d.setColor(colorFill);
        g2d.fillPolygon(p.xpoints, p.ypoints, p.npoints);
	}

}