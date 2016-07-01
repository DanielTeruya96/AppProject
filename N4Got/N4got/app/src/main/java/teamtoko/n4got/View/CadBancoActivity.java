package teamtoko.n4got.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teamtoko.n4got.R;

public class CadBancoActivity extends AppCompatActivity {
    private List<String> nomes = new ArrayList<String>();
    private Spinner spin;
    @BindView(R.id.imgBanco)
    ImageView imgBanco;

    @BindView(R.id.txtBanco)
    TextView txtBanco;
    private int resourceImg = R.drawable.bb,vet[] = {R.drawable.bb,R.drawable.hsbc,R.drawable.caixa};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_banco);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        spin = (Spinner) findViewById(R.id.spinBanco);
        addList();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,nomes);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spin.setAdapter(spinnerArrayAdapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resourceImg = vet[position];
                imgBanco.setImageResource(resourceImg);
                txtBanco.setText(nomes.get(position));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @OnClick(R.id.btnAdiciona)
    public void whatevear(View v){
        startActivity(new Intent(getApplicationContext(), CartaoActivity.class));

    }

    private void addList(){
        nomes.add("Banco do brasil");
        nomes.add("HSBC");
        nomes.add("Caixa");
    }

}
