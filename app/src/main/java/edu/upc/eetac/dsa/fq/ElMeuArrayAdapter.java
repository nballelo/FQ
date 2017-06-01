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

public class ElMeuArrayAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final List<String> itemname;
    private final List<String> imgid;



    public ElMeuArrayAdapter(Activity context, List<String> itemname, List<String> imgid) {
        super(context, R.layout.llistacos, itemname);


        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.llistacos, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        txtTitle.setText(itemname.get(position));
        Picasso.with(getContext()).load(imgid.get(position)).into(imageView);
        return rowView;

    };
}