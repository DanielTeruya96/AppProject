package teamtoko.ordenacao.Busca;

/**
 * Created by Tokencio on 18/07/2016.
 */
public class Sequencial extends Busca {

    public String sequencial(int[] vetor,int numero){
        String s = "";
        for(int i = 0;i<vetor.length;i++){
            if(vetor[i] == numero){
                s+= " ["+i+"] ";
            }
        }
        return s;
    }
}
