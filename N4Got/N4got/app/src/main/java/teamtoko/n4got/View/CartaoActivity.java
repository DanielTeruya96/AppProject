package teamtoko.n4got.View;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import teamtoko.n4got.R;

public class CartaoActivity extends AppCompatActivity {
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.outrosAdicionar)
    public void outroadicionar(View v){
        Log.e("Botao","Clicado");
        final AlertDialog.Builder buil = new AlertDialog.Builder(context);
        buil.setTitle("Adicionar");
        buil.setView(R.layout.iten_adiciona);
        buil.setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast t = Toast.makeText(context,"Adicionado",Toast.LENGTH_SHORT);
                t.show();
            }
        });
        buil.setNegativeButton("Cancela", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast t = Toast.makeText(context,"cancelado",Toast.LENGTH_SHORT);
                t.show();
            }
        });
        AlertDialog dialog = buil.create();

        dialog.show();


    }
}
