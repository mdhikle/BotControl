package com.example.android.botcontrol.config;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by MayurDhikle on 5/19/17.
 */

public class Tools {
    public static void tips(Context mContext , String content){
        Toast t = Toast.makeText(mContext, content+"", Toast.LENGTH_SHORT);
        t.show();
    }
}
