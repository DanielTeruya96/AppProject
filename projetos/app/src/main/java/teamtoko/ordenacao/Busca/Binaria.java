package teamtoko.ordenacao.Busca;

/**
 * Created by Tokencio on 18/07/2016.
 */
public class Binaria extends Busca {
    /**
     * Função para realizar a busca sequencial
     * @param vet O Vetor
     * @return retorna a posição do elemento
     */
    public String BuscaBinaria(int vet[],int numero)throws IllegalArgumentException{
        int inicio = 0;
        int fim = vet.length;


        return "["+buscaBinariaRecursiva(vet,inicio,fim,numero)+"]";
    }




    private int buscaBinariaRecursiva(int[] array, int menor, int maior,
                                      int chave) {
        //TODO Busca ta dando erro com a primeria posicao
        if (menor > maior){
            throw new IllegalArgumentException("numero nao existe no vetor");
        }

        int media = (maior + menor) / 2;
        int valorMeio = array[media];
        comapracao++;
        if(valorMeio == chave)
            return media;
        else if (valorMeio < chave)
            return buscaBinariaRecursiva(array, media+1, maior, chave);
        else
            return buscaBinariaRecursiva(array, menor, media-1, chave);
    }
}
