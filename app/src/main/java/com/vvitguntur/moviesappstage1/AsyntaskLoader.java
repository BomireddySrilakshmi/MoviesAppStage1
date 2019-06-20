package com.vvitguntur.moviesappstage1;

import android.content.AsyncTaskLoader;
import android.content.Context;

public class AsyntaskLoader extends AsyncTaskLoader {
    public AsyntaskLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        return NetworkUtils.getMovieInfo1();
    }
}
