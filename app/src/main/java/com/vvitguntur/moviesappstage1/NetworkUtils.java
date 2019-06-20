package com.vvitguntur.moviesappstage1;

import android.net.Uri;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class NetworkUtils
{
    private static final String BASE_URI =
            "https://api.themoviedb.org/3/movie/";
    private static final String KEY = "api_key";
    public  static String getQuery;
    public  static  void query(String value)
    {
        getQuery=value;
    }
    public static Uri buildUri()
    {
        Uri finalUri = Uri.parse(BASE_URI).buildUpon()
                .appendPath(getQuery)
                .appendQueryParameter(KEY,"c2b6226475df2f71cc1497d17ade7431")
                .build();
        return finalUri;
    }
    public static String getMovieInfo1(){
        try{

            URL requestURL = new URL(buildUri().toString());
            HttpsURLConnection urlConnection = (HttpsURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }
            return buffer.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
