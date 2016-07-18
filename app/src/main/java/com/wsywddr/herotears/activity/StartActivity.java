package com.wsywddr.herotears.activity;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.wsywddr.herotears.MainActivity;
import com.wsywddr.herotears.MainActivity_;
import com.wsywddr.herotears.R;
import com.wsywddr.herotears.base.BaseActivity;
import com.wsywddr.herotears.util.AppConfig;
import com.wsywddr.herotears.util.ViewUtil;

/**
 * Created by bappy on 16-7-11.
 */
@EActivity(R.layout.activity_start)
public class StartActivity extends BaseActivity {

    @ViewById
    ImageView img_bg;
    @ViewById
    Button btn_begin;

    @AfterViews
    void afterViews() {
        ViewUtil.hide(btn_begin);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(2000);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub
                ViewUtil.show(btn_begin);
            }
        });
        img_bg.setScaleType(ImageView.ScaleType.FIT_XY);
        img_bg.startAnimation(alphaAnimation);
    }

    @Click(R.id.btn_begin)
    void btn_beginClick(){
        Intent intent = new Intent();
        //check is login
        if(!AppConfig.isLogin(preference)){
//                    intent.setClass(StartActivity.this, NewLoginActivity_.class);
        }else{
//                    intent.setClass(StartActivity.this, MainActivity_.class);
        }

        intent.setClass(StartActivity.this, MainActivity_.class);
        startActivity(intent);
        finish();
    }

}
