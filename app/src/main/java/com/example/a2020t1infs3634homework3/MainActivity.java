package com.example.a2020t1infs3634homework3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    Button mainRef;
    RecyclerView mainRv;
    Joke jokeLiu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainText = findViewById(R.id.main_text);
        mainRef = findViewById(R.id.main_ref);
        mainRv = findViewById(R.id.main_rv);

        Retrofit retrofitMike = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mainRv.setLayoutManager(new LinearLayoutManager(this));
        CateAdapter ad1 = new CateAdapter();
        ad1.setRetrofitMike(retrofitMike);
        ad1.setCurrActivity(this);
        mainRv.setAdapter(ad1);


        JokeService serviceTom = retrofitMike.create(JokeService.class);

        Call<Joke> travel1plan = serviceTom.getRandomJoke();

        travel1plan.enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                jokeLiu = response.body();
                mainText.setText(jokeLiu.value);
            }
            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
                System.out.println("Error Sir!");
            }
        });

        mainRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JokeService serviceAlan = retrofitMike.create(JokeService.class);
                Call<Joke> travel2plan = serviceAlan.getRandomJoke();
                travel2plan.enqueue(new Callback<Joke>() {
                    @Override
                    public void onResponse(Call<Joke> call, Response<Joke> response) {
                        jokeLiu = response.body();
                        mainText.setText(jokeLiu.value);
                    }
                    @Override
                    public void onFailure(Call<Joke> call, Throwable t) {
                        System.out.println("Error Sir!");
                    }
                });
            }
        });


    }
}
