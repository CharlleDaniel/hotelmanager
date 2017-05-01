package br.com.managerhotel.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.managerhotel.R;

public class LimpezaActivity extends AppCompatActivity {
    final String title = "Limpeza";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limpeza);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_limpeza);
        toolbar.setTitle(title);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
