package teamtoko.ordenacao.Ordenando.Metodos;

/**
 * Created by Tokencio on 16/07/2016.
 */
public class MergeSort extends Vetores {

    public int[] mergeSort(int[] vetor) {
        vet = vetor;

        return merge(vet);
    }

  private int[] merge(int array[]) {


        if (array.length > 1) {
            int elementsInA1 = array.length / 2;
            int elementsInA2 = array.length - elementsInA1;
            int arr1[] = new int[elementsInA1];
            int arr2[] = new int[elementsInA2];

            for (int i = 0; i < elementsInA1; i++)
                arr1[i] = array[i];

            for (int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
                arr2[i - elementsInA1] = array[i];

            arr1 = merge(arr1);
            arr2 = merge(arr2);

            int i = 0, j = 0, k = 0;
            contadorDeComparcao++;
            while (arr1.length != j && arr2.length != k) {
                contadorDeComparcao++;
                contadorDeComparcao++;
                if (arr1[j] <= arr2[k]) {
                    contadorDePermutacao++;
                    array[i] = arr1[j];
                    i++;
                    j++;
                } else {
                    contadorDePermutacao++;
                    array[i] = arr2[k];
                    i++;
                    k++;
                }
            }
            contadorDeComparcao++;
            while (arr1.length != j) {
                contadorDeComparcao++;
                contadorDePermutacao++;
                array[i] = arr1[j];
                i++;
                j++;
            }
            contadorDeComparcao++;
            while (arr2.length != k) {
                contadorDeComparcao++;
                contadorDePermutacao++;
                array[i] = arr2[k];
                i++;
                k++;
            }
        }
        return array;
    }

}
