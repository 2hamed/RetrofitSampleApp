package com.hmomeni.retrofitsampleapp;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hamed on 2/13/18.in RetrofitSampleApp
 */

public class MyApp extends Application {
	private static MyApi myApi;
	private static Retrofit retrofit;

	@Override
	public void onCreate() {
		super.onCreate();
		createMyRetrofitInstance();
	}

	private void createMyRetrofitInstance() {
		retrofit = new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		myApi = retrofit.create(MyApi.class);
	}

	public static MyApi getMyApi() {
		return myApi;
	}

	public static Retrofit getRetrofit() {
		return retrofit;
	}
}
