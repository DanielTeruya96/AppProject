package tokencio.tt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


import java.math.BigInteger;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.txtela)
    TextView numero;

    BigInteger numerao = new BigInteger("0");

    public String tela = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



    }
    private void limpaTela(){
        tela = "";
        numero.setText(tela);
    }


    //Funcao das operacoes
    @OnClick(R.id.mais)
    public void mais(View v){
        numerao.add(new BigInteger(tela));
        limpaTela();
    }

    // funcao do botao C
    @OnClick(R.id.apagar)
    public void apaga(View v){
        limpaTela();
    }
    //funcao do botao A
    @OnClick(R.id.umValor)
    public void umValor(View v){
        String aux = "";
        for(int i =0;i<tela.length()-1;i++){
            aux += tela.charAt(i);
        }
        tela = aux;
        numero.setText(tela);
    }





    // setter de numeros de 0 ate nove
    @OnClick(R.id.um)
    public void um(View v){
        tela = numero.getText().toString()+"1";
        numero.setText(tela);


    }

    @OnClick(R.id.dois)
    public void dois(View v){
        tela = numero.getText().toString()+"2";
        numero.setText(tela);
    }

    @OnClick(R.id.tres)
    public void tres(View v){
        tela = numero.getText().toString()+"3";
        numero.setText(tela);
    }

    @OnClick(R.id.quatro)
    public void quatro(View v){
        tela = numero.getText().toString()+"4";
        numero.setText(tela);
    }

    @OnClick(R.id.cinco)
    public void cinco(View v){
        tela = numero.getText().toString()+"5";
        numero.setText(tela);
    }

    @OnClick(R.id.seis)
    public void seis(View v){
        tela = numero.getText().toString()+"6";
        numero.setText(tela);
    }

    @OnClick(R.id.sete)
    public void sete(View v){
        tela = numero.getText().toString()+"7";
        numero.setText(tela);
    }

    @OnClick(R.id.oito)
    public void oito(View v){
        tela = numero.getText().toString()+"8";
        numero.setText(tela);
    }

    @OnClick(R.id.nove)
    public void nove(View v){
        tela = numero.getText().toString()+"9";
        numero.setText(tela);
    }
    @OnClick(R.id.zero)
    public void zero(View v){
        tela = numero.getText().toString()+"0";
        numero.setText(tela);
    }


}
