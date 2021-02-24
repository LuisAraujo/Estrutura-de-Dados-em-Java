
public class Q1_a {
	/*
	 * 1 – [Simples] Use as operações push, pop, stacktop e empty para construir operações que façam o seguinte:
     Definir i com o segundo elemento a partir do topo da pilha, deixando a pilha sem seus dois elementos superiores.

	 */
	public static void main(String[] args) {
		PilhaV<Integer> p = new PilhaV<Integer>(10);
		int numero = 0;
		
		while(p.inserir(numero++)) {}
				
		int i = 100;
		//se o i tem que ser o segundo elemento a partir do topo, eu tenho que remover
		//três elementos
		
		//removendo o topo
		p.remover();
		//removendo o primeiro elemento a partir do do topo
		p.remover();
		//removendo o segundo elemento a partir do topo
		p.remover();
		
		//inserindo i no lugar do segundo elemento a partir do topo
		p.inserir(i);				
		
		//programa termina, pois a pilha fica sem os dois elemento superiores.
	
	}
}
