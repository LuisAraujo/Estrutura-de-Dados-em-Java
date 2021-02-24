
import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] vet = {10,4,2,9,6,7};
        insertionSort(vet);
    }

    private static void insertionSort(int[] vet) {

        int aux, j;

        for ( int i = 1; i < vet.length; i++ ){
            //aux = 4
            aux = vet[i];
            //j = 10
            j = i - 1;

            while ( (j >= 0) && vet[j] > aux){
                vet[j+1] = vet[j];
                j--;

            }
            vet[j+1] = aux;
            System.out.println(Arrays.toString(vet));
        }
    }
}
