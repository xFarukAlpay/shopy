package com.example.exportaves;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class last_screen_activity extends Activity {


    private View _bg__last_screen;
    private TextView yard_m__stedi_iniz_ba_ar_yla_g_nderildi;
    private RelativeLayout empty_box;
    private ImageView kutu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_screen);

        _bg__last_screen = findViewById(R.id.last_screen);
        yard_m__stedi_iniz_ba_ar_yla_g_nderildi = findViewById(R.id.yard_m__stedi_iniz_ba_ar_yla_g_nderildi);
        empty_box = findViewById(R.id.empty_box);
        kutu = findViewById(R.id.kutu);


    }
}

