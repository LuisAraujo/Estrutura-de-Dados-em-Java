
public class ArvoreABB {
	No raiz;
	
	public ArvoreABB() {
		this.raiz = null;
	}
	
	public No buscar(int valor) {
		No n = new No(valor);
		return buscar(n, raiz);
		
	}
	
	public No buscar(No no, No pai) {
		
		if(pai == null) {
			return null;
		}else {
			//menor
			if( no.valor == pai.valor) {
				return no;
			}else if(no.valor < pai.valor) {
				return buscar(no, pai.esquerdo);
			}else {
				return  buscar(no, pai.direito);
			}
		}
	
	}
	
	
	public No inserir(int valor) {
		No n = new No(valor);
		return inserir(n, null);
		
	}
	
	public No inserir(No novo, No pai) {
		
		if(pai == null)
			pai = raiz;
		
		if(raiz == null) {
			raiz = novo;
		}else {
			//menor
			if( novo.valor < pai.valor) {
				
				if(pai.obterNoEsquerdo() == null)
					pai.inserirEsquerdo(novo);
				else
					inserir(novo, pai.obterNoEsquerdo());
				
			}else {
				
				if(pai.obterNoDireito() == null)
					pai.inserirDireito(novo);
				else
					inserir(novo, pai.obterNoDireito());
			}
		}
		
		return novo;
		
	}
	

	public No removerNo(int valor) {
		return removerNo(valor, null);
	}
	
	public No removerNo(int valor, No currentno) {
		
		No noret = null;
		
		if(currentno == null) 
			currentno = raiz;
		
		//igual
		if(currentno.valor == valor) {
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
			
			
			
		}else if( currentno.valor < valor) {
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
	
	
	  public void preorder(No no) {
		  	if (no == null) {
	            return;
	        }
		  	
	        System.out.println("Valor: "+no.valor);
	        preorder(no.esquerdo);
	        preorder(no.direito);
	    }
	
}
