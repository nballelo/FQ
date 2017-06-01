package edu.upc.eetac.dsa.fq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void LogIn(View view) {
        EditText name=(EditText) findViewById(R.id.editText);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Service.URL).addConverterFactory(GsonConverterFactory.create()).build();
        Service service = retrofit.create(Service.class);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        Call<User>callUser=service.callUser(name.getText().toString());
        progressBar.setVisibility(View.VISIBLE);
            callUser.enqueue(new Callback<User>() {

               @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if(response.code()==200) {
                    User user=response.body();
                    Intent intent=new Intent(MainActivity.this,Menu.class);
                    intent.putExtra("User",(Serializable)user);
                    startActivity(intent);
                    }
                    else
                        Toast.makeText(MainActivity.this,"No se pudo conectar",Toast.LENGTH_SHORT).show();
                   progressBar.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this,"No se pudo conectar",Toast.LENGTH_SHORT).show();

                }
            });
    }
}
