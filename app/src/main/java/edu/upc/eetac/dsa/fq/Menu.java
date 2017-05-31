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
    ElMeuArrayAdapter adapter;
    //ArrayAdapter adapter;
    Retrofit retrofit;
    ListView listView;
    List<String>followers= new ArrayList<String>();
    ArrayList<User>users =new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        retrofit = new Retrofit.Builder().baseUrl(Service.URL).addConverterFactory(GsonConverterFactory.create()).build();
        adapter= new ElMeuArrayAdapter(Menu.this,users);
        //adapter=new ArrayAdapter(Menu.this,android.R.layout.simple_list_item_1, followers);
        listView=(ListView)findViewById(R.id.list);
        user = (User) getIntent().getSerializableExtra("User");
        TextView name=(TextView)findViewById(R.id.NameText);
        TextView repos=(TextView)findViewById(R.id.ReposText);
        name.setText("Name: "+user.getLogin());
        repos.setText("Public repos: "+user.getPublic_repos());
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        Picasso.with(Menu.this).load(user.getAvatar_url()).into(imageView);
        lala();
       /* Service service = retrofit.create(Service.class);
        Call<List<User>>callUser=service.callFol(user.getLogin());

        callUser.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                users=(ArrayList<User>)response.body();
                List<User> compis=response.body();
                for (int i=0;i<compis.size();i++){
                    followers.add(compis.get(i).getLogin());
                }

                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(Menu.this,"No se pudo conectar",Toast.LENGTH_SHORT).show();
            }
        });*/
    }
    private void lala(){
        ArrayList<User>la=new ArrayList<User>();
        User us=new User();
        us.setLogin("adsa");
        us.setAvatar_url("https://avatars3.githubusercontent.com/u/25772951?v=3");
        la.add(us);
        ElMeuArrayAdapter adapter1=new ElMeuArrayAdapter(Menu.this,la);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter1);
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
