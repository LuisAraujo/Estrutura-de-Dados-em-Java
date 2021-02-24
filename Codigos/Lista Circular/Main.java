
public class Main {

	public static void main(String[] args) {
		
		ListaCircular<Integer> lc = new ListaCircular<Integer>();
		//inserindo
		lc.inserir(2);
		lc.inserir(3);
		lc.inserir(4);
		lc.inserir(6);
		lc.inserir(5);
		lc.inserir(1);
		
		//exibindo
		System.out.println(lc);
		
		//deletando um no
		lc.remover(2);
		
		//exibindo do inicio
		lc.resetCurrentNode();
		System.out.println("----");
		System.out.println(lc);
		
		

		//deletando um no inexiste
		lc.remover(8);
		
		//exibindo do inicio
		lc.resetCurrentNode();
		System.out.println("----");
		System.out.println(lc);
		
		
		System.out.println("----");
		//usando a busca normal
		No n = lc.buscar(5);
		System.out.println("No ="+n);
		n = lc.buscar(5);
		System.out.println("No ="+n);
		n = lc.buscar(6);
		System.out.println("No ="+n);
		n = lc.buscar(2);
		System.out.println("No ="+n);
		n = lc.buscar(8);
		System.out.println("No ="+n);
		
		
		System.out.println("----");
		//usando a busca otimizada
		 n = lc.buscarOtim(5);
		System.out.println("No ="+n);
		n = lc.buscarOtim(5);
		System.out.println("No ="+n);
		n = lc.buscarOtim(6);
		System.out.println("No ="+n);
		n = lc.buscarOtim(2);
		System.out.println("No ="+n);
		n = lc.buscarOtim(8);
		System.out.println("No ="+n);
		

	}

}
