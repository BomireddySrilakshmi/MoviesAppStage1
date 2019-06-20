package com.vvitguntur.moviesappstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {
    TextView title2;
    TextView org_title;
    TextView popularly;
    TextView  Descrip;
    TextView  release_date;
    TextView vote_rate;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        Pojo1 pojo = (Pojo1) intent.getSerializableExtra("details");
        title2 = findViewById(R.id.title1);
        org_title = findViewById(R.id.orig_title);
        popularly = findViewById(R.id.popularity);
        Descrip = findViewById(R.id.description);
        release_date=findViewById(R.id.release);
        vote_rate=findViewById(R.id.vote);
        img = findViewById(R.id.image);
        Picasso.get().load("http://image.tmdb.org/t/p/w342"+pojo.getPoster()).into(img);
        title2.append(pojo.getTitle());
        org_title.append(pojo.getOrgTitle());
        popularly.append(pojo.getPopularity());
        vote_rate.append(pojo.getRate());
        release_date.append(pojo.getRelease());
        Descrip.append(pojo.getOverview());


    }
}
