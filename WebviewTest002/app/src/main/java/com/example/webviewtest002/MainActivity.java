package com.example.webviewtest002;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AsyncTask.execute((new Runnable() {
            @Override
            public void run() {
                URL trackerApiPoint = null;
                HttpsURLConnection myConnection = null;

                try {
                    trackerApiPoint = new URL("https://apis.tracker.delivery/carriers/");
                    myConnection = (HttpsURLConnection)trackerApiPoint.openConnection();
                } catch(MalformedURLException e) {
                    e.printStackTrace();
                } catch(IOException ex) {
                    ex.printStackTrace();;
                }

                myConnection.setRequestProperty("User-Agent", "my-test-app-v0.1");
                myConnection.setRequestProperty("ACCEPT", "");
                myConnection.setRequestProperty("CONTACT", "fghj0720@gmail.com");


                InputStream responseBody = null;
                InputStreamReader responseBodyReader = null;

                try{
                    responseBody = myConnection.getInputStream();
                    responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                } catch(IOException e){
                    e.printStackTrace();
                }


                JsonReader jsonreder = new JsonReader(responseBodyReader);
                String key = null;
                String value = null;

                try{
                    jsonreder.beginObject();
                    while(jsonreder.hasNext()){
                        key = jsonreder.nextName();
                        
                        if(key.equals("id")){
                            value = jsonreder.nextString();

                            break;
                        } else {
                            jsonreder.skipValue();
                        }
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }

            }
        }));


    }



}
