
public class Main {

	public static void main(String[] args) {
		
		//Criando a pilha
		PilhaV<Integer> p = new PilhaV<Integer>(10);
		Integer numero = 0;
		
		//Preenchendo a pilha até ela ficar cheia
		while(p.inserir(numero) ){
			System.out.println("Inserido "+ numero +"\n");	
			numero++;
		}
		
		System.out.println("-------------------------");
		
		//Removendo da pilha até ela ficar vazia
		numero = p.remover();
		while(numero != null){
			System.out.println("Removendo "+ numero +"\n");		
			numero = p.remover();
		}
		
		System.out.println("-------------------------");
			
	}

}
