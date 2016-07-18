package com.wsywddr.herotears;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.wsywddr.herotears.base.BaseFragment;
import com.wsywddr.herotears.fragment.AnimalFragment_;
import com.wsywddr.herotears.fragment.BattleFragment_;
import com.wsywddr.herotears.fragment.EquipFragment_;
import com.wsywddr.herotears.fragment.MeFragment_;
import com.wsywddr.herotears.fragment.ToplistFragment_;
import com.wsywddr.herotears.model.main.FirstEvent;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;


@EActivity(R.layout.activity_main)
public class MainActivity extends FragmentActivity {
    Context context = null;

    @ViewById(R.id.rb_myinfo)
    RadioButton rb_myinfo;

    @ViewById(R.id.rb_equipment)
    RadioButton rb_equipment;

    @ViewById(R.id.rb_toplist)
    RadioButton rb_toplist;

    @ViewById(R.id.rb_battle)
    RadioButton rb_battle;

    @ViewById(R.id.rb_animal)
    RadioButton rb_animal;

    BaseFragment meFragment, equipFragment, animalFragment, toplistFragment, battleFragment;
    FragmentManager frgmentManager;

    List<BaseFragment> fragments;
    List<RadioButton> rbs;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @AfterViews
    void afterViews() {
        context = MainActivity.this;
        EventBus.getDefault().register(this);

        frgmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = frgmentManager.beginTransaction();
        meFragment = new MeFragment_();
        equipFragment = new EquipFragment_();
        animalFragment = new AnimalFragment_();
        toplistFragment = new ToplistFragment_();
        battleFragment = new BattleFragment_();
        fragments = new ArrayList<BaseFragment>();
        fragments.add(meFragment);
        fragments.add(equipFragment);
        fragments.add(animalFragment);
        fragments.add(toplistFragment);
        fragments.add(battleFragment);
        rbs = new ArrayList<RadioButton>();
        rbs.add(rb_myinfo);
        rbs.add(rb_equipment);
        rbs.add(rb_toplist);
        rbs.add(rb_battle);
        rbs.add(rb_animal);
        rb_myinfo.setChecked(true);
        changeSelectedTabColor(rb_myinfo);
        fragmentTransaction.add(R.id.fragments, meFragment);
        fragmentTransaction.commit();
    }

    public void changeSelectedTabColor(RadioButton rb) {
        for (RadioButton radioButton : rbs) {
            radioButton.setTextColor(Color.BLACK);
        }
        rb.setTextColor(getResources().getColor(R.color.red_main));
    }

    public void switchFragment(FragmentTransaction fragmentTransaction,
                               BaseFragment fragment) {
        for (BaseFragment objFragment : fragments) {
            if (objFragment.isAdded()) {
                fragmentTransaction.hide(objFragment);
            }
        }
        if (!fragment.isAdded()) {
            fragmentTransaction.add(R.id.fragments, fragment);
        } else {
            fragmentTransaction.show(fragment);
        }
        fragmentTransaction.commit();
    }


    @Click(R.id.rb_equipment)
    void rb_equipmentClick() {
        changeSelectedTabColor(rb_equipment);
        switchFragment(frgmentManager.beginTransaction(), equipFragment);
    }

    @Click(R.id.rb_animal)
    void rb_animalClick() {
        changeSelectedTabColor(rb_animal);
        switchFragment(frgmentManager.beginTransaction(), animalFragment);
    }

    @Click(R.id.rb_myinfo)
    void rb_myinfoClick() {
        changeSelectedTabColor(rb_myinfo);
        switchFragment(frgmentManager.beginTransaction(), meFragment);
    }

    @Click(R.id.rb_toplist)
    void rb_toplistClick() {
        changeSelectedTabColor(rb_toplist);
        switchFragment(frgmentManager.beginTransaction(), toplistFragment);
    }

    @Click(R.id.rb_battle)
    void rb_battleClick() {
        changeSelectedTabColor(rb_battle);
        switchFragment(frgmentManager.beginTransaction(), battleFragment);
    }

    @Subscribe
    public void onEvent(FirstEvent event) {
        /* Do something */
        String msg = "onEventMainThread" + event.getMsg();
        Log.d("harvic", msg);
    }

    ;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    private long mExitTime = 0;

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.wsywddr.herotears/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.wsywddr.herotears/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
