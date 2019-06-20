package com.vvitguntur.moviesappstage1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder2> {
    List<Pojo1> pojo1s;
    Context context;
    public RecyclerViewAdapter(Context context) {
        pojo1s= new ArrayList<>();
        this.context=context;
    }
    public void setPojo1s(List<Pojo1> pojo1s) {
        this.pojo1s=(pojo1s);
    }
    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View textView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_adapter, parent, false);

        return new ViewHolder2(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 holder, int position) {

        Pojo1 pj=pojo1s.get(position);
        String s="http://image.tmdb.org/t/p/w342"+pj.getPoster();
        Picasso.get().load(s)
                .into(holder.imageViewIcon);
        holder.imageViewIcon.setTag(position);
    }

    @Override
    public int getItemCount() {
        return pojo1s.size();
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageViewIcon;
        public ViewHolder2(View itemView) {
            super(itemView);
            imageViewIcon = (ImageView) itemView.findViewById(R.id.image6);
            imageViewIcon.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Pojo1 pojo1=pojo1s.get(position);
            Intent intent=new Intent(context,SecondActivity.class);
            intent.putExtra("details",pojo1);
            context.startActivity(intent);
        }
    }
}
