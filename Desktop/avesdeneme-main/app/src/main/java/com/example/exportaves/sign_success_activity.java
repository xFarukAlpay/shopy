
	 
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

		View rectangle_3 = (View) findViewById(R.id.rectangle_3);
		TextView devam_et = (TextView) findViewById(R.id.devam_et);
		TextView kay_t_oldunuz_tesekk_rler = (TextView) findViewById(R.id.kay_t_oldunuz_tesekk_rler);


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
	
	