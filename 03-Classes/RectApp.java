public class RectApp { 
    public static void main (String[] args) { 
        Rect r1 = new Rect(20,10, 10,10,10,15);  
        r1.print();
     }
} 

class Rect { 
     int x, y; 
     int w, h;
     int dx, dy;
     Rect (int x, int y, int w, int h, int dx, int dy) { 
         this.x = x;
         this.y = y;
         this.w = w;
         this.h = h;
         this.dx = dx;
         this.dy = dy;
     }

    public int area (int w, int h) {
        this.w = w;
        this.h = h;

        if (w < 0 && h < 0) {
            return 1;
        } 
        else {    
            return w * h;   
        }
    }

    public void drag (int dx, int dy) {
        this.dx =dx;
        this.dy =dy;
    }

    void print () {
        if (area(this.w, this.h) == 1) {
            System.out.format("Valores incorretos, insira novos valores.\n");
        }

        if (this.x < 0 || this.y < 0)  {
            System.out.format("Não são aceitos valores negativos, insira novos valores.\n");
        }

        if (this.dx < 0 || this.dy < 0)  {
            System.out.format("Não são aceitos valores negativos, insira novos valores.\n");
        }
            
        else {
            System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d). O valor da área é:(%d)\n", 
            this.w, this.h, this.x, this.y, area(this.w, this.h));

            System.out.format("O retângulo se moveu para os pontos (%d, %d)\n", this.dx+x, this.dy+y);
        }

       }
}