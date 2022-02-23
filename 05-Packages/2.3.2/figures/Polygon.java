package figures;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Polygon {
    private int[] xPoints; 
    private int[] yPoints;
    private int nPoints;
    private Color PColorFill;
    private Color PColorDraw;
    

    public Polygon(int[] xPoints, int[] yPoints, int nPoints, Color PColorFill, Color PColorDraw) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.nPoints = nPoints;   
        this.PColorFill = PColorFill;
        this.PColorDraw = PColorDraw;
    }

    public void print(){
        System.out.format("Triângulo com os pontos x:(%d,%d, %d), y(%d,%d, %d), na posição (%d, %d)\n", this.xPoints[0], 
            this.xPoints[1], this.xPoints[2], this.yPoints[0], this.yPoints[1], this.yPoints[2]);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(PColorDraw);
        g2d.drawPolygon(this.xPoints, this.yPoints, this.nPoints);
        g2d.setColor(PColorFill);
        g2d.fillPolygon(this.xPoints, this.yPoints, this.nPoints);
    }
}
