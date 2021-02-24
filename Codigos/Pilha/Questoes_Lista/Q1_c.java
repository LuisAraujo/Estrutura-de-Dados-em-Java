
public class Q1_c {
	
	/*
	 * 1 – [Simples] Use as operações push, pop, stacktop e empty para construir operações que façam o seguinte:
       c. Dado um inteiro n, definir i como o enésimo elemento a partir do topo da pilha, deixando a pilha sem seus n elementos superiores.

	 */
	public static void main(String[] args) {
		PilhaV<Integer> p = new PilhaV<Integer>(10);

		int numero = 0;
		int n = 5;
		 
		while(p.inserir(numero++)) {}
				
		int i = 100;
		//se o i tem que ser o segundo elemento a partir do topo, eu tenho que remover
		//três elementos
		
		//removendo o topo e n elementos a partir dele
		for(int j=0; j<=n; j++ )
			p.remover();
		
		//inserindo i no lugar do enésimo elemento a partir do topo
		p.inserir(i);				
		
	
	}
}


