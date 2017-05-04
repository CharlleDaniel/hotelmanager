package br.com.managerhotel.view;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.managerhotel.R;
import br.com.managerhotel.adapters.ItemAdapter;
import br.com.managerhotel.controller.SystemController;
import br.com.managerhotel.model.Item;
import br.com.managerhotel.model.Pedido;

public class EnxovalActivity extends AppCompatActivity {

    private ListView menuListEnxoval;
    private SystemController system;
    private Button btEnviarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enxoval);

        system = MainActivity.system;
        system.createMenuEnxoval();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_enxoval);
        toolbar.setTitle(getString(R.string.menu_item_enxoval));
        toolbar.setLogo(R.mipmap.ic_enxoval);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buildViews();
        buildListMenu();

    }

    private void buildViews() {
        menuListEnxoval = (ListView)findViewById(R.id.lv_enxoval);
        btEnviarPedido = (Button)findViewById(R.id.bt_sendPedido);

        btEnviarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarPedido();
            }
        });
    }

    private void buildListMenu() {
        menuListEnxoval.setAdapter(new ItemAdapter(this, system.getMenuEnxovalList()));
        menuListEnxoval.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = (Item) parent.getAdapter().getItem(position);
                int qtd = 0;
                if (item.isSelected()) {
                    item.setQtd(qtd);
                    item.setIsSelected(false);
                    buildListMenu();
                } else {
                    showDialogQtd(item);
                }

            }
        });

    }


    private void showDialogQtd(final Item item){

        final Dialog d = new Dialog(this);
        d.setContentView(R.layout.dialog_add_text);

        d.setCancelable(false);


        final EditText qtdItem = (EditText) d.findViewById(R.id.ed_qtd);
        final TextView tvItemLabel= (TextView)d.findViewById(R.id.tv_item_label);

        tvItemLabel.setText("Quantidade de " + item.getName());



        Button buttonClosed= (Button)d.findViewById(R.id.bt_cancel);
        buttonClosed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });

        Button buttonYes=(Button)d.findViewById(R.id.bt_save);
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int qtd = Integer.parseInt(qtdItem.getText().toString());

                    if (qtd > 5) {
                        showMessage("Você não pode pedir mais 5.");
                    } else if (qtd > 0) {
                        item.setQtd(qtd);
                        item.setIsSelected(true);
                        d.dismiss();
                        buildListMenu();
                    } else {
                        showMessage("Selecione um valor maior que zero.");
                    }

                } catch (NumberFormatException e) {
                    showMessage("Informe uma quantidade.");
                }
            }
        });

        d.show();
    }
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void enviarPedido(){
        List<Item> itens = new ArrayList<>();
        for (Item item : system.getMenuEnxovalList()){
            if (item.isSelected()) {
                itens.add(item);
            }
        }

        if(itens.size()>0){
            Pedido pedido = new Pedido("101", "Enxoval",itens);
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
