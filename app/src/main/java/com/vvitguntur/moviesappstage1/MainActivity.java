package com.vvitguntur.moviesappstage1;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    RecyclerView recyclerView;
   GridLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyc);
        jsonparse("popular");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_resource, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Bundle bundle = new Bundle();
        switch(item.getItemId())
        {

            case R.id.popular:
                jsonparse("popular");
                break;
            case R.id.toprated:
                jsonparse("top_rated");
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void jsonparse(String popular) {
        NetworkUtils.query(popular);
        getLoaderManager().initLoader(0,null,this);
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new AsyntaskLoader(this);
    }

    @Override
    public void onLoadFinished(Loader loader,String data) {
        List<Pojo1> list=new ArrayList<>();
        if(data == null)
        {
            Toast.makeText(this, "No Data Fetched", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            JSONObject jsonObject=new JSONObject(data);
            JSONArray jsonArray1=jsonObject.getJSONArray("results");
            for(int i=0;i<jsonArray1.length();i++) {
                JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
                String title = jsonObject1.getString("title");
                String popularity = jsonObject1.getString("popularity");
                String poster = jsonObject1.getString("poster_path");
                String orgTitle = jsonObject1.getString("original_title");
                String release = jsonObject1.getString("release_date");
                String overview = jsonObject1.getString("overview");
                String rating =jsonObject1.getString("vote_average");
                int id=jsonObject1.getInt("id");
                Pojo1 pj = new Pojo1(title, popularity, poster, orgTitle, release, overview,rating,id);
                list.add(pj);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(this);
        recyclerAdapter.setPojo1s(list);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
