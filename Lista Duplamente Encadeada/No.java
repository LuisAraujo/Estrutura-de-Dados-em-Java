public class No<T extends Comparable<T>> {
	
	private T valor;
	private No proximo;
        private No anterior;
	
	public No(T valor) {
		this.valor = valor;
		proximo = null;
                
	}
	
	/**obtém o próximo nó */
	public No<T> obterProximo() {
		return this.proximo;
	}
        
        public No<T> obterAnterior() {
		return this.anterior;
	}
	/**inserir o próximo nó */
	public void inserirProximo(No proximo) {
		this.proximo = proximo;
	}
        
        public void inserirAnterior(No anterior) {
		this.anterior = anterior;
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