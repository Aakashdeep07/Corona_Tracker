package com.noone.coronatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static Retrofit retrofit = null;
    private RecyclerView recyclerView = null;
    private TextView confirmed, active, recovered, deceased;
    CoronaAdapter coronaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        confirmed = (TextView) findViewById(R.id.confirmed_in);
        active = (TextView) findViewById(R.id.active_in);
        recovered = (TextView) findViewById(R.id.recovered_in);
        deceased = (TextView) findViewById(R.id.deceased_in);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        connectAndGetApiData();
    }

    public void connectAndGetApiData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(CoronaApiService.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            CoronaApiService coronaApiService = retrofit.create(CoronaApiService.class);
            Call<StateWiseDataWrapper> stateWiseDataWrapperCall = coronaApiService.getCoronaInfo();
            stateWiseDataWrapperCall.enqueue(new Callback<StateWiseDataWrapper>() {
                @Override
                public void onResponse(Call<StateWiseDataWrapper> call, Response<StateWiseDataWrapper> response) {
                    confirmed.setText("Confirmed : " + response.body().getData().getTotal().getConfirmed().toString());
                    active.setText("Active : " + response.body().getData().getTotal().getActive().toString());
                    recovered.setText("Recovered : " + response.body().getData().getTotal().getRecovered().toString());
                    deceased.setText("Deceased : " + response.body().getData().getTotal().getDeaths().toString());
                    List<Statewise> statewiseList = response.body().getData().getStatewise();
                    coronaAdapter = new CoronaAdapter(statewiseList, getApplicationContext(), R.layout.list_item_info);
                    recyclerView.setAdapter(coronaAdapter);
                    coronaAdapter.notifyDataSetChanged();

                }

                @Override
                public void onFailure(Call<StateWiseDataWrapper> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}