/**
 * @author luis araujo
 * Implementação de no da lista simplemeste encadeada.
 * @param <T> Tipo do valor
 */
public class No<T extends Comparable<T>> {
	
	private T valor;
	private No proximo;
	
	public No(T valor) {
		this.valor = valor;
		proximo = null;
	}
	
	/**obtém o próximo nó */
	public No<T> obterProximo() {
		return this.proximo;
	}
	/**inserir o próximo nó */
	public void inserirProximo(No proximo) {
		this.proximo = proximo;
	}
	/**inserir o valor no nó */
	public void inserirValor(T valor) {
		this.valor= valor;
	}
	/**obter o valor do nó */
	public T obterValor() {
		return this.valor;
	}
	
	//métod toString para exibir o nó
	public String toString() {
		return this.valor.toString();
	}
	
}
