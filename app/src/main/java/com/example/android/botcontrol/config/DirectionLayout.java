package com.example.android.botcontrol.config;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.android.botcontrol.R;
import com.example.android.botcontrol.activity.Control;

/**
 * Created by MayurDhikle on 5/19/17.
 */

public class DirectionLayout extends RelativeLayout {

    private static final String TAG = "DirectionLayout";
    private static ImageButton imageButton1 = null;
    private static ImageButton imageButton2 = null;
    private static ImageButton imageButton3 = null;
    private static ImageButton imageButton4 = null;
    private static ImageButton imageButton5 = null;
    private static ImageButton imageButton6 = null;
    private static ImageButton imageButton7 = null;
    private static ImageButton imageButton8 = null;
    private static ImageView imageView1 = null;
    private static ImageView imageView2 = null;

    public DirectionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        LayoutInflater.from(context).inflate(R.layout.direction, this); // Learn about this later

        imageButton1 = (ImageButton) findViewById(R.id.imageView1);
        imageButton2 = (ImageButton) findViewById(R.id.imageView2);
        imageButton3 = (ImageButton) findViewById(R.id.imageView3);
        imageButton4 = (ImageButton) findViewById(R.id.imageView4);

        imageButton5 = (ImageButton) findViewById(R.id.imageView5);
        imageButton6 = (ImageButton) findViewById(R.id.imageView6);
        imageButton7 = (ImageButton) findViewById(R.id.imageView7);
        imageButton8 = (ImageButton) findViewById(R.id.imageView8);

        imageView1 = (ImageView) findViewById(R.id.imageView9);
        imageView2 = (ImageView) findViewById(R.id.imageView10);
        imageView1.setBackgroundResource(R.drawable.denied_32x32);
        imageView2.setBackgroundResource(R.drawable.denied_32x32);

        imageButton1.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int action = event.getAction();
                Log.i(TAG, TAG+":"+action);
                Log.i(TAG, TAG+"="+event.getDeviceId());

