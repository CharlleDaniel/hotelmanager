package br.com.managerhotel.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import br.com.managerhotel.R;

public class EnxovalActivity extends AppCompatActivity {
    final String title = "Enxoval";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enxoval);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_enxoval);
        toolbar.setTitle(title);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
