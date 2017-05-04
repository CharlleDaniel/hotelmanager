package br.com.managerhotel.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import br.com.managerhotel.R;
import br.com.managerhotel.model.GridMenuItem;
import br.com.managerhotel.model.Item;


public class ItemAdapter extends BaseAdapter {

    Context context;
    List<Item> itens;

    public ItemAdapter(Context c, List<Item> itens){
        this.context = c;
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Item getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = itens.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.item_pedido_adapter, null);

        ImageView ivItem = (ImageView)view.findViewById(R.id.iv_check_box);
        if (item.isEnableSelected()){
            if(item.isSelected()){
                ivItem.setImageResource(android.R.drawable.checkbox_on_background);
            }else {
                ivItem.setImageResource(android.R.drawable.checkbox_off_background);
            }
        }else{
            ivItem.setVisibility(View.GONE);
        }


        TextView labelItem = (TextView)view.findViewById(R.id.tv_label_item);
        labelItem.setText(item.getName());

        TextView qtdItem = (TextView)view.findViewById(R.id.tv_qtd_item);
        if(item.getQtd()>0){
            qtdItem.setVisibility(View.VISIBLE);
            qtdItem.setText("Quantidade: "+item.getQtd());
        }else{
            qtdItem.setVisibility(View.GONE);
        }


        return view;

    }
}
