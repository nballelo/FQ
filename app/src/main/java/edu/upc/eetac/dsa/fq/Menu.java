package edu.upc.eetac.dsa.fq;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.app.ListActivity;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Menu extends AppCompatActivity {
    User user;
    //ArrayAdapter adapter;
    Retrofit retrofit;
    ProgressBar progressBar;
    List<String>followers= new ArrayList<String>();
    ArrayList<User>users =new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        retrofit = new Retrofit.Builder().baseUrl(Service.URL).addConverterFactory(GsonConverterFactory.create()).build();
        progressBar=(ProgressBar)findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.VISIBLE);
        user = (User) getIntent().getSerializableExtra("User");
        TextView name=(TextView)findViewById(R.id.NameText);
        TextView repos=(TextView)findViewById(R.id.ReposText);
        name.setText("Name: "+user.getLogin());
        repos.setText("Public repos: "+user.getPublic_repos());
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        Picasso.with(Menu.this).load(user.getAvatar_url()).into(imageView);
        Service service = retrofit.create(Service.class);
        Call<List<User>>callUser=service.callFol(user.getLogin());
        callUser.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.code()==200){
                    List<User> followers = (List<User>)response.body();
                    ListView listView = (ListView) findViewById(R.id.list);

                    ElMeuArrayAdapter adapter=new ElMeuArrayAdapter(Menu.this, followers);
                    listView.setAdapter(adapter);
                }
                else {
                    Toast.makeText(Menu.this, "Ha habido un error : "+response.code(), Toast.LENGTH_SHORT).show();
                    Menu.this.finish();
                }
                progressBar.setVisibility(View.INVISIBLE);

            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(Menu.this,"No se pudo conectar",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
