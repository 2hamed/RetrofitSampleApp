package com.hmomeni.retrofitsampleapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
	Retrofit retrofit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MyApp.getMyApi().getPosts().enqueue(new Callback<List<Post>>() {
			@Override
			public void onResponse(@NonNull Call<List<Post>> call,
			                       @NonNull Response<List<Post>> response) {
				List<Post> posts = response.body();
			}

			@Override
			public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
				t.printStackTrace();
			}
		});
	}
}
