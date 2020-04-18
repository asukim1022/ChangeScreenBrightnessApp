package com.asukim.changescreenbrightness;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //changeScreenBrightness : 화면 밝기 조절(0 : 최소)
                changeScreenBrightness(0);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //changeScreenBrightness : 화면 밝기 조절(255 : 최대)
                changeScreenBrightness(255);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //changeScreenBrightness : 화면 밝기 조절(-1 : 시스템 설정값)
                changeScreenBrightness(-1);
            }
        });
    }

    /** @brief changeScreenBrightness : 화면 밝기 조절
     *  @date 2020.02.19
     *  @param value : int값으로 0(최소), 255(최대), -1(시스템 설정값)
     */
    private void changeScreenBrightness(int value) {
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.screenBrightness = value * 1.0f / 255;
        window.setAttributes(layoutParams);
    }
}
