package com.ptp.phamtanphat.baitapchonhinhdung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] hinhanhdongvat;
    static ArrayList<String> manghinh;
    String tenhinhgoc = "";
    ImageView imgHinhgoc,imgHinhchon;
    int Request_Code_Hinh_Chon = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgHinhgoc = findViewById(R.id.imageviewHinhgoc);
        imgHinhchon = findViewById(R.id.imageviewHinhchon);

        hinhanhdongvat = getResources().getStringArray(R.array.hinhdongvat);


        manghinh = new ArrayList<>(Arrays.asList(hinhanhdongvat));
        Collections.shuffle(manghinh);
        tenhinhgoc = manghinh.get(0);


        int hinh = getResources().getIdentifier(tenhinhgoc,"drawable",getPackageName());
        imgHinhgoc.setImageResource(hinh);

        imgHinhchon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ManhinhchonActivity.class);
                startActivityForResult(intent,Request_Code_Hinh_Chon);
            }
        });
    }
}
