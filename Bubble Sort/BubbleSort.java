
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] vet = {10,4,2,9,6,7};
        bubble(vet);
        System.out.println("Resultado: "+Arrays.toString(vet));

    }

    private static void bubble(int[] vet) {
        //ultimo recebe o tamanho do vetor e é decrementando a cada execução
        for ( int ultimo = vet.length-1; ultimo > 0; ultimo-- ){
            for ( int i = 0; i < ultimo; i++ ) {
                //posição da esquerda for menor que o da direita
                if ( vet[i] > vet[i+1] ){
                    //aux = 10
                    int aux = vet[i];
                    //vet[i] = 4
                    vet[i] = vet[i+1];
                    //vet[i+1] = 10
                    vet[i+1] = aux;

                    System.out.println( Arrays.toString( vet ) );
                }
            }
        }
    }

}
