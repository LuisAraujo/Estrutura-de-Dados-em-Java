class RBNo {

        int valor = -1;
        Cor cor = Cor.BLACK;
        RBNo esquerdo;
        RBNo direito;
        RBNo pai;

        RBNo(int valor, RBNo nil) {
            this.valor = valor;
            esquerdo = nil;
            direito = nil;
            pai = nil;
        } 
        
        RBNo(int valor) {
            this.valor = valor;
            esquerdo = ArvoreRB.nil;
            direito =  ArvoreRB.nil;
            pai =  ArvoreRB.nil;
        } 
 }