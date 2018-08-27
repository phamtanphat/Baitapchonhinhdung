package com.ptp.phamtanphat.baitapchonhinhdung;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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
    int hinh;
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


        hinh = getResources().getIdentifier(tenhinhgoc,"drawable",getPackageName());
        imgHinhgoc.setImageResource(hinh);

        imgHinhchon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ManhinhchonActivity.class);
                startActivityForResult(intent,Request_Code_Hinh_Chon);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == Request_Code_Hinh_Chon && resultCode == RESULT_OK && data != null){
            int hinhchon = data.getIntExtra("hinhchon",0);
            imgHinhchon.setImageResource(hinhchon);
            if (hinhchon == hinh){
                Toast.makeText(this, "Dung roi", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Sai roi", Toast.LENGTH_SHORT).show();
            }
        }
        if (resultCode == RESULT_CANCELED){
            Toast.makeText(this, "khong chon gi het", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
