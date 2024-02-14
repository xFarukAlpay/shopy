
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		sign_success
	 *	@date 		Tuesday 19th of December 2023 05:25:46 PM
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

public class sign_success_activity extends Activity {


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_success);


		View _bg__sign_success = (View) findViewById(R.id._bg__sign_success);
		View _bg__continuebutton_ek1 = (View) findViewById(R.id._bg__continuebutton_ek1);
		View rectangle_3 = (View) findViewById(R.id.rectangle_3);
		TextView devam_et = (TextView) findViewById(R.id.devam_et);
		TextView kay_t_oldunuz_tesekk_rler = (TextView) findViewById(R.id.kay_t_oldunuz_tesekk_rler);
		View _bg__login_1_ek1 = (View) findViewById(R.id._bg__login_1_ek1);
		ImageView vector = (ImageView) findViewById(R.id.vector);
		ImageView vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
		ImageView vector_ek2 = (ImageView) findViewById(R.id.vector_ek2);
		ImageView vector_ek3 = (ImageView) findViewById(R.id.vector_ek3);
		ImageView vector_ek4 = (ImageView) findViewById(R.id.vector_ek4);
		ImageView vector_ek5 = (ImageView) findViewById(R.id.vector_ek5);
		ImageView vector_ek6 = (ImageView) findViewById(R.id.vector_ek6);
		ImageView vector_ek7 = (ImageView) findViewById(R.id.vector_ek7);
		ImageView vector_ek8 = (ImageView) findViewById(R.id.vector_ek8);
		ImageView vector_ek9 = (ImageView) findViewById(R.id.vector_ek9);
		ImageView vector_ek10 = (ImageView) findViewById(R.id.vector_ek10);
		ImageView vector_ek11 = (ImageView) findViewById(R.id.vector_ek11);
		ImageView vector_ek12 = (ImageView) findViewById(R.id.vector_ek12);
		ImageView vector_ek13 = (ImageView) findViewById(R.id.vector_ek13);
		ImageView vector_ek14 = (ImageView) findViewById(R.id.vector_ek14);
		ImageView vector_ek15 = (ImageView) findViewById(R.id.vector_ek15);
		ImageView vector_ek16 = (ImageView) findViewById(R.id.vector_ek16);
		ImageView vector_ek17 = (ImageView) findViewById(R.id.vector_ek17);
		ImageView vector_ek18 = (ImageView) findViewById(R.id.vector_ek18);
		ImageView vector_ek19 = (ImageView) findViewById(R.id.vector_ek19);
		ImageView vector_ek20 = (ImageView) findViewById(R.id.vector_ek20);
		ImageView vector_ek21 = (ImageView) findViewById(R.id.vector_ek21);
		ImageView vector_ek22 = (ImageView) findViewById(R.id.vector_ek22);
		ImageView vector_ek23 = (ImageView) findViewById(R.id.vector_ek23);
		ImageView vector_ek24 = (ImageView) findViewById(R.id.vector_ek24);

		devam_et.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// login_menu_activity adlı yeni aktiviteyi başlatmak için Intent
				Intent intent = new Intent(sign_success_activity.this, login_menu_activity.class);
				startActivity(intent);
			}
		});
		//custom code goes here
	
	}
}
	
	