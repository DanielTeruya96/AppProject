package teamtoko.ordenacao.Ordenando.Metodos;

/**
 * Created by Tokencio on 16/07/2016.
 */
public class HeapSort extends Vetores{
    public int[] heapSort(int[] v) {
        this.vet = v;
        buildMaxHeap(vet);
        int n = vet.length;

        for (int i = v.length - 1; i > 0; i--) {
            troca(i, 0);
            maxHeapify(vet, 0, --n);
        }

        return vet;
    }

    private void buildMaxHeap(int[] v) {
        for (int i = v.length / 2 - 1; i >= 0; i--)
            maxHeapify(vet, i, vet.length);

    }

    private void maxHeapify(int[] vetor, int pos, int tamanhoDoVetor)
    {

        int max = 2 * pos + 1, right = max + 1;
        contadorDeComparcao++;
        if (max < tamanhoDoVetor)
        {
            contadorDeComparcao++;
            if (right < tamanhoDoVetor && vetor[max] < vetor[right])
                max = right;

            contadorDeComparcao++;
            if (vetor[max] > vetor[pos])
            {
                troca(max, pos);
                maxHeapify(vetor, max, tamanhoDoVetor);
            }
        }
    }
}
