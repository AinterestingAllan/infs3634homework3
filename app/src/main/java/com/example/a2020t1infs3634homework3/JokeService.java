package com.example.a2020t1infs3634homework3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface JokeService {

    // https://api.chucknorris.io/jokes/random
    @GET("jokes/random")
    Call<Joke> getRandomJoke();

    // https://api.chucknorris.io/jokes/random?category=animal
    @GET("jokes/random")
    Call<Joke> getCateJoke(@Query ("category") String category);
//    @GET("jokes")
//    Call<List<Joke>> getAllJokes();
//
//    @GET("jokes/{id}")
//    Call<Joke> getJokeById2(@Path ("id") int id);
//
//    @POST("jokes")
//    Call<Joke> createJoke(@Body Joke joke);
}
