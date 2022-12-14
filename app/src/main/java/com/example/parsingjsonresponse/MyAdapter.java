package com.example.parsingjsonresponse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

   private LayoutInflater myinflater;
    private List<Model> mydata;

    public MyAdapter(Context cxt , List<Model>data){
        this.myinflater=LayoutInflater.from(cxt);
        this.mydata=data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=myinflater.inflate(R.layout.add_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView1.setText(mydata.get(position).getName());
        holder.textView2.setText(mydata.get(position).getBrand());
        holder.textView3.setText(mydata.get(position).getAlcohol());

    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
         TextView textView1,textView2,textView3 ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.tv1);
            textView2=itemView.findViewById(R.id.tv2);
            textView3=itemView.findViewById(R.id.tv3);
        }
    }
}
