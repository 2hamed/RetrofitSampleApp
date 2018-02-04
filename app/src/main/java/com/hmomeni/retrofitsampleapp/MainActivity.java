package com.hmomeni.retrofitsampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

		myApi.getPosts().enqueue(new Callback<List<Post>>() {
			@Override
			public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
				List<Post> posts = response.body();
			}

			@Override
			public void onFailure(Call<List<Post>> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}
}
