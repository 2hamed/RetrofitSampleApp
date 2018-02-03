package com.hmomeni.retrofitsampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
	Retrofit retrofit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		retrofit = new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		MyApi myApi = retrofit.create(MyApi.class);
	}
}
