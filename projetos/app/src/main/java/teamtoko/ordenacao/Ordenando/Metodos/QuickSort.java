package teamtoko.ordenacao.Ordenando.Metodos;

/**
 * Created by Tokencio on 16/07/2016.
 */
public class QuickSort extends Vetores{
    int dividir(int[] vetor, int esq, int dir){
        int cont = esq;

        for (int i = esq + 1; i <= dir; i++) {

            contadorDeComparcao++;
            if (vetor[i] < vetor[esq]) {
                cont++;
                troca(i, cont);
            }
        }

        troca(esq, cont);

        return cont;
    }

    public int[] quick(int vetor[], int esq, int dir){

        int pos;
        contadorDeComparcao++;
        if (esq < dir) {
            pos = dividir(vetor, esq, dir);
            quick(vetor, esq, pos - 1);
            quick(vetor, pos + 1, dir);

        }
        return vet;
    }

    public int[] quickSort(int[] vetor){
        vet = vetor;

        return quick(vet,0,vet.length-1);
    }

}
