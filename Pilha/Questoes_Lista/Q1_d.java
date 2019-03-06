
public class Q1_d {
	
	/*
	 * 1 – [Simples] Use as operações push, pop, stacktop e empty para construir operações que façam o seguinte:
       d. Dado um inteiro n, definir i como o enésimo elemento a partir do topo da pilha, deixando a pilha inalterada.

	 */
	public static void main(String[] args) {
		PilhaV<Integer> p = new PilhaV<Integer>(10);
		PilhaV<Integer> p_aux = new PilhaV<Integer>(10);

		int numero = 0;
		int n = 5;
		 
		while(p.inserir(numero++)) {}
				
		int i = 100;
		//se o i tem que ser o segundo elemento a partir do topo, eu tenho que remover
		//três elementos
		
		//removendo o topo e n elementos a partir dele (e salvando)
		for(int j=0; j<=n; j++ ) {
		    int elem = p.remover();
		    //não preciso salvar o último
		    if(n!=j)
		    	p_aux.inserir(elem);
		}
		
		//inserindo i no lugar do enésimo elemento a partir do topo
		p.inserir(i);	
		
		while(p.inserir(p_aux.remover())) {}
	
	
	}



}
