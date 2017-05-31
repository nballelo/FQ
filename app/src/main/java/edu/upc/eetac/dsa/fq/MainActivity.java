package edu.upc.eetac.dsa.fq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void LogIn(View view) {
        EditText name=(EditText) findViewById(R.id.editText);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Service.URL).addConverterFactory(GsonConverterFactory.create()).build();
        Service service = retrofit.create(Service.class);
            Call<User>callUser=service.callUser(name.getText().toString());
            callUser.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User user=response.body();
                    Intent intent=new Intent(MainActivity.this,Menu.class);
                    intent.putExtra("User",(Serializable)user);
                    startActivity(intent);
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(MainActivity.this,"No se pudo conectar",Toast.LENGTH_SHORT).show();
                }
            });
            Toast.makeText(MainActivity.this,"Cargando",Toast.LENGTH_SHORT).show();
    }
}
