package com.example.exportaves;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;


public class button_main_activity extends Activity {
	private FusedLocationProviderClient fusedLocationClient;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.button_main);
		checkLocationPermission();

		View _bg__button_main = findViewById(R.id._bg__button_main);
		View _bg__circle_ek1 = findViewById(R.id._bg__circle_ek1);
		ImageView icon_08 = findViewById(R.id.icon_08);
		TextView yardim__ste = findViewById(R.id.yardim__ste);
		TextView adres_bilgilerimi_g_ncelle = findViewById(R.id.adres_bilgilerimi_g_ncelle);

		fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

		// kayıt ol tusuna basıldığında kayıt ol eklenıcek
		adres_bilgilerimi_g_ncelle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// login_menu_activity adlı yeni aktiviteyi başlatmak için Intent
				Intent intent = new Intent(button_main_activity.this, profile_update_activity.class);
				startActivity(intent);
			}
		});

		_bg__circle_ek1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// login_menu_activity adlı yeni aktiviteyi başlatmak için Intent
				Intent intent = new Intent(button_main_activity.this, help_menu_activity.class);
				startActivity(intent);

				// Burada sendLocationToFirebase metodunu çağırabilirsiniz.
				checkAndSendLocation();
			}
		});

		//custom code goes here
	}

	private void sendLocationToFirebase() {
		// Konum bilgisini al
		if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
				&& ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

			return;
		}

		// Null kontrolü ekleyin
		if (fusedLocationClient == null) {
			fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
		}
		fusedLocationClient.getLastLocation()
				.addOnSuccessListener(this, location -> {
					if (location != null) {
						double latitude = location.getLatitude();
						double longitude = location.getLongitude();

						// Firebase veritabanına konum bilgisini gönder
						sendLocationToFirebaseDatabase(latitude, longitude);
					}
				})
				.addOnFailureListener(this, e -> {
					// Konum bilgisini alırken bir hata oluştu.
				});
	}

	private void sendLocationToFirebaseDatabase(double latitude, double longitude) {
		// Firebase veritabanına bağlan
		DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("kullanici_konumlar");
		GeoFire geoFire = new GeoFire(databaseReference);

		// Konum bilgisini Firebase'e gönder
		geoFire.setLocation("kullanici_id", new GeoLocation(latitude, longitude), (key, error) -> {
			if (error == null) {
				// Konum başarıyla gönderildi.
				// İstediğiniz ek işlemleri burada gerçekleştirebilirsiniz.
				Location userLocation = new Location("User Location");
				userLocation.setLatitude(latitude);
				userLocation.setLongitude(longitude);
				UserSession.setUserLocation(userLocation);
			} else {
				// Konum gönderme sırasında bir hata oluştu.
			}
		});
	}


	private void checkLocationPermission() {
		if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == android.content.pm.PackageManager.PERMISSION_GRANTED) {
			// İzin zaten varsa işlemlerinizi yapabilirsiniz.
			sendLocationToFirebase();
		} else {
			// İzin yoksa, kullanıcıdan izin iste
			ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
		}
	}

	private void checkAndSendLocation() {
		// Konum izni kontrolü
		if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			// İzin zaten varsa işlemlerinizi yapabilirsiniz.
			sendLocationToFirebase();
		} else {
			// İzin yoksa, kullanıcıdan izin iste
			ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		if (requestCode == 1) {
			if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				// İzin verildiyse, işlemlerinizi gerçekleştirin
				sendLocationToFirebase();
			} else {
				// İzin reddedildiyse, kullanıcıyı bilgilendirin veya başka bir aksiyon alın
			}
		}
	}

	private static class SendLocationTask extends AsyncTask<Double, Void, Void> {
		@Override
		protected Void doInBackground(Double... params) {
			double latitude = params[0];
			double longitude = params[1];

			// Firebase veritabanına bağlan
			DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("kullanici_konumlar");
			GeoFire geoFire = new GeoFire(databaseReference);

			// Konum bilgisini Firebase'e gönder
			geoFire.setLocation("kullanici_id", new GeoLocation(latitude, longitude), (key, error) -> {
				if (error == null) {
					// Konum başarıyla gönderildi.
					// İstediğiniz ek işlemleri burada gerçekleştirebilirsiniz.
				} else {
					// Konum gönderme sırasında bir hata oluştu.
				}
			});

			return null;
		}

	}
}
