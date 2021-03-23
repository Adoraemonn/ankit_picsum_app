package com.example.image_gallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

import model.Landscapes;
import network.APIClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
        customAdapter = new CustomAdapter(MainActivity.this);
        gridView.setAdapter(customAdapter);
        makeNetworkCall();
    }

    private void makeNetworkCall() {
        Call<List<Landscapes>> call = APIClient.apIinterface().getLandscapes();
        call.enqueue(new Callback<List<Landscapes>>() {
            @Override
            public void onResponse(@Nullable Call<List<Landscapes>> call,@Nullable Response<List<Landscapes>> response) {
                handleNetworkResponse(response);
            }

            @Override
            public void onFailure(@Nullable Call<List<Landscapes>> call,@Nullable Throwable t) {
                Toast.makeText(getApplicationContext(), "An error Occured" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void handleNetworkResponse(Response<List<Landscapes>> response) {
        if (response.isSuccessful()) {
            customAdapter.addItems(response.body());
        } else {
            Toast.makeText(getApplicationContext(), "An error Occured", Toast.LENGTH_LONG).show();
        }
    }

}