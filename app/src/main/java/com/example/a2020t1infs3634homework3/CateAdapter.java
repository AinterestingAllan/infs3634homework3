package com.example.a2020t1infs3634homework3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CateAdapter extends RecyclerView.Adapter<CateAdapter.CateViewHolder> {
    static ArrayList<String> data = new ArrayList<>();
    private Retrofit retrofitMike;
    private MainActivity currActivity;

    public void setRetrofitMike(Retrofit retrofitMike) {
        this.retrofitMike = retrofitMike;
    }

    public void setCurrActivity(MainActivity currActivity) {
        this.currActivity = currActivity;
    }

    static {
        data.add("animal");
        data.add("career");
        data.add("celebrity");
        data.add("dev");
        data.add("explicit");
    }

    @NonNull
    @Override
    public CateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cate_holder, parent, false);
        return new CateViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CateViewHolder holder, int position) {
        holder.cateName.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class CateViewHolder extends RecyclerView.ViewHolder {
        TextView cateName;

        public CateViewHolder(@NonNull View itemView) {
            super(itemView);
            cateName = itemView.findViewById(R.id.cate_holder_catename);
            cateName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 被点击之后应该访问网络然后获得一个joke之后将它展示出来
                    JokeService serviceAlan = retrofitMike.create(JokeService.class);
                    Call<Joke> travelplan = serviceAlan.getCateJoke(cateName.getText().toString());
                    travelplan.enqueue(new Callback<Joke>() {
                        @Override
                        public void onResponse(Call<Joke> call, Response<Joke> response) {
                            Joke jokeLiu = response.body();
                            currActivity.mainText.setText(jokeLiu.value);
                        }
                        @Override
                        public void onFailure(Call<Joke> call, Throwable t) {
                        }
                    });

                }
            });
        }
    }


}
