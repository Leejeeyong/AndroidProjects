package com.example.retrofitexample002;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<Data.Progress> tracksDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> carriersD = new ArrayList<String>();

        final List<Integer> track_number_list = new ArrayList<>();
        final String track_number="";
        final String[] carrier_name = {"kr.epost"};
        final Button carrierBTN = (Button) findViewById(R.id.carrierselectbtn);
        Button trackBTN = (Button)findViewById(R.id.trackbtn);
        final TextView tracknumberedit = (TextView)findViewById(R.id.tracknumber_edit);
        final TextView status_view = (TextView)findViewById(R.id.status_view);
        final TextView from_view = (TextView)findViewById(R.id.from_view);
        final TextView to_view = (TextView)findViewById(R.id.to_View);
        //final int selectedCarryNum = 7;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apis.tracker.delivery")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RetroService retroService = retrofit.create(RetroService.class);
        final MyAdapter myAdapter = null;

        Intent intent = getIntent();
        tracknumberedit.setText(intent.getStringExtra("tracknumber"));
        carrier_name[0]=intent.getStringExtra("selectname");
        final int selectedCarryNum=intent.getIntExtra("SelectNum",7);

        ////////////////////택배사
        Call<List<Data>> dataCarriers = retroService.getCarriers();
        dataCarriers.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(@NonNull Call<List<Data>> call, @NonNull Response<List<Data>> response) {
                List<Data> carriers = response.body();

                for(int i=0;i<carriers.size();i++){
                    carriersD.add(i,carriers.get(i).getName());
                }
                carrierBTN.setText(carriersD.get(selectedCarryNum));
            }

            @Override
            public void onFailure(@NonNull Call<List<Data>> call, @NonNull Throwable t) {
                Log.d("TEST","Failure CARRIER TEST");
            }
        });

        carrierBTN.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                builder.setTitle("택배사 선택");

                builder.setItems(R.array.CARRIERS, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] items = getResources().getStringArray(R.array.CARRIERS);
                        Toast.makeText(getApplicationContext(),items[which],Toast.LENGTH_LONG).show();
                        carrierBTN.setText(items[which]);
                    switch (which){
                            case 0:
                                carrier_name[0] ="de.dhl";
                                break;
                            case 1:
                                carrier_name[0] ="kr.chunilps";
                                break;
                            case 2:
                                carrier_name[0] ="kr.cjlogistics";
                                break;
                            case 3:
                                carrier_name[0] ="kr.cupost";
                                break;
                            case 4:
                                carrier_name[0] ="kr.cvsnet";
                                break;
                            case 5:
                                carrier_name[0] ="kr.cway";
                                break;
                            case 6:
                                carrier_name[0] ="kr.daesin";
                                break;
                            case 7:
                                carrier_name[0] ="kr.epost";
                                break;
                            case 8:
                                carrier_name[0] ="kr.hanips";
                                break;
                            case 9:
                                carrier_name[0] ="kr.hanjin";
                                break;
                            case 10:
                                carrier_name[0] ="kr.hdexp";
                                break;
                            case 11:
                                carrier_name[0] ="kr.homepick";
                                break;
                            case 12:
                                carrier_name[0] ="kr.honamlogis";
                                break;
                            case 13:
                                carrier_name[0] ="kr.ilyanglogis";
                                break;
                            case 14:
                                carrier_name[0] ="kr.kdexp";
                                break;
                            case 15:
                                carrier_name[0] ="kr.kunyoung";
                                break;
                            case 16:
                                carrier_name[0] ="kr.logen";
                                break;
                            case 17:
                                carrier_name[0] ="kr.lotte";
                                break;
                            case 18:
                                carrier_name[0] ="kr.slx";
                                break;
                            case 19:
                                carrier_name[0] ="nl.tnt";
                                break;
                            case 20:
                                carrier_name[0] ="un.upu.ems";
                                break;
                            case 21:
                                carrier_name[0] ="us.fedex";
                                break;
                            case 22:
                                carrier_name[0] ="us.ups";
                                break;
                            case 23:
                                carrier_name[0] ="us.usps";
                                break;
                            default:
                                carrier_name[0]="kr.epost";
                                break;
                        }
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });




        trackBTN.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                /////////////////////배송추적
                try {
                    Call<Data> dataP = retroService.trackingData(carrier_name[0], tracknumberedit.getText().toString());

                    dataP.enqueue(new Callback<Data>() {
                        @Override
                        public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {

                            Data user = response.body();

                            ListView listview = (ListView)findViewById(R.id.listView);
                            if(user ==null){
                                Log.d("TEST","NULLNULLNULLNULL");
                            }
                            else {
                                final MyAdapter myAdapter = new MyAdapter(MainActivity.this,(ArrayList<Data.Progress>) user.progress);

                                listview.setAdapter(myAdapter);

                                status_view.setText(user.getState().getText());
                                from_view.setText(" 보내는 사람 : "+user.getFrom().getName());
                                to_view.setText(" 받는 사람 : "+user.getTo().getName());
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
                            Log.d("TESt", "Failure");
                        }
                    });
                }catch (Exception e){
                    Log.d("TEST","Exception");
                }
            }



        });

        try {
            Call<Data> dataP = retroService.trackingData(carrier_name[0], tracknumberedit.getText().toString());

            dataP.enqueue(new Callback<Data>() {
                @Override
                public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {

                    Data user = response.body();

                    ListView listview = (ListView)findViewById(R.id.listView);
                    if(user ==null){
                        Log.d("TEST","NULLNULLNULLNULL");
                    }
                    else {
                        final MyAdapter myAdapter = new MyAdapter(MainActivity.this,(ArrayList<Data.Progress>) user.progress);

                        listview.setAdapter(myAdapter);

                        status_view.setText(user.getState().getText());
                        from_view.setText(" 보내는 사람 : "+user.getFrom().getName());
                        to_view.setText(" 받는 사람 : "+user.getTo().getName());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
                    Log.d("TESt", "Failure");
                }
            });
        }catch (Exception e){
            Log.d("TEST","Exception");
        }


    }
}
