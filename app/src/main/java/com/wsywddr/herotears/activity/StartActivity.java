package com.wsywddr.herotears.activity;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.wsywddr.herotears.MainActivity;
import com.wsywddr.herotears.R;
import com.wsywddr.herotears.base.BaseActivity;
import com.wsywddr.herotears.util.AppConfig;

/**
 * Created by bappy on 16-7-11.
 */
@EActivity(R.layout.activity_start)
public class StartActivity extends BaseActivity {

    @ViewById(R.id.img_bg)
    ImageView imageView;

    @AfterViews
    void afterViews() {
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
                Intent intent = new Intent();
                //check is login
                if(!AppConfig.isLogin(preference)){
//                    intent.setClass(StartActivity.this, NewLoginActivity_.class);
                }else{
//                    intent.setClass(StartActivity.this, MainActivity_.class);
                }

                intent.setClass(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.startAnimation(alphaAnimation);
    }
}
