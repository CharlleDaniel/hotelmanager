package br.com.managerhotel.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import br.com.managerhotel.adapters.MenuAdapter;
import br.com.managerhotel.adapters.PedidoAdapter;
import br.com.managerhotel.controller.SystemController;
import br.com.managerhotel.model.GridMenuItem;
import br.com.managerhotel.R;
import br.com.managerhotel.model.Item;
import br.com.managerhotel.model.Pedido;


public class MainActivity extends AppCompatActivity {

    private GridView menuList;
    public static SystemController system;
    private ListView pedidosList;
    private TextView tvLabelPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        system = new SystemController(this);
        system.createMenuList();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buildViews();
        createMenu();
        showDialog();

    }

    private void createMenu() {

        menuList.setAdapter(new MenuAdapter(this, system.getMenuItemList()));
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GridMenuItem item = (GridMenuItem) parent.getAdapter().getItem(position);
                Intent i = null;
                switch (item.getLabel()) {
                    case "Amenities":
                        i = new Intent(getBaseContext(), AmenitiesActivity.class);
                        break;
                    case "Enxoval":
                        i = new Intent(getBaseContext(), EnxovalActivity.class);
                        break;
                    case "Limpeza":
                        i = new Intent(getBaseContext(), LimpezaActivity.class);
                        break;
                    case "Outros":
                        i = new Intent(getBaseContext(), OutrosActivity.class);
                        break;
                    default:
                        break;
                }
                startActivity(i);
            }
        });
        buildPedidos();
    }


    private void showDialog() {
        final Dialog d = new Dialog(this);
        d.setContentView(R.layout.dialog_frist_access);
        d.setTitle("Boas Vindas");
        d.setCancelable(true);
        Button bt_continue = (Button) d.findViewById(R.id.button_continue);
        bt_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();
    }

    private void buildViews() {
        tvLabelPedidos = (TextView) findViewById(R.id.tv_label_pedidos);
        menuList = (GridView) findViewById(R.id.menuList);
        pedidosList = (ListView) findViewById(R.id.lv_pedidos);
        pedidosList.setVerticalScrollBarEnabled(false);
        menuList.setVerticalScrollBarEnabled(false);
    }

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void buildPedidos(){

        List<Pedido> pedidos= system.getPedidosList();

        if(pedidos.size()>0){
            tvLabelPedidos.setVisibility(View.GONE);
        }else{
            tvLabelPedidos.setVisibility(View.VISIBLE);
        }

        pedidosList.setAdapter(new PedidoAdapter(this, pedidos));
        pedidosList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pedido pedido = (Pedido) parent.getAdapter().getItem(position);
                for (Item i : pedido.getItens()) {
                    if(!pedido.getSession().equals("Limpeza")){
                        showMessage("Item: " + i.getName() + " Quantidade: " + i.getQtd());
                    }else {
                        showMessage("Item: " + i.getName());
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        buildPedidos();
        super.onStart();
    }

    @Override
    protected void onResume() {
        buildPedidos();
        super.onResume();
    }
}
