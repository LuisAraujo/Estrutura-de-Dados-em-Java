
public class Main {

	public static void main(String[] args) {
		
		Arvore arvore = new Arvore();

		arvore.inserirNo(25);
		No atual =  arvore.inserirNo(15);
		arvore.inserirNo(5);
		arvore.inserirNo(35);
		arvore.inserirNo(30);
		arvore.inserirNo(40);
		arvore.inserirNo(20);
		
		System.out.println("       "+arvore.raiz);
		System.out.println("  "+arvore.raiz.esquerdo+ "        "+arvore.raiz.direito);
		
		System.out.print(arvore.raiz.esquerdo.esquerdo+ "  "+arvore.raiz.esquerdo.direito);
		System.out.println("     "+arvore.raiz.direito.esquerdo+"  "+arvore.raiz.direito.direito);
		
		int valorDel = 15;
		
		System.out.println("------------");
		System.out.println("Removendo "+valorDel);
		arvore.removerNo(valorDel);
	    
	
		System.out.println("       "+arvore.raiz);
		System.out.println("  "+arvore.raiz.esquerdo+ "        "+arvore.raiz.direito);
		
		System.out.print(arvore.raiz.esquerdo.esquerdo+ "  "+arvore.raiz.esquerdo.direito);
		System.out.println("     "+arvore.raiz.direito.esquerdo+"  "+arvore.raiz.direito.direito);
		
		
		/*
		arvore.inserirNo(2);
		arvore.inserirNo(3);
		
		System.out.println(arvore.raiz);
		System.out.println(arvore.raiz.obterNoDireito());
		System.out.println(arvore.raiz.obterNoEsquerdo());*/

	}

}
