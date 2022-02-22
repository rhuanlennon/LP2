package figures;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Polygon {
    private int[] xPoints; 
    private int[] yPoints;
    private int nPoints; 

    public Polygon(int[] xPoints, int[] yPoints, int nPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.nPoints = nPoints;       
    }

    public void print(){
        System.out.format("Triângulo com os pontos x:(%d,%d, %d), y(%d,%d, %d), na posição (%d, %d)\n", this.xPoints[0], 
            this.xPoints[1], this.xPoints[2], this.yPoints[0], this.yPoints[1], this.yPoints[2]);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(this.xPoints, this.yPoints, this.nPoints);  
    }
}
