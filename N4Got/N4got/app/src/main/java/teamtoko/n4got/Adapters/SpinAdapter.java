package teamtoko.n4got.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teamtoko.n4got.Model.RedeSocial;
import teamtoko.n4got.R;

/**
 * Created by Tokencio on 01/07/2016.
 */
public class SpinAdapter extends BaseAdapter{
    private LayoutInflater layoutInflater;
    private List<RedeSocial> modelos;

    public SpinAdapter(List<RedeSocial> itens, Context context){
        this.modelos = itens;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return modelos.size();
    }

    @Override
    public Object getItem(int position) {
        return modelos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       RedeSocial rede = modelos.get(position);
        ViewHolder holder;
        if(convertView != null){
            holder = (ViewHolder) convertView.getTag();
        }else{
            convertView = layoutInflater.inflate(R.layout.iten_spin,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder.imagem.setImageResource(rede.getImag());
        holder.name.setText(rede.getNome());


        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.imgLogo)
        ImageView imagem;
        @BindView(R.id.nomeLogo)
        TextView name;

        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }

    }
}
