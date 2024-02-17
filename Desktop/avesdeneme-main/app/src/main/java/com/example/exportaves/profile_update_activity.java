
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		profile_update
	 *	@date 		Tuesday 19th of December 2023 08:26:22 PM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package com.example.exportaves;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class profile_update_activity extends Activity {


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_update);


		View _bg__profile_update = (View) findViewById(R.id._bg__profile_update);

		View rectangle_3 = (View) findViewById(R.id.rectangle_3);
		TextView tamam = (TextView) findViewById(R.id.tamam);
		View rectangle_32 = (View) findViewById(R.id.rectangle_32);
		TextView adres_1 = (TextView) findViewById(R.id.adres_1);

		ImageView vector = (ImageView) findViewById(R.id.vector);
		ImageView polygon_2 = (ImageView) findViewById(R.id.polygon_2);
		View rectangle_33 = (View) findViewById(R.id.rectangle_33);
		TextView adres_2 = (TextView) findViewById(R.id.adres_2);

		ImageView vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
		ImageView polygon_3 = (ImageView) findViewById(R.id.polygon_3);
	
		
		//custom code goes here
		tamam.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// login_menu_activity adlı yeni aktiviteyi başlatmak için Intent
				Intent intent = new Intent(profile_update_activity.this, button_main_activity.class);
				startActivity(intent);
			}
		});

	}
}
	
	