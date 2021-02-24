public class Main {

	public static void main(String[] args) {
		
		//Criando a fila
		FilaV<Integer> f = new FilaV<Integer>(10);
		int n = 0;
		
		//Preenchendo a fila
		while(f.inserir(n++)) ){}
		
	
		//usando o toString implicitamente aqui
		System.out.println(f);
		
		//removendo os elementos da fila
		Integer l = null;
		do{
			l =  f.remover();
			
			if(l!=null)
				System.out.println("Removido "+l );		
		
		}while(l != null);
		
		

		
	}

}
