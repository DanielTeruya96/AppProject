package teamtoko.ordenacao;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import teamtoko.ordenacao.Busca.Binaria;
import teamtoko.ordenacao.Busca.Sequencial;
import teamtoko.ordenacao.Ordenando.Metodos.BbubbleSorte;
import teamtoko.ordenacao.Ordenando.Metodos.GeraVetor;
import teamtoko.ordenacao.Ordenando.Metodos.HeapSort;
import teamtoko.ordenacao.Ordenando.Metodos.MergeSort;
import teamtoko.ordenacao.Ordenando.Metodos.QuickSort;

public class TelaVetorActivity extends AppCompatActivity implements View.OnClickListener{
    Context context = this;
    TextView textoBusca;
    TextView desOrdenado;
    TextView ordenado;
    TextView comparacao;
    TextView permutacao;
    Button btnBubble;
    Button btnQuick;
    Button btnMerge;
    Button btnHeap;
    int tamanhoDoVetor,vetor1[],vetor2[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_vetor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        setSupportActionBar(toolbar);
        desOrdenado = (TextView) findViewById(R.id.vetorDesordenadoId);
        ordenado = (TextView) findViewById(R.id.vetorOrdenadoId);
        comparacao = (TextView) findViewById(R.id.txtComparacao);
        permutacao = (TextView) findViewById(R.id.txtPermutacao);
        textoBusca = (TextView) findViewById(R.id.textoBuscaId);
        textoBusca.setVisibility(View.INVISIBLE);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            tamanhoDoVetor= bundle.getInt("tamanho");
            Toast toast = Toast.makeText(this,tamanhoDoVetor+" posicao",Toast.LENGTH_LONG);
            toast.show();
            vetor1 = GeraVetor.criaVetor(tamanhoDoVetor);
            desOrdenado.setText(GeraVetor.ImprimiVetor(vetor1));
        }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnBubble = (Button) findViewById(R.id.bubbleId);
        btnQuick = (Button) findViewById(R.id.quickId);
        btnMerge = (Button) findViewById(R.id.mergeId);
        btnHeap = (Button) findViewById(R.id.heapId);

        btnBubble.setOnClickListener(this);
        btnQuick.setOnClickListener(this);
        btnMerge.setOnClickListener(this);
        btnHeap.setOnClickListener(this);

    }

    private int[] copiaVetor(int[] vetor1) {
        int[] vet2 = new int[vetor1.length];
        for(int i = 0 ;i<vetor1.length;i++){
            vet2[i] = vetor1[i];
        }
        return vet2;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private AlertDialog alerta;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            LayoutInflater li = getLayoutInflater();
            View view = li.inflate(R.layout.busca,null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Busca");
            final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radiogroupId);
            final EditText numeroEscolhido = (EditText) view.findViewById(R.id.numeroId);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String numero = numeroEscolhido.getText().toString();
                    int escolhido = radioGroup.getCheckedRadioButtonId();
                    if(escolhido == R.id.binarioId){

                        Toast t = Toast.makeText(context,"binario "+numero,Toast.LENGTH_SHORT);
                        t.show();
                        try{
                            Binaria binaria = new Binaria();
                            numero = binaria.BuscaBinaria(vetor2,Integer.parseInt(numero));

                        }catch (Exception e){
                            numero = e.toString();
                        }


                    }else if(escolhido == R.id.sequencialId){

                        Toast t = Toast.makeText(context,"sequencial"+numero,Toast.LENGTH_SHORT);
                        Sequencial sequencial = new Sequencial();

                        numero = sequencial.sequencial(vetor1, Integer.parseInt(numero));
                        if(numero.equals("")){
                            numero = "Numero não encontrado";
                        }

                        t.show();
                    }else{
                        Toast t = Toast.makeText(context,"Escolha uma opção",Toast.LENGTH_SHORT);
                        t.show();
                        numero = "escolha uma opcao";
                    }
                    textoBusca.setText(numero);
                    textoBusca.setVisibility(View.VISIBLE);
                    alerta.dismiss();
                }
            });
            builder.setView(view);
            alerta = builder.create();
            alerta.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        vetor2 = copiaVetor(vetor1);
        switch (v.getId()){
            case R.id.bubbleId:

                BbubbleSorte bubble = new BbubbleSorte();
                vetor2 = bubble.sortBubble(vetor2);
                comparacao.setText(bubble.getContadorDeComparcao()+"");
                permutacao.setText(bubble.getContadorDePermutacao()+"");
                ordenado.setText(GeraVetor.ImprimiVetor(vetor2));

                break;
            case R.id.quickId:
                QuickSort quickSort = new QuickSort();
                vetor2 = quickSort.quickSort(vetor2);
                comparacao.setText(quickSort.getContadorDeComparcao()+"");
                permutacao.setText(quickSort.getContadorDePermutacao()+"");
                ordenado.setText(GeraVetor.ImprimiVetor(vetor2));
                break;
            case R.id.mergeId:
                MergeSort mergeSort = new MergeSort();
                vetor2 = mergeSort.mergeSort(vetor2);
                comparacao.setText(mergeSort.getContadorDeComparcao()+"");
                permutacao.setText(mergeSort.getContadorDePermutacao()+"");
                ordenado.setText(GeraVetor.ImprimiVetor(vetor2));

                break;
            case R.id.heapId:
                HeapSort heap = new HeapSort();
                vetor2 = heap.heapSort(vetor2);
                comparacao.setText(heap.getContadorDeComparcao()+"");
                permutacao.setText(heap.getContadorDePermutacao()+"");
                ordenado.setText(GeraVetor.ImprimiVetor(vetor2));
                break;

        }
    }
}
