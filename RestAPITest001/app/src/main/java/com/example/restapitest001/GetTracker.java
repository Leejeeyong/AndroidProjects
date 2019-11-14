package com.example.restapitest001;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;

public class GetTracker {

    public GetTracker(){

    }

    public void GetTracker(String id){
        new GetTask().execute("https://apis.tracker.delivery/carriers");
    }

    //innerclass
    private class GetTask extends AsyncTask<String, Void, String>{
        protected String doInBackground(String... params){
            try{
                return GET(params[0]);
            }catch(IOException e){
                return "Unable to recieve data.";
            }
        }

        protected void onPostExecute(String s){
            super.onPostExecute(s);
        }
    }

    private Stirng Get(String myurl) throws  IOException{
        InputStream inputstream = null;
        String returnString = "";

        int length = 500;



    }
}
