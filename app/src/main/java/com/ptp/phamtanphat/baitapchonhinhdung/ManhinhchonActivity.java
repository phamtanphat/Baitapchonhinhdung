package com.ptp.phamtanphat.baitapchonhinhdung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class ManhinhchonActivity extends AppCompatActivity {

    int sodong = 6;
    int socot = 3;
    TableLayout tableLayout;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchon);

        tableLayout = findViewById(R.id.tablelayout);
//        socot : 3 (Imageview)
//        sodong : 6 (Table row)
        for (int i = 0; i < sodong; i++) {
            TableRow tableRow = new TableRow(this);
            for (int y = 0; y < socot; y++) {

//                int count = 3 * i + y;
//                3 * ( 1 - 1) + ( 1 - 1)=>
                if (count == 17){
                    break;
                }else {
                    ImageView imageView = new ImageView(this);
                    int hinh = getResources().getIdentifier(MainActivity.manghinh.get(count++),"drawable",getPackageName());
                    imageView.setImageResource(hinh);
                    tableRow.addView(imageView);
                }


            }
            tableLayout.addView(tableRow);
        }

    }
}
