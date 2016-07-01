package teamtoko.n4got.View;

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
import teamtoko.n4got.R;

public class CadRedActivity extends AppCompatActivity {
    @BindView(R.id.spinred)
    Spinner spinRede;
    @BindView(R.id.imgRede)
    ImageView imgRede;
    @BindView(R.id.txtTopo)
    TextView txtTopo;
    private int resourceimg = R.drawable.fb,vet[] = {R.drawable.fb,R.drawable.instagran,R.drawable.snap};
    List<String> nomeRedes = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_red);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        addList();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,nomeRedes);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinRede.setAdapter(spinnerArrayAdapter);
        spinRede.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resourceimg = vet[position];
                imgRede.setImageResource(resourceimg);
                txtTopo.setText(nomeRedes.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void addList(){
     nomeRedes.add("Facebook");
        nomeRedes.add("Instagram");
        nomeRedes.add("Snapchat");


    }

}
