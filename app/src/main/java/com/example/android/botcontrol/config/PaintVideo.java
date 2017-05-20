package com.example.android.botcontrol.config;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.android.botcontrol.activity.Control;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by MayurDhikle on 5/18/17.
 */

@SuppressLint("NewApi")
public class PaintVideo extends SurfaceView implements Runnable, SurfaceHolder.Callback {

    private static final String TAG = "PaintVideo";
    private static int screenWidth;
    private static int screenHeight;

    public static boolean runFlag = false;
    private static SurfaceHolder holder;
    private static HttpURLConnection conn;
    private static Thread thread;

    public PaintVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
        screenValue();
        holder = this.getHolder();
        holder.addCallback(this);
    }

    private void screenValue() {
        DisplayMetrics dm = new DisplayMetrics();
        dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        Log.i(TAG, "screenWidth ="+screenWidth);
        Log.i(TAG, "screenHeight ="+screenHeight);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        runFlag = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if( !Control.isLive ){
            runFlag = false;
            Log.i(TAG, "surfaceDestroyed");
            if(holder != null && conn != null){
                conn.disconnect();
                thread.interrupt();
            }
        }
    }

    @Override
    public void run() {
        Canvas c = null;
        Bitmap bmp;
        InputStream is;
        URL videoURL = null;
//		Paint p = new Paint();
        String imageURL = "http://192.168.8.1:8083/?action=snapshot";
        try {
            videoURL = new URL(imageURL);;
        } catch (Exception e) {
        }

        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inPreferredConfig = Bitmap.Config.ARGB_8888;
        while (runFlag) {
            //c = null;
            try {
                synchronized (holder) {
                    c = holder.lockCanvas();
                    conn = (HttpURLConnection)videoURL.openConnection();
                    is = conn.getInputStream();
                    bmp = BitmapFactory.decodeStream(is, null, o);
                    bmp = Bitmap.createScaledBitmap(bmp, screenWidth,
                            screenHeight, true);
                    c.drawBitmap(bmp, 0, 0, null);

                    Thread.sleep(10);

                }
            } catch (Exception e) {
//				System.out.println(e.getMessage());
            }finally{
                //if(holder != null && conn != null)
                if(c != null)
                {
                    holder.unlockCanvasAndPost(c);
                    conn.disconnect();
                }
            }
        }
    }
}
