package com.example.android.botcontrol.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.android.botcontrol.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private final int SPLASH_DISPLAY_LENGTH = 3000; // Duration for Splash Screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo); // Calls the log.xml file from which it pulls the image for splash screen

         new Handler().postDelayed(new Runnable(){ // Handler is used. Learn Why

          @Override
           public void run(){
               Intent mainIntent = new Intent(MainActivity.this,Control.class);
               MainActivity.this.startActivity(mainIntent);
               MainActivity.this.finish();
           }

        },SPLASH_DISPLAY_LENGTH);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        setContentView(R.layout.main);
        return super.onOptionsItemSelected(item);
    }

    private void loadActivity(Context context,Class<?> c){
        Intent intent=new Intent();
        intent.setClass(context,c);
        startActivity(intent);
        overridePendingTransition(R.anim.bottom_in,R.anim.bottom_out);
    }

    // Options we have after clicking on settings from the Options Menu (3 dots)
    private void setMainBtnAffairs() {
        final Button btnConn = (Button) this.findViewById(R.id.btnConn);
        final Button btnSet = (Button) this.findViewById(R.id.btnSet);
        final ImageButton imageButtonTest = (ImageButton) this.findViewById(R.id.imageButtonTest);

        //OnClickListner for Connect Button
        btnConn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadActivity(MainActivity.this,Control.class);
                Log.d(TAG, "Connection Button");// Asli code mein Chinese
            }
        });

        //OnClickListner for Settings Button
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadActivity(MainActivity.this,Set.class);
                Log.d(TAG, "Set Button");
            }
        });

        //OnClickListner for Test Button
        imageButtonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadActivity(MainActivity.this,TestAct.class);
                Log.d(TAG, "Test Button");
            }
        });
    }
}
