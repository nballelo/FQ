package edu.upc.eetac.dsa.fq;

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
    private final Context context;
    private final ArrayList<User>values;
    public ElMeuArrayAdapter(Context context, ArrayList<User> values){
        super(context,R.layout.llistacos,values);
        this.context=context;
        this.values=values;
    }
    @Override
    public int getCount() {
        int count=values.size(); //counts the total number of elements from the arrayList.
        return count;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /* (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.llistacos, parent, false);

        }*/
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=layoutInflater.inflate(R.layout.llistacos,null);
        User user=getItem(position);
        TextView textView=(TextView)convertView.findViewById(R.id.textView2);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);
        textView.setText(user.getLogin());
        Picasso.with(context).load(user.getAvatar_url()).into(imageView);

        return rowView;
    }
}
