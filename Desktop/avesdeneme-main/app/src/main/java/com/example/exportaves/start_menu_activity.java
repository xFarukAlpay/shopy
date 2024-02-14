package com.example.exportaves;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class start_menu_activity extends Activity {

	private View _bg__start_menu;
	private TextView aves_iha_yard_m;
	private TextView acil_durumlarda_ihtiyac_n_z_olanlar__size_ula_t_r_yoruz_;
	private ImageView istockphoto_1009279168_170667a_1;
	private View _bg__loginmainbutton_ek1;
	private ImageView rectangle_3;
	private TextView giri__yap;
	private View _bg__signupmainbutton_ek1;
	private View rectangle_4;
	private TextView kay_t_ol;
	private TextView uygulama_nas_l_kullan_l_r;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_menu);

		_bg__start_menu = findViewById(R.id._bg__start_menu);
		aves_iha_yard_m = findViewById(R.id.aves_iha_yard_m);
		acil_durumlarda_ihtiyac_n_z_olanlar__size_ula_t_r_yoruz_ = findViewById(R.id.acil_durumlarda_ihtiyac_n_z_olanlar__size_ula_t_r_yoruz_);
		istockphoto_1009279168_170667a_1 = findViewById(R.id.istockphoto_1009279168_170667a_1);
		_bg__loginmainbutton_ek1 = findViewById(R.id._bg__loginmainbutton_ek1);
		rectangle_3 = findViewById(R.id.rectangle_3);
		giri__yap = findViewById(R.id.giri__yap);
		_bg__signupmainbutton_ek1 = findViewById(R.id._bg__signupmainbutton_ek1);
		rectangle_4 = findViewById(R.id.rectangle_4);
		kay_t_ol = findViewById(R.id.kay_t_ol);
		uygulama_nas_l_kullan_l_r = findViewById(R.id.uygulama_nas_l_kullan_l_r);

		// "Giriş Yap" butonuna tıklama dinleyici ekleyelim
		giri__yap.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// login_menu_activity adlı yeni aktiviteyi başlatmak için Intent
				Intent intent = new Intent(start_menu_activity.this, login_menu_activity.class);
				startActivity(intent);
			}
		});

		// kayıt ol tusuna basıldıgında kayıt ol eklenıcek
		kay_t_ol.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// login_menu_activity adlı yeni aktiviteyi başlatmak için Intent
				Intent intent = new Intent(start_menu_activity.this, signup_menu_activity.class);
				startActivity(intent);
			}
		});

		// uygulama nasıl kullanılır

		uygulama_nas_l_kullan_l_r.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// login_menu_activity adlı yeni aktiviteyi başlatmak için Intent
				Intent intent = new Intent(start_menu_activity.this, howtouse_menu_activity.class);
				startActivity(intent);
			}
		});
	}
}
