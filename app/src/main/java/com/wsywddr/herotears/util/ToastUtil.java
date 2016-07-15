package com.wsywddr.herotears.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class ToastUtil {

    private static Toast mToast;
    private static Handler mhandler = new Handler();
    private static Runnable r = new Runnable() {
        public void run() {
            if (mToast != null) {
                mToast.cancel();
            }
            mToast = null;
        }

        ;
    };

    public static void show(Context context, String text) {
        mhandler.removeCallbacks(r);
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        }
        mhandler.postDelayed(r, 1000);
        mToast.show();
    }

    public static void showToast(Context context, int strId) {
        show(context, context.getString(strId));
    }

}
