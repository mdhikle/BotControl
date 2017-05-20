package com.example.android.botcontrol.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.botcontrol.R;

/**
 * Created by MayurDhikle on 5/18/17.
 */

public class Set extends AppCompatActivity{

    private static final String TAG = "Set";
    EditText editCtrIP;
    EditText editPort;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        editCtrIP = (EditText) findViewById(R.id.editCtrIP);
        editPort = (EditText) findViewById(R.id.editPort);

        Button btn_ok = (Button) findViewById(R.id.button1);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Editable tempPort = editPort.getText();
                Editable tempCtrIP = editCtrIP.getText();
                if ((!tempCtrIP.equals(null)) && (tempPort.equals(null))){
                    Control.ip = tempCtrIP.toString();
                    Control.port = Integer.parseInt(tempPort.toString());
                    Log.i(TAG, "Control.ip = "+Control.ip);
                    Log.i(TAG, "Control.port = "+Control.port);
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
