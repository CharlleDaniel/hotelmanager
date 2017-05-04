package br.com.managerhotel.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.managerhotel.R;
import br.com.managerhotel.adapters.ItemAdapter;
import br.com.managerhotel.controller.SystemController;
import br.com.managerhotel.model.Item;
import br.com.managerhotel.model.Pedido;

public class LimpezaActivity extends AppCompatActivity {

    private ListView menuListLimpeza;
    private SystemController system;
    private Button btEnviarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limpeza);

        system = MainActivity.system;
        system.createMenuLimpeza();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_limpeza);
        toolbar.setTitle(getString(R.string.menu_item_limpeza));
        toolbar.setLogo(R.mipmap.ic_limpeza);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buildViews();
        buildListMenu();

    }

    private void buildViews() {
        menuListLimpeza = (ListView)findViewById(R.id.lv_limpeza);
        btEnviarPedido = (Button)findViewById(R.id.bt_sendPedido);

        btEnviarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarPedido();
            }
        });
    }

    private void buildListMenu() {
        menuListLimpeza.setAdapter(new ItemAdapter(this, system.getMenuLimpezaList()));
        menuListLimpeza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = (Item) parent.getAdapter().getItem(position);

                if (item.isSelected()) {
                    item.setIsSelected(false);
                } else {
                    item.setIsSelected(true);
                }
                buildListMenu();
            }
        });

    }


    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void enviarPedido(){
        List<Item> itens = new ArrayList<>();
        for (Item item : system.getMenuLimpezaList()){
            if (item.isSelected()) {
                itens.add(item);
            }
        }

        if(itens.size()>0){
            Pedido pedido = new Pedido("101", "Limpeza",itens);
            system.enviarPedido(pedido);
            showMessage("Pedido realizado com sucesso.");
            finish();
        }else{
            showMessage("Selecione um item para realizar um pedido.");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==android.R.id.home){
            onBackPressed();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }


}
