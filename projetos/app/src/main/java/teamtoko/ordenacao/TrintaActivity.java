package teamtoko.ordenacao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import teamtoko.ordenacao.Ordenando.Metodos.BbubbleSorte;
import teamtoko.ordenacao.Ordenando.Metodos.GeraVetor;
import teamtoko.ordenacao.Ordenando.Metodos.HeapSort;
import teamtoko.ordenacao.Ordenando.Metodos.MergeSort;
import teamtoko.ordenacao.Ordenando.Metodos.QuickSort;

public class TrintaActivity extends AppCompatActivity {
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trinta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        texto = (TextView) findViewById(R.id.infoId);
        texto.setText(trinta());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected int[] copiaVetor(int[] vetor){
        int[] vetor2 = new int[vetor.length];
        for(int i = 0 ;i<vetor.length ; i++){
            vetor2[i] = vetor[i];
        }
        return vetor2;
    }

    protected String trinta(){
        int[] vetor = GeraVetor.criaVetor(1000),vetor2;
        String linha = "";
        BbubbleSorte bubble = new BbubbleSorte();
        MergeSort merge = new MergeSort();
        HeapSort heap = new HeapSort();
        QuickSort quick = new QuickSort();
        for(int i = 0 ; i<30;i++){
            vetor2 = copiaVetor(vetor);
            bubble.sortBubble(vetor2);
            vetor2 = copiaVetor(vetor);
            merge.mergeSort(vetor2);
            vetor2 = copiaVetor(vetor);
            heap.heapSort(vetor2);
            vetor2 = copiaVetor(vetor);
            quick.quickSort(vetor2);
        }
        linha = "Média de comparações com o Bubblesort foi: " + bubble.getContadorDeComparcao() / 30 + "\n"
                + "Média de permutações com o Bubblesort foi " + bubble.getContadorDePermutacao() / 30 + "\n"
                + "---\n"
                + "Média de comparações com o MergeSort foi: " + merge.getContadorDeComparcao() / 30 + "\n"
                + "Média de permutações com o Mergesort foi " + merge.getContadorDePermutacao() / 30 + "\n"
                + "--\n"
                + "Média de comparações com o HeapSort foi: " + heap.getContadorDeComparcao() / 30 + "\n"
                + "Média de permutações com o HeapSort foi " + heap.getContadorDePermutacao() / 30 + "\n"
                + "--\n"
                + "Média de comparações com o QuickSort foi: " + quick.getContadorDeComparcao() / 30 + "\n"
                + "Média de permutações com o QuickSort foi " + quick.getContadorDePermutacao() / 30 + "\n";

        return linha;
    }

}
