import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random gerador = new Random();
		ArvoreABB arabb = new ArvoreABB();

		for(int i = 0; i < 50; i++) {
        	int n = gerador.nextInt(100);
        	arabb.inserir( n );
        }
		
		
		arabb.inserir( 1 );
		arabb.inserir( 2 );
		arabb.inserir( 3 );
		arabb.inserir( 4 );
		
	
        No a = arabb.buscar(99);
        System.out.println(a);
        
        arabb.preorder(arabb.raiz);
	}

}
