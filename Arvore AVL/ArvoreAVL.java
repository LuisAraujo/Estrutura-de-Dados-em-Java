
public class ArvoreAVL<T extends Comparable<T>> {
	No raiz;
	
	public ArvoreAVL() {
		this.raiz = null;
	}
	
	public No inserirNo(T valor) {
		System.out.println("\n*** inserindo "+valor);
		No<T> n = new No<T>(valor);
		inserirNo(n, null);
		return n;
	}
	
	private No inserirNo(No novo, No pai) {
		
		No inserido = null;
		
		if(pai == null)
			pai = raiz;

		if(raiz == null) {
			
			raiz = novo;
			
			novo.setAltura ( 1 + UtilAVL.max( novo.getAlturaFilhoEsquerdo(), 
					novo.getAlturaFilhoDireito()) );
			
		}else {
			
			//menor
			if( novo.obterValor().compareTo(pai.obterValor()) == -1) {
				
				if(pai.obterNoEsquerdo() == null)
					inserido = pai.inserirEsquerdo(novo);
				else
					inserido = inserirNo(novo, pai.obterNoEsquerdo());
				
			}else {
				
				if(pai.obterNoDireito() == null)
					inserido = pai.inserirDireito(novo);
				else
					inserido = inserirNo(novo, pai.obterNoDireito());
			}
		}
		
		preOrder(raiz);
		
		if( pai != null) {
			pai.setAltura ( 1 + UtilAVL.max( pai.getAlturaFilhoEsquerdo(), 
				pai.getAlturaFilhoDireito()) );
		
			 int fb = pai.setFatordeBalanceamento();
			
			 //Direita
			 if( fb > 1) {
				 if((int)novo.valor > (int)inserido.esquerdo.valor)
					 rotacaoDireita(pai); 
				 else
					 rotacaoEsquerdaDireita(pai);
				 
			 //Esquerda 
			 } else if (fb < -1)  {
				 if((int)novo.valor < (int)inserido.direito.valor)
					 rotacaoEsquerda(pai); 
				 else
					 rotacaoDireitaEsquerda(pai);
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
	
	
	void preOrder(No no)  
	{  
	    if(no != null)  
	    {  
	    	if(no == raiz)
	    		System.out.println("\nRaiz: "+no);
	    	else
	    		System.out.println("No: " + no);  
	        
	        if(no == raiz)
	        	System.out.println("sub-arvore esquerda"); 
	        preOrder(no.esquerdo);  
	        
	        if(no == raiz)
	        	System.out.println("sub-arvore direita"); 
	        preOrder(no.direito);  
	    }  
	    
	 
	}  

	public void rotacaoDireita(No antigo_no_pai) {
		
		System.out.println("Balanceando... RR"+ antigo_no_pai.valor);
		
		
		//novo no pai será o no a esquerda
		No novo_no_pai = antigo_no_pai.esquerdo;
		
		antigo_no_pai.esquerdo = novo_no_pai.direito; 
		
		//novo no pai será pai do antigo (à direita)
		novo_no_pai.direito = antigo_no_pai;
		
		if(antigo_no_pai==raiz) {
			raiz = novo_no_pai;
			raiz.pai = null;
			
		}else if(antigo_no_pai.pai != null) {
			
			novo_no_pai.pai = antigo_no_pai.pai;
			
			if(antigo_no_pai.pai.direito == antigo_no_pai) {
				antigo_no_pai.pai.direito = novo_no_pai;
			}else {
				antigo_no_pai.pai.esquerdo = novo_no_pai;
			}
		}
		
		antigo_no_pai.pai = novo_no_pai;
		
		//Atualizando a altura e o fator de balanceamento dos nós modificados
		antigo_no_pai.setAltura ( 1 + UtilAVL.max( antigo_no_pai.getAlturaFilhoEsquerdo(), 
				antigo_no_pai.getAlturaFilhoDireito()) );
		
		antigo_no_pai.setFatordeBalanceamento();
		
		novo_no_pai.setAltura ( 1 + UtilAVL.max( novo_no_pai.getAlturaFilhoEsquerdo(), 
				novo_no_pai.getAlturaFilhoDireito()) );
		
		novo_no_pai.setFatordeBalanceamento();
		
		preOrder(raiz);
	}
	
	public void rotacaoEsquerda(No antigo_no_pai) {
		
		System.out.println("Balanceando... LL" + antigo_no_pai.valor);
		
		
		//novo no pai será o no a esquerda
		No novo_no_pai = antigo_no_pai.direito;
		
		
		
		antigo_no_pai.direito = novo_no_pai.esquerdo; 
		
		//novo no pai será pai do antigo (à direita)
		novo_no_pai.esquerdo = antigo_no_pai;
		
		if(antigo_no_pai==raiz) {
			raiz = novo_no_pai;
			raiz.pai = null;	
		}else if(antigo_no_pai.pai != null) {
			
			novo_no_pai.pai = antigo_no_pai.pai;
			
			if(antigo_no_pai.pai.direito == antigo_no_pai) {
				antigo_no_pai.pai.direito = novo_no_pai;
			}else {
				antigo_no_pai.pai.esquerdo = novo_no_pai;
			}
		}
		
		antigo_no_pai.pai = novo_no_pai;
		
		//Atualizando a altura e o fator de balanceamento dos nós modificados
		antigo_no_pai.setAltura ( 1 + UtilAVL.max( antigo_no_pai.getAlturaFilhoEsquerdo(), 
				antigo_no_pai.getAlturaFilhoDireito()) );
		
		antigo_no_pai.setFatordeBalanceamento();
		
		novo_no_pai.setAltura ( 1 + UtilAVL.max( novo_no_pai.getAlturaFilhoEsquerdo(), 
				novo_no_pai.getAlturaFilhoDireito()) );
		
		novo_no_pai.setFatordeBalanceamento();
		
		preOrder(raiz);
	}
	
	public void rotacaoEsquerdaDireita(No antigo_no_pai) {
			System.out.println("rotacaoEsquerdaDireita");
	}
	
	public void rotacaoDireitaEsquerda(No antigo_no_pai) {
		System.out.println("rotacaoDireitaEsquerda");
	}
	
}
