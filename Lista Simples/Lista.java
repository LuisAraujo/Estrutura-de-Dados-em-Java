/**
 * @author luis araujo
 * Implementação de uma lista simplemeste encadeada.
 * @param <T> Tipo do valor
 */
public class Lista<T extends Comparable<T>> {
	
	/*O atributo primeiro guarda a referência do primeiro nó. Através dele podemos chegar a todos
	 * os nós, sempre pulando para o próximo. */
	private No<T> primeiro;
	
	public void inserirInicio(T  valor) {
		
		//Cria um novo nó com o valor passado
		No<T> novo_no = new No<T>(valor);
		novo_no.inserirProximo(primeiro);
		primeiro = novo_no;
	
	}
	
	public void inserirFinal(T  valor) {
		
		//Cria um novo nó com o valor passado
		No<T> novo_no = new No<T>(valor);
		//No auxiliar fica no inicio
		No<T> aux = primeiro;
		//se a lista estiver vazia
		if(aux == null){
			primeiro = novo_no;
	    //senão
		}else{
			//vou até o final da lista
			while(aux.obterProximo() != null){	
				aux = aux.obterProximo();
			}
			
			aux.inserirProximo(novo_no);
		}
	
	}
	
	
	/**Inserindo um nó em ordem, passando o valor*/
	public void inserir(T  valor) {
		//Cria um novo nó com o valor passado
		No<T> novo_no = new No<T>(valor);
		
		/*Precisamos de dois nós auxiliares, um para que possamos ligar o novo nó ao seu proximo 
		 * (vou chamar ele de P)e outro para conectar o nó anterior à P ao novo nó*/
		No<T> auxiliar = primeiro;
		No<T> auxiliar2 = null;
		
		/*Até que você encontre o local correto para nó ser inserido em ordem crescente
		 *vá para o próximo nó. Devemos verificar aqui se já chegou ao final da lista:
		 auxilia != null
		 */
		while((auxiliar != null) && ( auxiliar.obterValor().compareTo( novo_no.obterValor() )) == -1  )
		{
			//auxiliar2 guarda o valor de auxiliar, antes dele pular para o próximo
			auxiliar2 = auxiliar;
			//pula para o próximo
			auxiliar = auxiliar.obterProximo();
		}
		
		//é o primeiro nó
		if(this.primeiro == null) { 
			this.primeiro = novo_no;
			
		//o nó deve ficar antes do primeiro (é menor que ele)
		}else if(auxiliar == this.primeiro) {
			
			novo_no.inserirProximo(this.primeiro);
			this.primeiro = novo_no;
			
		//o nó deve ficar após o primeiro
		}else {
			//liga o novo no ao P
			novo_no.inserirProximo(auxiliar);
			//liga o nó anteror à P ao novo nó
			auxiliar2.inserirProximo(novo_no);	
		}
	
	}
	
	/**Remove um nó no inicio*/
	public No<T> removerInicio() {
		No<T> aux = primeiro;
		primeiro = primeiro.obterProximo();
		return aux;
	}
	
	/**Remove um nó no final*/
	public No<T> removerFinal() {
		No<T> aux = primeiro;
		if(aux == null){
			System.out.println("Lista vazia");
			return null;
	    //senão
		}else{
			//vou até o final da lista
			while(aux.obterProximo().obterProximo() != null){	
				aux = aux.obterProximo();
			}
			No<T> aux2 = aux.obterProximo();
			aux.inserirProximo(null);
			
			return aux2;
		}
	}
	
	
	
	/**Remove um nó, passando o valor*/
	public No<T> remover(T valor) {
		
		/*Precisamos de dois nós auxiliares, um para que possamos ligar o novo nó ao seu proximo 
		 * (vou chamar ele de P)e outro para conectar o nó anterior à P ao novo nó*/
		No<T> auxiliar = primeiro;
		No<T> auxiliar2 = null;
		
		/*Até que você encontre o local correto para nó ser removido vá para o próximo nó. 
		 Devemos verificar aqui se já chegou ao final da lista: auxiliar != null
		 */
		while((auxiliar != null) && (auxiliar.obterValor().compareTo( valor )) != 0  )
		{
			//auxiliar2 guarda o valor de auxiliar, antes dele pular para o próximo
			auxiliar2 = auxiliar;
			//pula para o próximo
			auxiliar = auxiliar.obterProximo();
		}
		
		//se o nó a ser removido for o primeiro
		if(auxiliar == this.primeiro) {
			
			No retorno = this.primeiro;
			this.primeiro = this.primeiro.obterProximo();
			return retorno;
		
		//remove o nó da lista, ligando o nó anterior ao próximo do nó achado
		}else if(auxiliar != null)
			auxiliar2.inserirProximo(auxiliar.obterProximo());
	
		//retorna o nó (null ou o nó achado)
		return auxiliar;
		
	}
	
	/**Buscar um nó, passando o valor*/
	public No<T> buscar(T valor) {
		/*Precisamos de apenas um nós auxiliar para chegar até o nó desejado*/
		No<T> auxiliar = primeiro;
		 
		
		/*Até que você encontre o nó vá para o próximo nó. Devemos verificar aqui se já chegou ao final da lista:
		 auxilia != null*/
		while((auxiliar != null) && (auxiliar.obterValor().compareTo( valor )) != 0  )
		{
			//pula para o próximo
			auxiliar = auxiliar.obterProximo();
		}
		
	
		//retorna o nó (null ou o nó achado)
		return auxiliar;
	}
	
	//método toString para exibir a lista
	public String toString() {
		String s = "";
		No<T> auxiliar = primeiro;
		
		while(auxiliar != null)
		{
			//incrementa o valor
			s+= auxiliar.obterValor().toString() + " - ";
			//pula para o próximo
			auxiliar = auxiliar.obterProximo();
		}
		
		return s;
	} 
	
}
