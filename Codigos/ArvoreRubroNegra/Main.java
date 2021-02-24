import java.util.Random;

/* Class AVL Tree Test */
 public class Main
 {
     public static void main(String[] args)
    {            
    	Random gerador = new Random();
        ArvoreRB avrb = new ArvoreRB(); 
 
        for(int i = 0; i < 50; i++) {
        	int n = gerador.nextInt(100);
        	avrb.inserir( n );
        }
        
       
        //RBNo a = avrb.buscar(35);
        //System.out.println(a);
        
     
    }
 }