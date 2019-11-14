package com.example.retrofitexample002;

import io.realm.RealmObject;

public class LocalDB extends RealmObject {

    private int num;
    private String title;
    private String carrier;
    private String track_number;


    public int getNum(){return num;}
    public void setNum(int num){this.num = num;}

    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}

    public String getCarrier(){return carrier;}
    public void setCarrier(String carrier){this.carrier=carrier;}

    public String getTracknum(){return track_number;}
    public void setTrack_number(String track_number){this.track_number=track_number;}

}
