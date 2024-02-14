package com.example.exportaves;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.Toast;
import android.content.Intent;

public class signup_menu_activity extends AppCompatActivity {
	private EditText adSoyadEditText, epostaEditText, telefonEditText, SehirEditText, adresEditText, adres2EditText, sifreEditText;
	private DatabaseReference database;
	public class Kullanici {
		private String ad_soyad;
		private String adres_1;
		private String adres_2;
		private String e_posta;
		private String sehir;
		private String sifre;
		private String telefon;

		// Boş constructor
		public Kullanici() {
		}

		// Getter ve Setter metotları
		public String getAd_soyad() {
			return ad_soyad;
		}

		public void setAd_soyad(String ad_soyad) {
			this.ad_soyad = ad_soyad;
		}

		public String getAdres_1() {
			return adres_1;
		}

		public void setAdres_1(String adres_1) {
			this.adres_1 = adres_1;
		}

		public String getAdres_2() {
			return adres_2;
		}

		public void setAdres_2(String adres_2) {
			this.adres_2 = adres_2;
		}

		public String getE_posta() {
			return e_posta;
		}

		public void setE_posta(String e_posta) {
			this.e_posta = e_posta;
		}

		public String getSehir() {
			return sehir;
		}

		public void setSehir(String sehir) {
			this.sehir = sehir;
		}

		public String getSifre() {
			return sifre;
		}

		public void setSifre(String sifre) {
			this.sifre = sifre;
		}

		public String getTelefon() {
			return telefon;
		}

		public void setTelefon(String telefon) {
			this.telefon = telefon;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup_menu);
		FirebaseApp.initializeApp(this);
		database = FirebaseDatabase.getInstance().getReference();
		adSoyadEditText = findViewById(R.id.ad_soyad_input);
		epostaEditText = findViewById(R.id.e_posta_input);
		telefonEditText = findViewById(R.id.telefon);
		SehirEditText = findViewById(R.id.sehir_input);
		adresEditText = findViewById(R.id.adres_1_input);
		adres2EditText = findViewById(R.id.adres_2_input);
		sifreEditText = findViewById(R.id.sifre_input);
	}

	public void ekleButtonClicked(View view) {
		String adSoyad = adSoyadEditText.getText().toString();
		String email = epostaEditText.getText().toString();
		String telefon = telefonEditText.getText().toString();
		String Sehir = SehirEditText.getText().toString();
		String adres = adresEditText.getText().toString();
		String adres2 = adres2EditText.getText().toString();
		String sifre = sifreEditText.getText().toString();

		if (adSoyad.isEmpty() || email.isEmpty() || telefon.isEmpty() ||
				Sehir.isEmpty() || adres.isEmpty() || adres2.isEmpty() || sifre.isEmpty()) {
			Toast.makeText(this, "Tüm alanları doldurmalısınız", Toast.LENGTH_SHORT).show();
			return;
		}

		// Kullanıcı sınıfını kullanarak nesne oluştur
		Kullanici kullanici = new Kullanici();
		kullanici.setAd_soyad(adSoyad);
		kullanici.setE_posta(email);
		kullanici.setTelefon(telefon);
		kullanici.setSehir(Sehir);
		kullanici.setAdres_1(adres);
		kullanici.setAdres_2(adres2);
		kullanici.setSifre(sifre);

		// Kullanıcı adı ve soyadının kombinasyonunu ID olarak kullanarak veritabanına ekleme// Kullanıcı adı ve soyadının kombinasyonunu ID olarak kullanarak veritabanına ekleme
		String adSoyadID = adSoyad.replace(" ", "_"); // Boşlukları alt çizgi ile değiştir
		DatabaseReference yeniKayit = database.child("kullanicilar").child(adSoyadID);
		yeniKayit.setValue(kullanici);

		Intent intent = new Intent(signup_menu_activity.this, sign_success_activity.class);
		startActivity(intent);
	}
}
