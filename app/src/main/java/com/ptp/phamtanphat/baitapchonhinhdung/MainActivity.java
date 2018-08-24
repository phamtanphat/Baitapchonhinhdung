package com.ptp.phamtanphat.baitapchonhinhdung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] hinhanhdongvat;
    ArrayList<String> manghinh;
    String tenhinhgoc = "";
    ImageView imgHinhgoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgHinhgoc = findViewById(R.id.imageviewHinhgoc);

        hinhanhdongvat = getResources().getStringArray(R.array.hinhdongvat);


        manghinh = new ArrayList<>(Arrays.asList(hinhanhdongvat));
        Collections.shuffle(manghinh);
        tenhinhgoc = manghinh.get(0);


        int hinh = getResources().getIdentifier(tenhinhgoc,"drawable",getPackageName());
        imgHinhgoc.setImageResource(hinh);
    }
}
