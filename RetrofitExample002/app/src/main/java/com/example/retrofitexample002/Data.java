package com.example.retrofitexample002;

import com.google.gson.annotations.Expose;
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

    /////////////////////////////////////////////////////
    public class From{
        @SerializedName("name") String name;
        @SerializedName("time") String time;

        public String getName() { return name; }
        public String getTime() { return time; }
    }
    /////////////////////////////////////////////////////
    public class To{
        @SerializedName("name") String name;
        @SerializedName("time") String time;

        public String getName() { return name; }
        public String getTime() { return time; }
    }
    /////////////////////////////////////////////////////
    public class State{
        @SerializedName("id") String id;
        @SerializedName("text") String text;

        public String getId() { return id; }
        public String getText() { return text; }
    }
    /////////////////////////////////////////////////////
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
































    /*private final String id;
    private final String name;
    private final String tel;
    private final String time;
    private final String text;
    private final String description;
    private final List<Prog> progress;
    private final List<NameTime> from;
    private final List<NameTime> to;
    private final List<IdText> status;


    public Data(String id, String name, String tel, String time, String text, String description,List<Prog> progress, List<NameTime> from,List<NameTime> to, List<IdText> status){
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.time = time;
        this.text = text;
        this.description = description;
        this.progress =progress;
        this.from=from;
        this.to=to;
        this.status=status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getTime() {
        return time;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }

    public List<Prog> getProgress() {
        return progress;
    }

    public List<NameTime> getFrom() {
        return from;
    }

    public List<NameTime> getTo() {
        return to;
    }

    public List<IdText> getStatus() {
        return status;
    }

    public class NameTime{
        private String name;
        private String time;
    }
    public class IdText{
        private String id;
        private String text;
    }
    public class Name{
        private String name;
    }
    public class Prog {
        private String time;
        private List<IdText> status;
        private List<Name> locatiop;
        public Prog(){
            this.time=time;
        }
    }
     */
}
