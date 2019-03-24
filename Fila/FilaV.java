
/**
 * @author luis araujo
 * Implementação de uma fila baseada em vetor genérico
 * @param <T> Tipo do array
 */
public class FilaV<T>{
	private T[] arrayFila;
	private int inicio;
	private int fim;
	
	public FilaV(int size){
		inicio = fim = 0;
		arrayFila = (T[]) new Object[size];
	}
	
	public boolean estaCheia(){
		return ((fim == arrayFila.length-1) && (inicio == 0) )
				|| (fim == inicio-1);
	}
	
	public boolean estaVazia(){
		return inicio == fim;
	}
	
	public T remover(){
		if(!estaVazia()){
			T e = arrayFila[inicio];
			inicio++;
			return e;
		}
		
		return null;
	}
	
	public boolean inserir(T e){
		if(fim == arrayFila.length)
			fim = 0;
		
		if(!estaCheia()){
			arrayFila [fim++] = e;
			System.out.println("inserindo - " + fim);
			return true;
		}
		
		return false;
	}
	
	@Override
    public String toString(){
		
        String s = "[";
        int i = inicio; 
        while(i != fim){
        	System.out.println(s);
            if(i == arrayFila.length)
                i = 0;
            
            if(i == fim-1) 
                s+=arrayFila[i];
            else 
                s+=arrayFila[i] + " , ";
        
            i++;
    		
        }
        
        return s + "]";  
    }
}
