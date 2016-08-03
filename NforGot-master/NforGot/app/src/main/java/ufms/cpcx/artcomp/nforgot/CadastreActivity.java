package ufms.cpcx.artcomp.nforgot;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastreActivity extends AppCompatActivity {
    private EditText nome;
    private EditText email;
    private EditText chave;
    private Button cadastro;
    private final String arq = "arqPreferencia";
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastre);
        nome = (EditText) findViewById(R.id.editNome);
        email = (EditText) findViewById(R.id.edtEmail);
        chave = (EditText) findViewById(R.id.edtChave);
        cadastro = (Button) findViewById(R.id.btnCadastro);
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sh = getSharedPreferences(arq,0);
                SharedPreferences.Editor editor = sh.edit();
                editor.putString("nome",nome.getText().toString());
                editor.putString("email",email.getText().toString());
                editor.putString("chave",chave.getText().toString());
                editor.putBoolean("cadastrado",true);
                editor.commit();

                startActivity(new Intent(context,ChaveActivity.class));
                finish();

            }
        });
    }
}
