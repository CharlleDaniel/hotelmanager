package br.com.managerhotel.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.managerhotel.R;
import br.com.managerhotel.model.Item;
import br.com.managerhotel.model.Pedido;


public class PedidoAdapter extends BaseAdapter {

    Context context;
    List<Pedido> itens;

    public PedidoAdapter(Context c, List<Pedido> itens){
        this.context = c;
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Pedido getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pedido item = itens.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.pedido_adapter, null);


        TextView labelItem = (TextView)view.findViewById(R.id.tv_label_pedido);
        labelItem.setText("Solicitação de "+item.getSession());


        return view;

    }
}
