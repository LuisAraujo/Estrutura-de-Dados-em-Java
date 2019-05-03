
public class No<T extends Comparable<T>> {
	
	No esquerdo;
	No direito;
	T valor;
	No pai;
	
	public No(T valor) {
		this.valor = valor;
	}
	
	public No(T valor, No pai) {
		this.valor = valor;
		this.pai = pai;
	}
	
	
	public void inserirValor(T valor) {
		this.valor = valor;
	}
	
	public T obterValor() {
		return this.valor;
	}
	
	
	public void inserirEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
		if(esquerdo != null)
		esquerdo.pai = this;
	}
	
	public void inserirDireito(No direito) {
		this.direito = direito;
		if(direito != null)
		direito.pai = this;
	}
	
	public No obterNoEsquerdo() {
		return this.esquerdo;
	}
	
	public No obterNoDireito() {
		return this.direito;
	}
	
	public String toString() {
		return this.valor.toString();
	}
	
	public void inseriPai(No pai) {
		this.pai = pai;
	}
	
	public No obterPai() {
		return this.pai;
	}

	
	
	
}
