package com.example.retrofitexample002;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackinglist);

        /*
        Realm.init(this);

        Realm realm = Realm.getDefaultInstance();

        final LocalDB myDB = new LocalDB();
        Log.d("REALM TEST",""+realm.getPath());
        */

        final Button CarrierBTN = (Button)findViewById(R.id.carrierselectbtn);
        Button TrackingBTN = (Button)findViewById(R.id.trackingbtn);
        final EditText TrackNumberEdit = (EditText)findViewById(R.id.tracknumberedit);
        final String[] carrier_name = {"kr.epost"};
        final List<String> carriersD = new ArrayList<String>();
        final int[] selectedCarryNum = {7};

        SharedPreferences myPref = getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = myPref.edit();

        int trackinglistNum=987654;
        String aaaaa = ""+trackinglistNum;
        trackinglistNum=trackinglistNum+1;
        String bbbbb = ""+trackinglistNum;

        editor.putString(aaaaa,aaaaa);
        editor.putString(bbbbb,bbbbb);
        editor.commit();

        editor.putString(1+1+"num","123123123");

        Log.d("TEST", myPref.getString(aaaaa,"")+"   "+myPref.getString(""+trackinglistNum,""));
//리스트 갯수
//리스트갯수 숫자 + 트랙번호문자
// 리스트갯수 숫자 + 택배사id문자

        int tracklistCount = myPref.getInt("TRACKCOUNT",0);
        List<String> trackNumber = new ArrayList<>();
        List<String> carrierName = new ArrayList<>();

        tracklistCount=3;

        /*
        for(int i=0;i<tracklistCount;i++){
            editor.putString("TRACKNUMBER"+i,"12345"+i);
            editor.putString("CARRIERNAME"+i,"kr.epost"+i);
        }
        editor.commit();
        */
        for(int i=0;i<tracklistCount;i++){
            trackNumber.add(i,myPref.getString("TRACKNUMBER"+i,""));
            carrierName.add(i,myPref.getString("CARRIERNAME"+i,""));
        }

        for(int i=0;i<tracklistCount;i++){
            Log.d("PREFER TEST",carrierName.get(i)+"  "+trackNumber.get(i));
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apis.tracker.delivery")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RetroService retroService = retrofit.create(RetroService.class);

        final Call<List<Data>> dataCarriers = retroService.getCarriers();
        dataCarriers.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(@NonNull Call<List<Data>> call, @NonNull Response<List<Data>> response) {
                List<Data> carriers = response.body();

                for(int i=0;i<carriers.size();i++){
                    carriersD.add(i,carriers.get(i).getName());
                }
                CarrierBTN.setText(carriersD.get(selectedCarryNum[0]));
            }

            @Override
            public void onFailure(@NonNull Call<List<Data>> call, @NonNull Throwable t) {
                Log.d("TEST","Failure CARRIER TEST");
            }
        });

        ///////////
        //추적리스트//
        ///////////


        CarrierBTN.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                builder.setTitle("택배사 선택");

                builder.setItems(R.array.CARRIERS, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedCarryNum[0] =which;
                        String[] items = getResources().getStringArray(R.array.CARRIERS);
                        Toast.makeText(getApplicationContext(),items[which]+ selectedCarryNum[0],Toast.LENGTH_LONG).show();
                        CarrierBTN.setText(items[which]);

                        selectedCarryNum[0]=which;
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

        TrackingBTN.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(TrackNumberEdit.getText().toString().getBytes().length<=0){
                    Log.d("TEST","NULLNULLNULLNULL");
                    Toast.makeText(getApplicationContext(),"nullnulnull",Toast.LENGTH_LONG).show();
                }
                else {
                    /*
                    myDB.setNum(0);
                    myDB.setCarrier(carrier_name[0]);
                    myDB.setTrack_number(TrackNumberEdit.getText().toString());
                    myDB.setTitle("TesyDB1");
                    */
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("tracknumber",TrackNumberEdit.getText().toString());
                    intent.putExtra("selectname", carrier_name[0]);
                    intent.putExtra("SelectNum",selectedCarryNum[0]);
                    startActivity(intent);
                }
        }});





    }
}
