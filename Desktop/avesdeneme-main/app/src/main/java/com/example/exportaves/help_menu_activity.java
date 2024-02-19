package com.example.exportaves;

import android.location.Location;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import androidx.annotation.NonNull;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;
import android.widget.Toast;

public class help_menu_activity extends Activity {

	private View _bg__help_menu;
	private TextView belediye_hizmet_binas__k_tahya_merkez;
	private TextView adres_;
	private View _bg__sendbutton_ek1;
	private View rectangle_3;
	private TextView g_nder;
	private ImageView polygon_1;
	private View _bg__option1_ek1;
	private View ellipse_1;
	private View ellipse_2;
	private TextView yiyecek;
	private ImageView unsplash_uc0hzduitwy;
	private View _bg__option2_ek1;
	private View ellipse_1_ek1;
	private View ellipse_2_ek1;
	private TextView _ad_r;
	private ImageView unsplash_uc0hzduitwy_ek1;
	private View _bg__option3_ek1;
	private View ellipse_1_ek2;
	private View ellipse_2_ek2;
	private TextView k_yafet;
	private ImageView unsplash_uc0hzduitwy_ek2;
	private View _bg__option4_ek1;
	private View ellipse_1_ek3;
	private View ellipse_2_ek3;
	private TextView battaniye;
	private ImageView unsplash_uc0hzduitwy_ek3;
	private View _bg__option5_ek1;
	private View ellipse_1_ek4;
	private View ellipse_2_ek4;
	private TextView _lk_yard_m_kiti;
	private ImageView unsplash_uc0hzduitwy_ek4;
	private View _bg__option6_ek1;
	private View ellipse_1_ek5;
	private View ellipse_2_ek5;
	private TextView hijyen_malzemesi;
	private ImageView unsplash_uc0hzduitwy_ek5;
	private TextView _6__r_n_se_ildi;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help_menu);

		_bg__help_menu = findViewById(R.id._bg__help_menu);
		belediye_hizmet_binas__k_tahya_merkez = findViewById(R.id.belediye_hizmet_binas__k_tahya_merkez);
		adres_ = findViewById(R.id.adres_);
		_bg__sendbutton_ek1 = findViewById(R.id._bg__sendbutton_ek1);
		rectangle_3 = findViewById(R.id.rectangle_3);
		g_nder = findViewById(R.id.g_nder);
		polygon_1 = findViewById(R.id.polygon_1);
		_bg__option1_ek1 = findViewById(R.id._bg__option1_ek1);
		ellipse_1 = findViewById(R.id.ellipse_1);
		ellipse_2 = findViewById(R.id.ellipse_2);
		yiyecek = findViewById(R.id.yiyecek);
		unsplash_uc0hzduitwy = findViewById(R.id.unsplash_uc0hzduitwy);
		_bg__option2_ek1 = findViewById(R.id._bg__option2_ek1);
		ellipse_1_ek1 = findViewById(R.id.ellipse_1_ek1);
		ellipse_2_ek1 = findViewById(R.id.ellipse_2_ek1);
		_ad_r = findViewById(R.id._ad_r);
		unsplash_uc0hzduitwy_ek1 = findViewById(R.id.unsplash_uc0hzduitwy_ek1);
		_bg__option3_ek1 = findViewById(R.id._bg__option3_ek1);
		ellipse_1_ek2 = findViewById(R.id.ellipse_1_ek2);
		ellipse_2_ek2 = findViewById(R.id.ellipse_2_ek2);
		k_yafet = findViewById(R.id.k_yafet);
		unsplash_uc0hzduitwy_ek2 = findViewById(R.id.unsplash_uc0hzduitwy_ek2);
		_bg__option4_ek1 = findViewById(R.id._bg__option4_ek1);
		ellipse_1_ek3 = findViewById(R.id.ellipse_1_ek3);
		ellipse_2_ek3 = findViewById(R.id.ellipse_2_ek3);
		battaniye = findViewById(R.id.battaniye);
		unsplash_uc0hzduitwy_ek3 = findViewById(R.id.unsplash_uc0hzduitwy_ek3);
		_bg__option5_ek1 = findViewById(R.id._bg__option5_ek1);
		ellipse_1_ek4 = findViewById(R.id.ellipse_1_ek4);
		ellipse_2_ek4 = findViewById(R.id.ellipse_2_ek4);
		_lk_yard_m_kiti = findViewById(R.id._lk_yard_m_kiti);
		unsplash_uc0hzduitwy_ek4 = findViewById(R.id.unsplash_uc0hzduitwy_ek4);
		_bg__option6_ek1 = findViewById(R.id._bg__option6_ek1);
		ellipse_1_ek5 = findViewById(R.id.ellipse_1_ek5);
		ellipse_2_ek5 = findViewById(R.id.ellipse_2_ek5);
		hijyen_malzemesi = findViewById(R.id.hijyen_malzemesi);
		unsplash_uc0hzduitwy_ek5 = findViewById(R.id.unsplash_uc0hzduitwy_ek5);
		_6__r_n_se_ildi = findViewById(R.id._6__r_n_se_ildi);

		g_nder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (ellipse_2.getVisibility() == View.VISIBLE) {
					sendToDatabase("yiyecek");
				}
				if (ellipse_2_ek1.getVisibility() == View.VISIBLE) {
					sendToDatabase("_ad_r");
				}
				if (ellipse_2_ek2.getVisibility() == View.VISIBLE) {
					sendToDatabase("k_yafet");
				}
				if (ellipse_2_ek3.getVisibility() == View.VISIBLE) {
					sendToDatabase("battaniye");
				}
				if (ellipse_2_ek4.getVisibility() == View.VISIBLE) {
					sendToDatabase("_lk_yard_m_kiti");
				}
				if (ellipse_2_ek5.getVisibility() == View.VISIBLE) {
					sendToDatabase("hijyen_malzemesi");
				}

				Intent intent = new Intent(help_menu_activity.this, last_screen_activity.class);
				startActivity(intent);
			}
		});

		_bg__option1_ek1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleVisibility(ellipse_2);
			}
		});

		_bg__option2_ek1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleVisibility(ellipse_2_ek1);
			}
		});

		_bg__option3_ek1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleVisibility(ellipse_2_ek2);
			}
		});

		_bg__option4_ek1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleVisibility(ellipse_2_ek3);
			}
		});

		_bg__option5_ek1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleVisibility(ellipse_2_ek4);
			}
		});

		_bg__option6_ek1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleVisibility(ellipse_2_ek5);
			}
		});
	}

	private void sendToDatabase(String product) {
		UserSession userSession = UserSession.getInstance();
		String userId = userSession.getUserId();

		Location userLocation = userSession.getUserLocation();

		double latitude = userLocation.getLatitude();//usersessionda topladığımız verileri çekiyoruz
		double longitude = ((Location) userLocation).getLongitude();

		DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("istenen_urunler").child(userId).child("konum");

		Map<String, Object> veriMap = new HashMap<>();
		veriMap.put("latitude", latitude); // Enlem bilgisini ekle userSession dan aldık
		veriMap.put("longitude", longitude); // Boylam bilgisini ekle  userSession dan aldık
		veriMap.put(product, true); // Ürün adını anahtar olarak kullan ve değeri true olarak ayarla

		databaseReference.updateChildren(veriMap)
				.addOnSuccessListener(new OnSuccessListener<Void>() {
					@Override
					public void onSuccess(Void aVoid) {
						showToast("Veri başarıyla gönderildi.");
					}
				})
				.addOnFailureListener(new OnFailureListener() {
					@Override
					public void onFailure(@NonNull Exception e) {
					}
				});
	}






	private void showToast(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	private void toggleVisibility(View view) {
		if (view.getVisibility() == View.VISIBLE) {
			view.setVisibility(View.GONE);
		} else {
			view.setVisibility(View.VISIBLE);
		}
	}
}
