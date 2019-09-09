package com.ticketpro.parking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainClass extends AppCompatActivity implements View.OnClickListener {

    private Button button_get_zone , button_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_class);

        button_get_zone = (Button) findViewById(R.id.button_getZone);
        button_search = (Button) findViewById(R.id.button_grtPateSerch);
        button_get_zone.setOnClickListener(this);
        button_search.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button_getZone:
                startActivity(new Intent(MainClass.this, ZoneActivity.class));
                break;
            case R.id.button_grtPateSerch:
                startActivity(new Intent(MainClass.this,PlateSearch.class));
                break;
                default:

        }
    }
}
