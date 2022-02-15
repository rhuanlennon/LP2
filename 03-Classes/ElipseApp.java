public class ElipseApp{
    public static void main (String[] args){
        Elipse e1 = new Elipse(50, 50, 150, 150, 100.5);
        e1.print();
    }
}
class Elipse{
    double l, a, raio;
    int x,y;
    Elipse(double l, double a, int x, int y, double raio){
        this.l = l;
        this.a = a;
        this.x = x;
        this.y = y;
        this.raio = raio;
    }
    void print(){
        System.out.format("Elipse de largura (%.1f) e altura (%.1f), nas posicões (%d, %d), com raio de (%.1fπr)\n",
        this.l, this.a, this.x, this.y, this.raio);
    }
}
