/**
 * @author luis araujo
 * Testando os métodos da Lista
 */
public class Main {

	public static void main(String[] args) {
		
		Lista lista = new Lista<Integer>();
		
		for(int i= 1; i< 10; i++) {
			if(i != 5)
				lista.inserir(i);
		}
		
		lista.inserir(10);
		
		/** exibindo a lista completa **/
		//1 - 2 - 3 - 4 - 6 - 7 - 8 - 9 - 10
		System.out.println(lista);
		
		lista.inserir(5);
		
		/** exibindo a lista com o número 5 **/
		//1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10
		System.out.println(lista);
		
		lista.inserir(0);
		
		/** exibindo a lista com o número 0 **/
		//0 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10
		System.out.println(lista);	
		
		lista.remover(1);
		
		/** exibindo a lista sem o número 1 **/
		//0 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10
		System.out.println(lista);
		
		lista.remover(9);
		
		/** exibindo a lista sem o número 9**/
		//0 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 10
		System.out.println(lista);
			
		lista.remover(0);
		
		/** exibindo a lista sem o número 0**/
		//2 - 3 - 4 - 5 - 6 - 7 - 8 - 10
		System.out.println(lista);
		
		
		lista.inserirFinal(0);
		//2 - 3 - 4 - 5 - 6 - 7 - 8 - 10 - 0
		System.out.println(lista);
		
		
		lista.removerInicio();
		//3 - 4 - 5 - 6 - 7 - 8 - 10 - 0
		System.out.println(lista);
		
		lista.removerFinal();
		//2 - 3 - 4 - 5 - 6 - 7 - 8 - 10
		System.out.println(lista);
		
		
		lista.inserirInicio(0);
		//0 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 10
		System.out.println(lista);
		
		
		/** buscando na lista**/
		No achado = lista.buscar(10);
		System.out.println(achado);
			
		/** buscando um valor que não existe na lista**/
		achado = lista.buscar(1);
		System.out.println(achado);

	}

}
