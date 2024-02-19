package com.example.exportaves;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login_menu_activity extends Activity {

	private EditText telefonEmailEditText;
	private EditText sifreEditText;
	private DatabaseReference database;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_menu);

		database = FirebaseDatabase.getInstance().getReference();
		telefonEmailEditText = findViewById(R.id.telefon_email_input);
		sifreEditText = findViewById(R.id.sifre_input);

		Button girisYapButton = findViewById(R.id.girisyap);
		girisYapButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				girisYapButtonClicked();
			}
		});

		Button kay_t_ol = findViewById(R.id.kay_t_ol);
		kay_t_ol.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Start the signup_menu_activity
				Intent intent = new Intent(login_menu_activity.this, signup_menu_activity.class);
				startActivity(intent);
			}
		});

		Button _ifremi_unuttum = findViewById(R.id._ifremi_unuttum);
		_ifremi_unuttum.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(login_menu_activity.this, forgot_password_activity.class);
				startActivity(intent);
			}
		});



	}

	private void girisYapButtonClicked() {
		final String kullaniciGirdisi = telefonEmailEditText.getText().toString();
		final String sifre = sifreEditText.getText().toString();

		if (kullaniciGirdisi.isEmpty() || sifre.isEmpty()) {
			Toast.makeText(this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
			return;
		}

		database.child("kullanicilar").addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
					Kullanici kullanici = userSnapshot.getValue(Kullanici.class);

					// Null kontrolü ekleyerek e-posta ve şifre karşılaştırması yapın
					if (kullanici != null && kullaniciGirdisi.equals(kullanici.getE_posta()) && sifre.equals(kullanici.getSifre())) {
						UserSession userSession = UserSession.getInstance();
						userSession.setUserData(userSnapshot.getKey(), kullanici.getAd_soyad(), kullanici.getE_posta());

						Intent intent = new Intent(login_menu_activity.this, button_main_activity.class);
						startActivity(intent);
						return;
					}
				}

				Toast.makeText(login_menu_activity.this, "Kullanıcı bulunamadı veya hatalı şifre", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				Toast.makeText(login_menu_activity.this, "Veritabanı hatası: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}
