package com.mobilsiparis.helper;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 25.03.2014
 * Time: 15:11
 * To change this template use File | Settings | File Templates.
 */
public class Vote {
    private String urunAdi;
    private int vote;

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public Vote(String urunAdi) {
        this.urunAdi = urunAdi;
    }
}