                if( MotionEvent.ACTION_DOWN == action){
                    imageButton1.setBackgroundResource(R.drawable.abc_ab_bottom_solid_dark_holo);
                    imageView2.setBackgroundResource(R.drawable.arrow_left_32x32);
                }else if( MotionEvent.ACTION_UP == action){
                    imageButton1.setBackgroundResource(R.drawable.abc_ab_bottom_solid_light_holo);
                    imageView2.setBackgroundResource(R.drawable.denied_32x32);
                }
                Control.touchHandle(event, "DJ_Zuo", "��"); // These names are used in the Arduino code... Use later
                return true;
            }
        });

        imageButton2.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int action = event.getAction();
                Log.i(TAG, TAG+":"+action);
                if( MotionEvent.ACTION_DOWN == action){
                    imageButton2.setBackgroundResource(R.drawable.abc_ab_bottom_solid_dark_holo);
                    imageView2.setBackgroundResource(R.drawable.arrow_down_32x32);
                }else if( MotionEvent.ACTION_UP == action){
                    imageButton2.setBackgroundResource(R.drawable.abc_ab_bottom_solid_light_holo);
                    imageView2.setBackgroundResource(R.drawable.denied_32x32);
                }
                Control.touchHandle(event, "DJ_Xia", "��");
                return true;
            }
        });

        imageButton3.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int action = event.getAction();
                Log.i(TAG, TAG+":"+action);
                if( MotionEvent.ACTION_DOWN == action){
                    imageButton3.setBackgroundResource(R.drawable.abc_ab_bottom_solid_dark_holo);
                    imageView2.setBackgroundResource(R.drawable.arrow_right_32x32);
                }else if( MotionEvent.ACTION_UP == action){
                    imageButton3.setBackgroundResource(R.drawable.abc_ab_bottom_solid_light_holo);
                    imageView2.setBackgroundResource(R.drawable.denied_32x32);
                }
                Control.touchHandle(event, "DJ_You", "��");
                return true;
            }
        });

        imageButton4.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int action = event.getAction();
                Log.i(TAG, TAG+":"+action);
                if( MotionEvent.ACTION_DOWN == action){
                    imageButton4.setBackgroundResource(R.drawable.abc_ab_bottom_solid_dark_holo);
                    imageView2.setBackgroundResource(R.drawable.arrow_up_32x32);
                }else if( MotionEvent.ACTION_UP == action){
                    imageButton4.setBackgroundResource(R.drawable.abc_ab_bottom_solid_light_holo);
                    imageView2.setBackgroundResource(R.drawable.denied_32x32);
                }
                Control.touchHandle(event, "DJ_Shang", "ǰ");
                return true;
            }
        });

        imageButton5.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int action = event.getAction();
                Log.i(TAG, TAG+":"+action);
                if( MotionEvent.ACTION_DOWN == action){
                    imageButton5.setBackgroundResource(R.drawable.abc_ab_bottom_solid_dark_holo);
                    imageView1.setBackgroundResource(R.drawable.arrow_right_32x32);
                    Control.ctrOrder("MD_SD 255 255\n\r", "��");
                    Control.ctrOrder("\n\rMD_You\n\r", "��");
                }else if( MotionEvent.ACTION_UP == action){
                    imageButton5.setBackgroundResource(R.drawable.abc_ab_bottom_solid_light_holo);
                    imageView1.setBackgroundResource(R.drawable.denied_32x32);
                    Control.ctrOrder("\n\rMD_Ting\n\r", "��");
                    Control.ctrOrder("\n\r", "��");
                }
                return true;
            }
        });

        imageButton6.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int action = event.getAction();
                Log.i(TAG, TAG+":"+action);
                if( MotionEvent.ACTION_DOWN == action){
                    imageButton6.setBackgroundResource(R.drawable.abc_ab_bottom_solid_dark_holo);
                    imageView1.setBackgroundResource(R.drawable.arrow_down_32x32);
                    Control.ctrOrder("MD_SD 255 255\n\r", "��");
                    Control.ctrOrder("\n\rMD_Hou\n\r", "��");
                }else if( MotionEvent.ACTION_UP == action){
                    imageButton6.setBackgroundResource(R.drawable.abc_ab_bottom_solid_light_holo);
                    imageView1.setBackgroundResource(R.drawable.denied_32x32);
                    Control.ctrOrder("\n\rMD_Ting\n\r", "��");
                    Control.ctrOrder("\n\r", "��");
                }
                return true;
            }
        });

        imageButton7.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int action = event.getAction();
                Log.i(TAG, TAG+":"+action);
                if( MotionEvent.ACTION_DOWN == action){
                    imageButton7.setBackgroundResource(R.drawable.abc_ab_bottom_solid_dark_holo);
                    imageView1.setBackgroundResource(R.drawable.arrow_left_32x32);
                    Control.ctrOrder("MD_SD 255 255\n\r", "��");
                    Control.ctrOrder("\n\rMD_Zuo\n\r", "��");
                }else if( MotionEvent.ACTION_UP == action){
                    imageButton7.setBackgroundResource(R.drawable.abc_ab_bottom_solid_light_holo);
                    imageView1.setBackgroundResource(R.drawable.denied_32x32);
                    Control.ctrOrder("\n\rMD_Ting\n\r", "��");
                    Control.ctrOrder("\n\r", "��");
                }
                return true;
            }
        });

        imageButton8.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int action = event.getAction();
                Log.i(TAG, TAG+":"+action);
                if( MotionEvent.ACTION_DOWN == action){
                    imageButton8.setBackgroundResource(R.drawable.abc_ab_bottom_solid_dark_holo);
                    imageView1.setBackgroundResource(R.drawable.arrow_up_32x32);

                    Control.ctrOrder("MD_SD 255 255\n\r", "ǰ");
                    Control.ctrOrder("\n\rMD_Qian\n\r", "ǰ");
                }else if( MotionEvent.ACTION_UP == action){
                    imageButton8.setBackgroundResource(R.drawable.abc_ab_bottom_solid_light_holo);
                    imageView1.setBackgroundResource(R.drawable.denied_32x32);
                    Control.ctrOrder("\n\rMD_Ting\n\r", "ǰ");
                    Control.ctrOrder("\n\r", "ǰ");
                }
                return true;
            }
        });
    }
}
