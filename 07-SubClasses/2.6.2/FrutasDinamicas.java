class Maca
{ 
    void display() 
    { 
        System.out.println("Maça método principal"); 
    } 
} 
  
class Banana extends Maca 
{ 
    void display()
    { 
        System.out.println("Banana extende da Maça"); 
    } 
} 
  
class Cereja extends Maca 
{ 
    void display()       
    { 
        System.out.println("Cereja extende da Maça"); 
    } 
} 
class FrutasDinamicas
{ 
    public static void main(String args[]) 
    {  
        Maca a  = new Maca();
        Banana b = new Banana(); 
        Cereja c = new Cereja();
  
        Maca ref;
           
        ref = a;
        ref.display();
        
        ref = b;
        ref.display();
  
        ref = c;
        ref.display();  
    } 
} 