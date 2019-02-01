package com.kudzai.stockapp;

/**
 * Created by Mitch on 2016-05-13.
 */
public class User {
    private String Fdate;
    private String Fitem;
    private String Fopening;

    public User(String date,String item, String opening){
        Fdate = date;
        Fitem = item;
        Fopening = opening;
    }

    public String getFirstName() {
        return Fdate;
    }

    public void setFirstName(String firstName) {
        Fdate = firstName;
    }

    public String getLastName() {
        return Fitem;
    }

    public void setLastName(String lastName) {
        Fitem = lastName;
    }

    public String getFavFood() {
        return Fopening;
    }

    public void setFavFood(String favFood) {
        Fopening = favFood;
    }
}
