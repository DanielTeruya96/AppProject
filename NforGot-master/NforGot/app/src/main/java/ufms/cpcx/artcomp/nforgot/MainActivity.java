package ufms.cpcx.artcomp.nforgot;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class MainActivity extends Activity implements Runnable{

    private final String arq = "arqPreferencia";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(this,3000);
    }

    @Override
    public void run() {
        SharedPreferences sh = getSharedPreferences(arq,0);
        if(sh.contains("cadastrado")){
            startActivity(new Intent(this,ChaveActivity.class));
        }else{
            startActivity(new Intent(this,CadastreActivity.class));

        }
    }
}
