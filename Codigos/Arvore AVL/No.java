
public class No<T extends Comparable<T>> {
	
	No esquerdo;
	No direito;
	T valor;
	int balanceamento;
	No pai;
	int altura;
	int fatorb;
	
	public No(T valor) {
		this.valor = valor;
		this.altura = 0;
	}
	
	public No(T valor, No pai) {
		this.valor = valor;
		this.pai = pai;
		this.altura = 0;
	}
	
	
	public void inserirValor(T valor) {
		this.valor = valor;
	}
	
	public T obterValor() {
		return this.valor;
	}
	
	
	public No inserirEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
		if(esquerdo != null)
			esquerdo.pai = this;
		
		return esquerdo;
	}
	
	public No inserirDireito(No direito) {
		this.direito = direito;
		if(direito != null)
			direito.pai = this;
		
		return direito;
	}
	
	public No obterNoEsquerdo() {
		return this.esquerdo;
	}
	
	public No obterNoDireito() {
		return this.direito;
	}
	
	public String toString() {
		return this.valor.toString() + " | h: "+this.altura + " fb: "+this.fatorb + " pai: "+this.pai;
	}
	
	public void inseriPai(No pai) {
		this.pai = pai;
	}
	
	public No obterPai() {
		return this.pai;
	}
	
	public int getAltura() {
		return this.altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public int setFatordeBalanceamento() {
		this.fatorb = getAlturaFilhoEsquerdo() - getAlturaFilhoDireito();
		//System.out.println(this.esquerdo);
		//System.out.println(valor+" -> fb = "+getAlturaFilhoEsquerdo()+" - "+getAlturaFilhoDireito()+" = "+this.fatorb );
		
	   return this.fatorb;
	}

	public int getAlturaFilhoEsquerdo() {
		if(this.esquerdo!=null)
			return this.esquerdo.getAltura();
		
		return -1;
	}

	public int getAlturaFilhoDireito() {
		if(this.direito != null)
			return this.direito.getAltura();
		
		return -1;
	}
	
	
	
}
