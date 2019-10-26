public class ListaDuplamente< T extends Comparable<T>> {
    
    
	No<T> primeiro;
    No<T> no_atual = primeiro;
	
	public void inserirFrente(T valor){
		No<T> novo_no = new No<T>(valor);
		if(this.primeiro == null) { 
			this.primeiro = novo_no;
		}else{
			novo.proximo = inicio;
			this.primeiro.anterior = novo_no;
			this.primeiro = novo_no;
		}
	}
	
	public void inserirFinal(T valor){
		No<T> novo_no = new No<T>(valor);
		
		if(this.primeiro == null) { 
			this.primeiro = novo_no;
		}else{
			No aux = inicio;
			while( aux.proximo != null)
				aux = aux.proximo;
			
			novo.anterior = aux;
			aux.proximo = novo_no;
		}
	}

	public void inserir(T  valor) {
		No<T> novo_no = new No<T>(valor);
		No<T> auxiliar = primeiro;
		
		if(this.primeiro == null) { 
			this.primeiro = novo_no;
		
		}else{
		
			while((auxiliar.obterProximo() != null) && 
			( auxiliar.obterValor().compareTo( novo_no.obterValor() ) == -1 ) )
			{
				auxiliar = auxiliar.obterProximo();
			}
			
			if(auxiliar == this.primeiro) {
				
				if(this.primeiro.obterValor().compareTo( novo_no.obterValor() ) == -1 ) {
					
					this.primeiro.inserirProximo(novo_no);
					novo_no.inserirAnterior(this.primeiro);

				}else {
					
					novo_no.inserirProximo(this.primeiro);
					this.primeiro.inserirAnterior(novo_no);
					this.primeiro = novo_no;
				}
				
			}else {
				
				if(auxiliar.obterProximo() == null) {
					novo_no.inserirAnterior(auxiliar);
					auxiliar.inserirProximo(novo_no);
				}else {
				novo_no.inserirProximo(auxiliar);
				novo_no.inserirAnterior(auxiliar.obterAnterior());
	            auxiliar.obterAnterior().inserirProximo(novo_no);
	            auxiliar.inserirAnterior(novo_no);
				}
			}
			
		}
	
	}
       
	public No removerFrente(){
		No<T> aux = this.primeiro;
		this.primeiro = this.primeiro.proximo;
		aux.proximo = null;
		return aux.
	}
	
	public No removerFinal(){
	
		if(this.primeiro == null) { 
			return null;
		}else{
			No aux = inicio;
			while( aux.proximo != null)
				aux = aux.proximo;
			
			aux.anterior.proximo = null;
			aux.anterior = null;
			
			return aux;
		
		}
	
	
	}
       
	public No<T> remover(T valor) {//arrumada 
		
		No<T> auxiliar = primeiro;
		
                No<T> retorno =null;

		while((auxiliar != null) && (auxiliar.obterValor().compareTo( valor ) != 0)  )
		{
			auxiliar = auxiliar.obterProximo();
		}
		
		
		if(auxiliar == this.primeiro) {
			
			retorno = this.primeiro;
                        retorno.inserirProximo(null);
			this.primeiro = this.primeiro.obterProximo();
                        this.primeiro.inserirAnterior(null);
			
		
		}else if(auxiliar != null)
			auxiliar.obterAnterior().inserirProximo(auxiliar.obterProximo());
                auxiliar.obterProximo().inserirAnterior(auxiliar.obterAnterior());
                auxiliar.inserirProximo(null);
                auxiliar.inserirAnterior(null);
	
		
		return retorno;
		
	}
	
	
	public No<T> buscar(T valor) {
		
			
		if(no_atual== null)
			no_atual = primeiro;
		
		while((no_atual != null) && (no_atual.obterValor().compareTo( valor )) != 0  )
		{
			if (no_atual.obterValor().compareTo(valor)==-1){
                no_atual = no_atual.obterProximo();
            }
            else 
                no_atual=no_atual.obterAnterior();
	
			
		}
		
	
		
		return no_atual;
	}
	
	
	public String buscarCount(T valor) {
		
		int count = 0;
		
		if(no_atual== null)
			no_atual = primeiro;
		
		while((no_atual != null) && (no_atual.obterValor().compareTo( valor )) != 0  )
		{
			count++;
            if (no_atual.obterValor().compareTo(valor)==-1){
                no_atual = no_atual.obterProximo();
            }
            else 
                no_atual=no_atual.obterAnterior();
		}
		
		
		return "Achou "+no_atual.obterValor()+" com "+count + " passos";
	}
	

	public String toString() {
		String s = "";
		No<T> auxiliar = primeiro;
		
		while(auxiliar != null)
		{
			
			s+= auxiliar.obterValor().toString() + " - ";

			auxiliar = auxiliar.obterProximo();
		}
		
		return s;
	} 
	
}