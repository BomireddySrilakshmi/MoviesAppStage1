package com.vvitguntur.moviesappstage1;

import java.io.Serializable;

public class Pojo1 implements Serializable
{
    String title,popularity,poster,orgTitle,release,overview,rate;
    int id;
    public  Pojo1(String tit, String pop, String pos, String orgt, String release, String overview, String rate, int id)
    {
        title = tit;
        popularity = pop;
        poster = pos;
        orgTitle = orgt;
        this.release = release;
        this.overview = overview;
        this.rate=rate;
        this.id=id;
    }

    public String getRate() {
        return rate;
    }

    public String getTitle() {
        return title;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getPoster() {
        return poster;
    }

    public String getOrgTitle() {
        return orgTitle;
    }

    public String getRelease() {
        return release;
    }

    public String getOverview() {
        return overview;
    }

    public int getId() {
        return id;
    }
}
