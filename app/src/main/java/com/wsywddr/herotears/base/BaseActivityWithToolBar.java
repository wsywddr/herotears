package com.wsywddr.herotears.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wsywddr.herotears.R;
import com.wsywddr.herotears.util.StringUtil;
import com.wsywddr.herotears.util.ViewUtil;


/**
 * Created by fengxiang on 2016/1/19.
 */

public abstract class BaseActivityWithToolBar extends BaseActivity implements View.OnClickListener {

    protected Toolbar toolbar;
    protected ImageView btnLeft1;
    protected ImageView btnLeft2;
    protected ImageView btnRight1;
    protected ImageView btnRight2;
    protected TextView titleView,tv_back,tv_right,lefttv1;
    protected TextView textRight1;
    protected TextView textRight2;
    protected LinearLayout rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.activity_base_with_toolbar, null);
        initToolBar(root);
        LinearLayout container = (LinearLayout) root
                .findViewById(R.id.container);
        LayoutInflater.from(this).inflate(layoutResID, container);
        super.setContentView(root);
    }

    @Override
    public void setContentView(View view) {
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.activity_base_with_toolbar, null);
        initToolBar(root);
        LinearLayout container = (LinearLayout) root
                .findViewById(R.id.container);
        container.addView(view);
        super.setContentView(root);
    }

    public void initToolBar(View view) {
        rootView = (LinearLayout) view.findViewById(R.id.container);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        btnLeft1 = (ImageView) view.findViewById(R.id.leftBtn1);
        btnLeft2 = (ImageView) view.findViewById(R.id.leftBtn2);
        btnRight1 = (ImageView) view.findViewById(R.id.rightBtn1);
        btnRight2 = (ImageView) view.findViewById(R.id.rightBtn2);
        lefttv1= (TextView) view.findViewById(R.id.lefttv1);
        tv_back= (TextView) view.findViewById(R.id.tv_back);
        tv_right= (TextView) view.findViewById(R.id.tv_right);
        titleView = (TextView) view.findViewById(R.id.titleView);
        textRight1 = (TextView) view.findViewById(R.id.right1);
        textRight2 = (TextView) view.findViewById(R.id.right2);
        toolbar.setTitle("");
//        setSupportActionBar(toolbar);
        lefttv1.setOnClickListener(this);
        tv_right.setOnClickListener(this);
        tv_back.setOnClickListener(this);
        btnLeft1.setOnClickListener(this);
        btnLeft2.setOnClickListener(this);
        btnRight1.setOnClickListener(this);
        btnRight2.setOnClickListener(this);
        textRight1.setOnClickListener(this);
        textRight2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lefttv1:
                onTextLeft1Click();
                break;
            case R.id.tv_right:
                onTextRight2Click();
                break;
            case R.id.tv_back:
                onBtnLeft1Click();
                break;
            case R.id.leftBtn1:
                onBtnLeft1Click();
                break;
            case R.id.leftBtn2:
                onBtnLeft2Click();
                break;
            case R.id.rightBtn1:
                onBtnRight1Click();
                break;
            case R.id.rightBtn2:
                onBtnRight2Click();
                break;
            case R.id.right1:
                onTextRight1Click();
                break;
            case R.id.right2:
                onTextRight2Click();
                break;
        }
    }

    /**
     * 设置标题
     *
     * @param title
     */
    protected void setTitle(@NonNull String title) {
        if (titleView != null && !StringUtil.isEmpty(title)) {
            titleView.setText(title);
        }
    }

    /**
     * 设置左1按钮资源图
     *
     * @param resId
     */
    protected void setBtnLeft1ImageResource(int resId) {
        btnLeft1.setImageResource(resId);
    }

    /**
     * 设置左2按钮资源图
     *
     * @param resId
     */
    protected void setBtnLeft2ImageResource(int resId) {
        btnLeft2.setImageResource(resId);
    }

    /**
     * 设置右1按钮资源图
     *
     * @param resId
     */
    protected void setBtnRight1ImageResource(int resId) {
        btnRight1.setImageResource(resId);
    }

    /**
     * 设置右2按钮资源图
     *
     * @param resId
     */
    protected void setBtnRight2ImageResource(int resId) {
        btnRight2.setImageResource(resId);
    }

    /**
     * 设置左1按钮是否可用
     *
     * @param isEnable
     */
    protected void setBtnLeft1Enable(boolean isEnable) {
        if (isEnable) {
            ViewUtil.show(btnLeft1);
            ViewUtil.show(tv_back);
        } else {
            ViewUtil.hide(btnLeft1);
            ViewUtil.hide(tv_back);
        }
    }

    /**
     * 设置左2按钮是否可用
     *
     * @param isEnable
     */
    protected void setBtnLeft2Enable(boolean isEnable) {
        if (isEnable) {
            ViewUtil.show(btnLeft2);
        } else {
            ViewUtil.hide(btnLeft2);
        }
    }

    /**
     * 设置右1按钮是否可用
     *
     * @param isEnable
     */
    protected void setBtnRight1Enable(boolean isEnable) {
        if (isEnable) {
            ViewUtil.show(btnRight1);
        } else {
            ViewUtil.hide(btnRight2);
        }
    }

    /**
     * 设置右2按钮是否可用
     *
     * @param isEnable
     */
    protected void setBtnRight2Enable(boolean isEnable) {
        if (isEnable) {
            ViewUtil.show(btnRight2);
        } else {
            ViewUtil.hide(btnRight2);
        }
    }

    /**
     * 设置右1文本按钮是否可用
     *
     * @param isEnable
     */
    protected void setTextRight1Enable(boolean isEnable) {
        if (isEnable) {
            ViewUtil.show(textRight1);
        } else {
            ViewUtil.hide(textRight1);
        }
    }

    protected void setTextRightEnable(boolean isEnable) {
        if (isEnable) {
            ViewUtil.show(tv_right);
        } else {
            ViewUtil.hide(tv_right);
        }
    }

    /**
     * 设置左1文本按钮是否可用
     *
     * @param isEnable
     */
    protected void setTextLeft1Enable(boolean isEnable) {
        if (isEnable) {
            ViewUtil.show(lefttv1);
        } else {
            ViewUtil.hide(lefttv1);
        }
    }

    /**
     * 设置右1文本按钮的颜色大小
     *
     */
    protected void setTextRight1Size() {
        textRight1.setTextColor(0xFFFC5353);
        textRight1.setTextSize(14.0f);
    }

    /**
     * 设置左1文本按钮的颜色大小
     *
     */
    protected void setTextLeft1Size() {
        lefttv1.setTextColor(0xFFFC5353);
        lefttv1.setTextSize(14.0f);
    }

    /**
     * 设置右2文本按钮是否可用
     *
     * @param isEnable
     */
    protected void setTextRight2Enable(boolean isEnable) {
        if (isEnable) {
            ViewUtil.show(textRight2);
        } else {
            ViewUtil.hide(textRight2);
        }
    }

    /**
     * 设置左1文本按钮标题
     *
     * @param value
     */
    protected void setTextLeft1Val(String value) {
        if (StringUtil.isEmpty(value)) {
            value = "";
        }
        lefttv1.setText(value);
    }

    /**
     * 设置右1文本按钮标题
     *
     * @param value
     */
    protected void setTextRight1Val(String value) {
        if (StringUtil.isEmpty(value)) {
            value = "";
        }
        textRight1.setText(value);
    }

    /**
     * 设置右2文本按钮标题
     *
     * @param value
     */
    protected void setTextRight2Val(String value) {
        if (StringUtil.isEmpty(value)) {
            value = "";
        }
        textRight2.setText(value);
    }


    //默认关闭当前activity
    protected void onBtnLeft1Click() {
        BaseActivityWithToolBar.this.finish();
    }

    protected void onBtnLeft2Click() {

    }

    protected void onBtnRight1Click() {

    }

    protected void onBtnRight2Click() {

    }

    protected void onTextRight1Click() {

    }

    protected void onTextRight2Click() {

    }

    protected void onTextLeft1Click() {

    }

}
