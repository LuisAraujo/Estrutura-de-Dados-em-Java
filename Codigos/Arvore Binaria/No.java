
public class No{
	
	No esquerdo;
	No direito;
	int valor;
	No pai;
	
	public No(int valor) {
		this.valor = valor;
	}
	
	public No(int valor, No pai) {
		this.valor = valor;
		this.pai = pai;
	}
	
	
	public void inserirValor(int valor) {
		this.valor = valor;
	}
	
	public int obterValor() {
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
		return Integer.toString(this.valor);
	}
	
	public void inseriPai(No pai) {
		this.pai = pai;
	}
	
	public No obterPai() {
		return this.pai;
	}

	
	
	
}
