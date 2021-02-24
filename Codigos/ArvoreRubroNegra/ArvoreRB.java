public class ArvoreRB {
	//cores
    private final Cor VERMELHO = Cor.RED;
    private final Cor PRETO = Cor.BLACK;
    
    //nil é um nó vazio
    static final RBNo nil = new RBNo(-1); 
    
    //raiz da árvore
    private RBNo raiz = nil;
    
    
    
    
    public RBNo buscar(int key) {
    	return buscar(new RBNo(key), raiz);
    }

    private RBNo buscar(RBNo no, RBNo no2) {
        if (raiz == nil) {
            return null;
        }

        if (no.valor < no2.valor) {
            if (no2.esquerdo != nil) {
                return buscar(no, no2.esquerdo);
            }
        } else if (no.valor > no2.valor) {
            if (no2.direito != nil) {
                return buscar(no, no2.direito);
            }
        } else if (no.valor == no2.valor) {
            return no2;
        }
        return null;
    }
    
    public void inserir(int key) {
    	inserir( new RBNo(key, nil) );
    }

    private void inserir(RBNo no) {
    	
    	RBNo temp = raiz;
        //vazia? (Caso 01)
    	if (raiz == nil) {
            raiz = no;
            no.cor = PRETO;
            no.pai = nil;
        
    	} else {
    		//inserindo um no vermelho
            no.cor = VERMELHO;
            
            //poderia ser recursivo também
            while (true) {
            	
            	//operacao igual à ABB
                if (no.valor < temp.valor) {
                	//achei um local
                    if (temp.esquerdo == nil) {
                        temp.esquerdo = no;
                        no.pai = temp;
                        break;
                    //proximo...
                    } else {
                        temp = temp.esquerdo;
                    }
                    
                } else if (no.valor >= temp.valor) {
                    //achei um local
                	if (temp.direito == nil) {
                        temp.direito = no;
                        no.pai = temp;
                        break;
                    //proximo
                    } else {
                        temp = temp.direito;
                    }
                }
            }
            
            //caso ocorra alguma anomalia
            ajustarArvore(no);
        }
    }

    private void ajustarArvore(RBNo no) {
    	
    	//se um nó pai for vermelho de no inserido
        while (no.pai.cor == VERMELHO) {
        	
        	RBNo tio = nil;
        	
        	//pai é um filho esquerdo?
            if (no.pai == no.pai.pai.esquerdo) {
            	//pega o tio
                tio = no.pai.pai.direito;
                
                //Caso 02
                if (tio != nil && tio.cor == VERMELHO) {
                    no.pai.cor = PRETO; //p
                    tio.cor = PRETO; //t
                    no.pai.pai.cor = VERMELHO; //a
                    no = no.pai.pai; 
                    continue;
                } 
                
                //nó é um filho à direita (interno)?
                if (no == no.pai.direito) {
                    
                	//se precisar de rotacao dupla
                    no = no.pai;
                    rotateLL(no);
                } 
                
                
                no.pai.cor = PRETO;
                no.pai.pai.cor = VERMELHO;
               
                //não é um nó à direita (externo)
                //executa somente essa caso de ser rotacao simples
                rotateRR(no.pai.pai);
            
             //pai é um filho direito?
            } else {
            	//pega o tio
                tio = no.pai.pai.esquerdo;
              //Caso 02
                if (tio != nil && tio.cor == VERMELHO) {
                    no.pai.cor = PRETO;
                    tio.cor = PRETO;
                    no.pai.pai.cor = VERMELHO;
                    no = no.pai.pai;
                    continue;
                }
                
                //nó é um filho à esquerda (interno)?
                if (no == no.pai.esquerdo) {
                	 //se precisar de rotacao dupla
                    no = no.pai;
                    rotateRR(no);
                }
                
                no.pai.cor = PRETO;
                no.pai.pai.cor = VERMELHO;
                
                //não é um nó à direita (externo)
                //executa somente essa caso de ser rotacao simples
                rotateLL(no.pai.pai);
            }
        }
        
        //recolore a raiz
        raiz.cor = PRETO;
    }
    
    
    //rotacao à esquerda
    void rotateLL(RBNo no) {
        if (no.pai != nil) {
            if (no == no.pai.esquerdo) {
                no.pai.esquerdo = no.direito;
            } else {
                no.pai.direito = no.direito;
            }
            no.direito.pai = no.pai;
            no.pai = no.direito;
            if (no.direito.esquerdo != nil) {
                no.direito.esquerdo.pai = no;
            }
            no.direito = no.direito.esquerdo;
            no.pai.esquerdo = no;

        //precisa rotacionar
        } else {
        	RBNo direito = raiz.direito;
            raiz.direito = direito.esquerdo;
            direito.esquerdo.pai = raiz;
            raiz.pai = direito;
            direito.esquerdo = raiz;
            direito.pai = nil;
            raiz = direito;
        }
    }
    
    //rotacao à direita
    void rotateRR(RBNo no) {
        if (no.pai != nil) {
            if (no == no.pai.esquerdo) {
                no.pai.esquerdo = no.esquerdo;
            } else {
                no.pai.direito = no.esquerdo;
            }

            no.esquerdo.pai = no.pai;
            no.pai = no.esquerdo;
            if (no.esquerdo.direito != nil) {
                no.esquerdo.direito.pai = no;
            }
            no.esquerdo = no.esquerdo.direito;
            no.pai.direito = no;
        
        //precisa rotacionar
        } else {
        	
        	RBNo esquerdo = raiz.esquerdo;
            raiz.esquerdo = raiz.esquerdo.direito;
            esquerdo.direito.pai = raiz;
            raiz.pai = esquerdo;
            esquerdo.direito = raiz;
            esquerdo.pai = nil;
            raiz = esquerdo;
        }
    }

    //Apagar árvore
    void deleteArovore(){
        raiz = nil;
    }
    
    boolean deletar(RBNo z){
    	
        if((z = buscar(z, raiz))==null)
        	return false;
        RBNo x;
        RBNo y = z; // temporary reference y
        Cor y_original_color = y.cor;
        
        if(z.esquerdo == nil){
            x = z.direito;  
            transplant(z, z.direito);  
        }else if(z.direito == nil){
            x = z.esquerdo;
            transplant(z, z.esquerdo); 
        }else{
            y = treeMinimum(z.direito);
            y_original_color = y.cor;
            x = y.direito;
            if(y.pai == z)
                x.pai = y;
            else{
                transplant(y, y.direito);
                y.direito = z.direito;
                y.direito.pai = y;
            }
            transplant(z, y);
            y.esquerdo = z.esquerdo;
            y.esquerdo.pai = y;
            y.cor = z.cor; 
        }
        if(y_original_color==PRETO)
            deleteFixup(x);  
        return true;
    }
    
    
    //auxiliar do delete
    void transplant(RBNo no, RBNo no2){ 
          if(no.pai == nil){
              raiz = no2;
          }else if(no == no.pai.esquerdo){
              no.pai.esquerdo = no2;
          }else
              no.pai.direito = no2;
          no2.pai = no.pai;
    }
    
    
    
    //auxiliar do delete
    void deleteFixup(RBNo no){
        while(no!=raiz && no.cor == PRETO){ 
            if(no == no.pai.esquerdo){
            	RBNo no2 = no.pai.direito;
                if(no2.cor == VERMELHO){
                    no2.cor = PRETO;
                    no.pai.cor = VERMELHO;
                    rotateLL(no.pai);
                    no2 = no.pai.direito;
                }
                if(no2.esquerdo.cor == PRETO && no2.direito.cor == PRETO){
                    no2.cor = VERMELHO;
                    no = no.pai;
                    continue;
                }
                else if(no2.direito.cor == PRETO){
                    no2.esquerdo.cor = PRETO;
                    no2.cor = VERMELHO;
                    rotateRR(no2);
                    no2 = no.pai.direito;
                }
                if(no2.direito.cor == VERMELHO){
                    no2.cor = no.pai.cor;
                    no.pai.cor = PRETO;
                    no2.direito.cor = PRETO;
                    rotateLL(no.pai);
                    no = raiz;
                }
            }else{
            	RBNo no2 = no.pai.esquerdo;
                if(no2.cor == VERMELHO){
                    no2.cor = PRETO;
                    no.pai.cor = VERMELHO;
                    rotateRR(no.pai);
                    no2 = no.pai.esquerdo;
                }
                if(no2.direito.cor == PRETO && no2.esquerdo.cor == PRETO){
                    no2.cor = VERMELHO;
                    no = no.pai;
                    continue;
                }
                else if(no2.esquerdo.cor == PRETO){
                    no2.direito.cor = PRETO;
                    no2.cor = VERMELHO;
                    rotateLL(no2);
                    no2 = no.pai.esquerdo;
                }
                if(no2.esquerdo.cor == VERMELHO){
                    no2.cor = no.pai.cor;
                    no.pai.cor = PRETO;
                    no2.esquerdo.cor = PRETO;
                    rotateRR(no.pai);
                    no = raiz;
                }
            }
        }
        no.cor = PRETO; 
    }
    
    //auxiliar do delete
    RBNo treeMinimum(RBNo raizSubArvore){
        while(raizSubArvore.esquerdo!=nil){
            raizSubArvore = raizSubArvore.esquerdo;
        }
        return raizSubArvore;
    }
    
    
    
    public void preorder(RBNo node) {
        if (node == nil) {
            return;
        }
        System.out.print(((node.cor==VERMELHO)?"Cor: Vermelho ":"Cor: Preto")+" - valor: "+node.valor);
        preorder(node.esquerdo);
        preorder(node.direito);
    }
    
}