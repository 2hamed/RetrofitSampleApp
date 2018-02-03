package com.hmomeni.retrofitsampleapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hamed on 2/3/18.
 */

public interface MyApi {
	@GET("posts")
	Call<List<Post>> getPosts();
}
