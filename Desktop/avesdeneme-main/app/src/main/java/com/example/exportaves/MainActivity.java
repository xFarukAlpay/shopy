package com.example.exportaves;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText adSoyadEditText, telefonEditText, SehirEditText, adresEditText;
    private DatabaseReference database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_menu);
        // Firebase'in initializeApp metodu ile başlatılması
        FirebaseApp.initializeApp(this);

        // DatabaseReference tanımlanması
        database = FirebaseDatabase.getInstance().getReference();

        // EditText öğelerini tanımlama
        adSoyadEditText = findViewById(R.id.ad_soyad_input);
        telefonEditText = findViewById(R.id.telefon);
        SehirEditText = findViewById(R.id.sehir_input);
        adresEditText = findViewById(R.id.adres_1_input); // adres_1_input öğesini tanımla
    }
    // Veritabanına veri eklemek için çağrılan fonksiyon
    public void ekleButtonClicked(View view) {
        // EditText'lerden değerleri al
        String adSoyad = adSoyadEditText.getText().toString();
        String telefon = telefonEditText.getText().toString();
        String Sehir = SehirEditText.getText().toString();
        String adres = adresEditText.getText().toString();

        // Firebase veritabanına ekleme işlemi
        DatabaseReference yeniKayit = database.push(); // Yeni bir referans al
        yeniKayit.child("ad_soyad").setValue(adSoyad);
        yeniKayit.child("telefon").setValue(telefon);
        yeniKayit.child("sehir").setValue(Sehir);
        yeniKayit.child("adres_1").setValue(adres);
    }


}
