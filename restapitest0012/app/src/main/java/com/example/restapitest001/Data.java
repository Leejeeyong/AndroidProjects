package com.example.restapitest001;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    /////////////////Carriers List////////////////////////////////
    @SerializedName("id") String id;
    @SerializedName("name") String name;
    @SerializedName("tel") String tel;

    public String getId() { return id; }
    public String getName() { return name; }
    public String getTel() { return tel; }

    /////////////////Tracker////////////////////////////////
    ////////////////////////////////////////////////////////
    @SerializedName("from") From from;
    @SerializedName("to") To to;
    @SerializedName("state") State state;
    @SerializedName("progresses")
    public List<Progress> progress = new ArrayList<>();
    @SerializedName("carrier") Carrier carrier;

    //////////////보내는 사람 정보///////////////////////////////////////
    public class From{
        @SerializedName("name") String name;
        @SerializedName("time") String time;

        public String getName() { return name; }
        public String getTime() { return time; }
    }
    //////////////밥는 사람 정보///////////////////////////////////////
    public class To{
        @SerializedName("name") String name;
        @SerializedName("time") String time;

        public String getName() { return name; }
        public String getTime() { return time; }
    }
    //////////////현재 상태///////////////////////////////////////
    public class State{
        @SerializedName("id") String id;
        @SerializedName("text") String text;

        public String getId() { return id; }
        public String getText() { return text; }
    }
    /////////////진행 상황////////////////////////////////////////
    public class Progress{
        @SerializedName("time") String time;
        @SerializedName("location") Location location;
        @SerializedName("status") Status status;
        @SerializedName("description") String description;

        public String getTime() { return time; }
        public String getDescription() { return description; }


        public class Location{
            @SerializedName("name") String name;

            public String getName() { return name; }
        }
        public class Status{
            @SerializedName("id") String id;
            @SerializedName("text") String text;

            public String getId() { return id; }
            public String getText() { return text; }
        }

        public Progress.Location getLocation() {return location;}
        public Progress.Status getStatus() {return status;}

    }
    /////////////////////////////////////////////////////

    public class Carrier{
        @SerializedName("id") String id;
        @SerializedName("name") String name;
        @SerializedName("tel") String tel;

        public String getId() { return id; }
        public String getName() { return name; }
        public String getTel() { return tel; }
    }


    public From getFrom(){ return from;}
    public To getTo(){ return to;}
    public State getState() { return state; }
    public List<Progress> getProgress(){ return progress;}
    public Carrier getCarrier(){ return carrier; }

}
