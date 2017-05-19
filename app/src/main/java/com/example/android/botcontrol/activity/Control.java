package com.example.android.botcontrol.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.android.botcontrol.R;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import static com.example.android.botcontrol.R.layout.ctr;

/**
 * Created by MayurDhikle on 5/18/17.
 */

public class Control extends AppCompatActivity{

    private Socket socket = null;
    private static final String TAG = "Control";
    public static String ip = null;
    public static int port = 0;
    public static boolean isActivity = false;
    public static boolean isLive = false;
    private static PrintWriter printWriter = null;
    private boolean isConnect = false;
    private Thread thread = null;

    // These two were used before but of no use in the modified code
    private RadioButton radioButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ctr);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        isActivity = true;
        isLive = true;
        isConnect = true;
        thread = new Thread(runnable);
        thread.start();
        Log.d(TAG, "On Create");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Log.d(TAG, "On Options Menu");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*@SuppressLint("ClickableViewAccessibility")
    private void setBtnAffairs{
    }*/

    public static void touchHandle(MotionEvent event, String orderStr, String tips){
        int action = event.getAction();
        Log.d(TAG, "action = "+action+"touchHandle_one");
        switch (action){
            case MotionEvent.ACTION_DOWN:
                ctrOrder(orderStr+"\n\r",tips);
                break;
            case MotionEvent.ACTION_UP:
                ctrOrder("\n\r", "ͣ"); // try later with tips
                break;
            default:
                break;
        }
    }

    public static void ctrOrder(String orderStr, String tips){
        Log.d(TAG, "ctrOrder" + orderStr);
        if( (orderStr != null) && (printWriter != null) ){

            printWriter.print(orderStr);
            printWriter.flush();
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                Log.d(TAG, "Trim runnable");
                if (Control.ip != null && Control.port != 0){
                    Log.i(TAG, "Control.ip =" + Control.ip);
                    Log.i(TAG, "Control.port =" + Control.port);
                }
                else
                    socket = new Socket("192.168.8.1", 2001);

                OutputStream os = socket.getOutputStream();
                printWriter = new PrintWriter(os, true);
            }
            catch (Exception e) {
                return;
            }
        }
    };

    public void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "onDestroy");
        isLive = false;
        if (isConnect){
            isConnect = false;
            try {
                if (socket != null){
                    socket.close();
                    socket = null;
                    printWriter.close();
                    printWriter = null;
                }
            }

            catch (IOException e){
                e.printStackTrace();
            }
            thread.interrupt();
        }
    }

    @Override
    protected void onStop(){
        // TODO Auto-generated method stub
        super.onStop();
        isActivity = false;
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        isActivity = true;
        Log.i(TAG, "onRestart");
    }

    private void loadActivity(Context context, Class<?> c) {
        Intent intent = new Intent();
        intent.setClass(context, c);
        startActivity(intent);
    }

}
