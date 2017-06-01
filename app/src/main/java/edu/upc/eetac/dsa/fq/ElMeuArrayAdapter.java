package edu.upc.eetac.dsa.fq;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ignacio on 31/05/2017.
 */

public class ElMeuArrayAdapter extends ArrayAdapter<User> {

    private final Activity context;
    private final List<User> users;

    public ElMeuArrayAdapter(Activity context, List<User> users) {
        super(context, R.layout.llistacos, users);
        this.context=context;
        this.users=users;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.llistacos, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.Text);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

        txtTitle.setText(users.get(position).getLogin());
        Picasso.with(getContext()).load(users.get(position).getAvatar_url()).into(imageView);
        return rowView;

    };
}