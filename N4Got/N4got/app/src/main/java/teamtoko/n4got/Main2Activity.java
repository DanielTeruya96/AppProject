package teamtoko.n4got;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {
    public Context ve = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater lay = getLayoutInflater();
                View itens = lay.inflate(R.layout.alert_items,null);
                itens.findViewById(R.id.btnrede).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast t = Toast.makeText(ve,"Clicou em rede",Toast.LENGTH_SHORT);
                        t.show();
                        Log.e("botal","Clicou no rede");
                    }
                });
                itens.findViewById(R.id.btnbanco).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast t = Toast.makeText(ve,"Clicou em Banco",Toast.LENGTH_SHORT);
                        t.show();
                        Log.e("botal","Clicou no Banco");
                    }
                });

                itens.findViewById(R.id.btnoutros).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast t = Toast.makeText(ve,"Clicou em Outros",Toast.LENGTH_SHORT);
                        t.show();
                        Log.e("botal","Clicou no outros");
                    }
                });

                AlertDialog.Builder buil = new AlertDialog.Builder(ve);
                buil.setTitle("Escolha uma opção");
                buil.setView(itens);
                AlertDialog dial = buil.create();

                dial.show();


            }


        });
    }


}
