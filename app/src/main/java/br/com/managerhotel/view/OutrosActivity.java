package br.com.managerhotel.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import br.com.managerhotel.R;
import br.com.managerhotel.adapters.ItemAdapter;
import br.com.managerhotel.controller.SystemController;
import br.com.managerhotel.model.Item;

public class OutrosActivity extends AppCompatActivity {

    private ListView menuListOutros;
    private SystemController system;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outros);

        system = MainActivity.system;
        system.createMenuOutros();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_outros);
        toolbar.setTitle(getString(R.string.menu_item_outros));
        toolbar.setLogo(R.mipmap.ic_outros);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buildViews();
        buildListMenu();

    }

    private void buildViews() {
        menuListOutros = (ListView)findViewById(R.id.lv_outros);
    }

    private void buildListMenu() {
        menuListOutros.setAdapter(new ItemAdapter(this, system.getMenuOutrosList()));
        menuListOutros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = (Item) parent.getAdapter().getItem(position);

                showMessage(item.getName());
            }
        });

    }


    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
