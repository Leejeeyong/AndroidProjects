package com.example.retrofit2test001;

public class Data {

    private final String id;
    private final String name;
    private final String tel;

    public Data(String id, String name, String tel){
        this.id = id;
        this.name = name;
        this.tel = tel;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getTel(){
        return tel;
    }
}
