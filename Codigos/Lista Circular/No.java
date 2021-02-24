
public class No <T extends Comparable<T>>{

	No prior;
	No next;
	T data;	
	
	public No(T data) {
		this.data = data;
	}
	public No(T data, No prior, No next) {
		this.data = data;
		this.prior = prior;
		this.next = next;
	}
	
	public No<T> obterAnterior() {
		return prior;
	}
	public void inserirAnterior(No prior) {
		this.prior = prior;
	}
	public No<T> obterProximo() {
		return next;
	}
	public void inserirProximo(No next) {
		this.next = next;
	}
	public T obterValor() {
		return data;
	}
	public void inseriValor(T data) {
		this.data = data;
	}
	public String toString() {
		return this.data.toString();
	}
}

