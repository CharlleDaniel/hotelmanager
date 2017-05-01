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
import android.widget.Toast;

import java.util.ArrayList;

import br.com.managerhotel.adapters.MenuAdapter;
import br.com.managerhotel.model.GridMenuItem;
import br.com.managerhotel.R;


public class MainActivity extends AppCompatActivity {

    private GridView menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buildViews();
        createMenu();
        showDialog();

    }

    private void createMenu() {
        ArrayList<GridMenuItem> itens= new ArrayList<>();
        itens.add(new GridMenuItem("Amenities", R.drawable.icon_amenties, "#99004C"));
        itens.add(new GridMenuItem("Enxoval", R.drawable.icon_enxoval, "#CCCC00"));
        itens.add(new GridMenuItem("Limpeza", R.drawable.icon_limpeza, "#CC6600"));
        itens.add(new GridMenuItem("Outros", R.drawable.icon_outros, "#990099"));

        menuList.setAdapter(new MenuAdapter(this, itens));
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GridMenuItem item = (GridMenuItem) parent.getAdapter().getItem(position);
                Intent i = null;
                switch (item.getLabel()){
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
        menuList = (GridView) findViewById(R.id.menuList);
        menuList.setVerticalScrollBarEnabled(false);
    }

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
