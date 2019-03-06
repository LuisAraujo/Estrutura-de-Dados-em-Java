import java.util.ArrayList;

/**
 * 
 * @author luis araujo
 * Implementação de uma pilha baseada em vetor genérico
 * @param <T> Tipo do array
 */
public class PilhaV<T> {

	/**
	 * Array da Pilha 
	 */
	private T[] arrayPilha;
	/**
	 * Atributo para armazenar o indice do topo da pilha
	 */
    private int topo;
    
    /**
     * Contrutor da Pilha
     * @param max Tamanho da pilha
     */
	public PilhaV(int max){
		//instanciando um vetor genérico (cria um vetor do tipo Objetc e faz o cast (conversão) para o tipo T
		arrayPilha = (T[]) new Object[max];
		topo = -1;
	}
	
	/**
	 * Insere um elemento se a pilha não estiver cheia
	 * @param elemento Elemento a ser inserido na pilha
	 * @return retora true se a operação foi bem sucedida
	 */
	public boolean inserir(T elemento) {		

		if(!this.estaCheia()) {
			topo++;
			arrayPilha[topo] = elemento;
			return true;
		}
	    
		return false;
	}

	/**
	 * Remove um elemento da pilha, se ela não esiver vazia
	 * @return retorna o elemento se a operação foi bem sucedida
	 */
	public T remover() {		
		
		
		if(!this.estaVazia()) {			
			return arrayPilha[topo--];
			
		}
		
		return null;

	}
	
	/**
	 * Verifica se a pilha está vazia
	 * @return retorna true se a pilha estiver vazia
	 */
	public boolean estaVazia() {		
	    return topo == -1;
	}
	
	/**
	 * Verifica se a pilha está cheia
	 * @return retorna true se a pilha estiver cheia
	 */
	public boolean estaCheia() {		
	    return topo == arrayPilha.length-1;

	}

	
	
	
}
