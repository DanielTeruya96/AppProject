package teamtoko.ordenacao.Ordenando.Metodos;

import java.util.Random;

/**
 * Created by Tokencio on 16/07/2016.
 */
public class GeraVetor {
    static Random random = new Random();
    public static int[] criaVetor(int max){
        int[] vet = new int[max];
        for(int i = 0 ; i<max;i++){
            vet[i] = random.nextInt(1000);
        }
        return vet;
    }

    public static String ImprimiVetor(int[] vet){
        String retorna = "";
        for(int i = 0 ; i< vet.length ; i++){
            retorna += "["+i+"]  ["+vet[i]+"]\n";

        }
        return retorna;
    }
}
