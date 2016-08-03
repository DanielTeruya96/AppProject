package teamtoko.ordenacao.Ordenando.Metodos;

/**
 * Created by Tokencio on 16/07/2016.
 */
public class BbubbleSorte extends Vetores {

    public int[]sortBubble(int[] vetor){
        this.vet = vetor;

        int aux = vet.length;
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j <= aux-2; j++){

                contadorDeComparcao++;
                if (vet[j] > vet[j+1]) {

                    troca(j, j+1);
                }
            }
            aux--;
        }

        return vet;
    }
}
