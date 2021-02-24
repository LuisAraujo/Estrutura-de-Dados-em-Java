
public class Main {

	public static void main(String[] args) {
		
		ListaDuplamente<Integer> ld = new ListaDuplamente<Integer>();
		
		for(int i = 0; i < 100; i++)
			ld.inserir(i);
		
		/*System.out.println(ld.primeiro);
		System.out.println(ld.primeiro.obterProximo());
		System.out.println(ld.primeiro.obterProximo().obterProximo());*/

		System.out.println(ld.buscarCount(99));
		System.out.println(ld.buscarCount(0));
		
		//System.out.println(ld.buscarCount(2));
		

	}

}
