package teamtoko.ordenacao.Ordenando.Metodos;

/**
 * Created by Tokencio on 16/07/2016.
 */
public class Vetores {
    protected int vet[];
    protected int contadorDeComparcao = 0;
    protected int contadorDePermutacao = 0;

    protected StringBuilder log;

    protected void troca(int i,int j){
        contadorDePermutacao++;
        int aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }

    /**
     * @return the contadorDeComparcao
     */
    public int getContadorDeComparcao() {
        return contadorDeComparcao;
    }

    /**
     * @return the contadorDePermutacao
     */
    public int getContadorDePermutacao() {
        return contadorDePermutacao;
    }

    /**
     * @return the contadorDeTroca
     */

}
