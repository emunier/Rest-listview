package org.libreapps.rest;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.libreapps.rest.obj.Product;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {

    private ArrayList<Product> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext, ArrayList<Product> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_custom_list_view, null);
            holder = new ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.textId);
            holder.name = (TextView) convertView.findViewById(R.id.textName);
            holder.type = (TextView) convertView.findViewById(R.id.textType);
            holder.price = (TextView) convertView.findViewById(R.id.textPrice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if(position % 2 == 0){
            convertView.setBackgroundColor(Color.rgb(150,245,170));
        }

        Product product = this.listData.get(position);
        holder.id.setText(""+product.getId());
        holder.name.setText(product.getName());
        holder.type.setText(product.getType());
        holder.price.setText(""+product.getPrice());
        return convertView;
    }

    static class ViewHolder {
        TextView id;
        TextView name;
        TextView type;
        TextView price;
    }

    public int getCount() { return (listData!=null)?listData.size():0; }
    public Object getItem(int position) {
        return listData.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
}