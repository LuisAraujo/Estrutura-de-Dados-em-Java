

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] vet = {10,4,2,9,6,7};
        selectionSort(vet);
    }

    private static void selectionSort(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            int menor = i;

            for (int j = i + 1; j < vet.length; j++) {
                if (vet[j] < vet[menor])
                    menor = j;
            }
            int aux = vet[i];
            vet[i] = vet[menor];
            vet[menor] = aux;

            System.out.println(Arrays.toString(vet));
        }
    }
}
