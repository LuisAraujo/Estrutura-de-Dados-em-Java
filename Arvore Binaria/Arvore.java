
public class Arvore<T extends Comparable<T>> {
	No raiz;
	
	public Arvore() {
		this.raiz = null;
	}
	
	public No inserirNo(T valor) {
		No<T> n = new No<T>(valor);
		return inserirNo(n, null);
		
	}
	public No inserirNo(No novo, No pai) {
		
		if(pai == null)
			pai = raiz;
		
		if(raiz == null) {
			raiz = novo;
		}else {
			//menor
			if( novo.obterValor().compareTo(pai.obterValor()) == -1) {
				
				if(pai.obterNoEsquerdo() == null)
					pai.inserirEsquerdo(novo);
				else
					inserirNo(novo, pai.obterNoEsquerdo());
				
			}else {
				
				if(pai.obterNoDireito() == null)
					pai.inserirDireito(novo);
				else
					inserirNo(novo, pai.obterNoDireito());
			}
		}
		
		return novo;
		
	}
	

	public No removerNo(T valor) {
		return removerNo(valor, null);
	}
	
	public No removerNo(T valor, No currentno) {
		
		No noret = null;
		
		if(currentno == null) 
			currentno = raiz;
		
		//igual
		if(currentno.obterValor().compareTo(valor) == 0) {
			//System.out.println(currentno.obterValor() + "é igual");
			//é um nó folha?
			if((currentno.obterNoDireito()== null) && (currentno.obterNoEsquerdo() == null)) {
				
				if(currentno == this.raiz)
					this.raiz = null;
				
				else if(currentno == currentno.pai.obterNoDireito() )
					currentno.pai.inserirDireito(null);
				else 
					currentno.pai.inserirEsquerdo(null);
			
			//tem apena sum filho à direita?
			}else if (currentno.obterNoDireito() == null){
				
				if(currentno == this.raiz)
					this.raiz = this.raiz.obterNoEsquerdo();
				
				else if(currentno == currentno.pai.obterNoDireito() )
					currentno.pai.inserirDireito( currentno.obterNoEsquerdo() );
				
				else 
					currentno.pai.inserirEsquerdo( currentno.obterNoEsquerdo() );
			
			//tem apena sum filho à esquerda?
			}else if (currentno.obterNoEsquerdo()== null){
				
				if(currentno == this.raiz)
					this.raiz = this.raiz.obterNoDireito();
				
				else if(currentno == currentno.pai.obterNoDireito() )
					currentno.pai.inserirDireito( currentno.obterNoDireito() );
				
				else 
					currentno.pai.inserirEsquerdo( currentno.obterNoDireito() );
			
			//tem dois filhos	
			}else {
				
				No sucessor = this.getSucessor(currentno, true);
				System.out.println("O sucessor é:" + sucessor+"\n");
				
				if(sucessor != currentno.obterNoDireito()) {
					
					sucessor.pai.inserirEsquerdo( sucessor.obterNoDireito() );
					sucessor.inserirDireito( currentno.obterNoDireito() );
				}
				
				
				//é a raiz
				if(currentno == this.raiz )
				   raiz = sucessor;
				
				//é o filho a esquerda
				else if(currentno == currentno.pai.obterNoDireito()) 
						currentno.pai.inserirDireito(sucessor);
				else 
						currentno.pai.inserirEsquerdo(sucessor);
			
				sucessor.inserirEsquerdo( currentno.obterNoEsquerdo() );
				
			}
			
			
			
		}else if( currentno.obterValor().compareTo(valor) == -1) {
			//System.out.println(currentno.obterValor() + "é menor que "+valor);
			removerNo(valor, currentno.obterNoDireito());
		}else {
			//System.out.println(currentno.obterValor() + "é mairo que "+valor);
			removerNo(valor, currentno.obterNoEsquerdo());
			
		}
	
		
		return null;
	}
	
	
	public No getSucessor(No atual, Boolean primeiraVez) {
		
		No sucessor  = null;
		
		if(primeiraVez)
			sucessor = atual.obterNoDireito();
		else
			sucessor = atual;
		
		if(sucessor.obterNoEsquerdo()!=null) {
			return getSucessor(sucessor.obterNoEsquerdo(), false);
		}
		    
		return sucessor; 
	}
	
}
