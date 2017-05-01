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

import br.com.managerhotel.model.GridMenuItem;
import br.com.managerhotel.R;


public class MenuAdapter extends BaseAdapter {

    Context context;
    List<GridMenuItem> itens;

    public MenuAdapter(Context c, List<GridMenuItem> itens){
        this.context = c;
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public GridMenuItem getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridMenuItem item = itens.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.grid_menu_adapter, null);

        ImageView imgMenuItem = (ImageView)view.findViewById(R.id.iv_icon);

        imgMenuItem.setImageResource(item.getIdIcon());

        RelativeLayout colorMenuItem = (RelativeLayout)view.findViewById(R.id.menu_color);

        colorMenuItem.setBackgroundColor(Color.parseColor(item.getColor()));

        TextView labelMenuItem = (TextView)view.findViewById(R.id.menu_label);

        labelMenuItem.setText(item.getLabel());

        return view;

    }
}
