package com.wsywddr.herotears;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.VolleyError;
import com.wsywddr.herotears.R;
import com.wsywddr.herotears.base.BaseActivity;
import com.wsywddr.herotears.data.user.UserServiceImpl;
import com.wsywddr.herotears.model.Response;
import com.wsywddr.herotears.model.main.FirstEvent;
import com.wsywddr.herotears.model.main.Parent;
import com.wsywddr.herotears.util.AppConfig;
import com.wsywddr.herotears.util.ToastUtil;
import com.wsywddr.herotears.util.net.DefaultResponseListener;

import org.greenrobot.eventbus.EventBus;
import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bappy on 16-7-11.
 */
public class testActivity extends BaseActivity {
    DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
            .setDbName("test.db")
            // 不设置dbDir时, 默认存储在app的私有目录.
//            .setDbDir(new File("/sdcard")) // "sdcard"的写法并非最佳实践, 这里为了简单, 先这样写了.
            .setDbVersion(2)
            .setDbOpenListener(new DbManager.DbOpenListener() {
                @Override
                public void onDbOpened(DbManager db) {
                    // 开启WAL, 对写入加速提升巨大
                    db.getDatabase().enableWriteAheadLogging();
                }
            })
            .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                @Override
                public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                    // TODO: ...
                    // db.addColumn(...);
                    // db.dropTable(...);
                    // ...
                    // or
                    // db.dropDb();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        ImageLoader.getInstance().displayImage("",);
        EventBus.getDefault().post(new FirstEvent("FirstEvent btn clicked","100"));
        testHttp();
        testDb();
    }

    private void testDb()
    {
        x.task().run(new Runnable() { // 异步执行
            @Override
            public void run() {

                DbManager db = x.getDb(daoConfig);
                String result = "";

                List<Parent> parentList = new ArrayList<Parent>();
                for (int i = 0; i < 1000; i++) {
                    Parent parent = new Parent();
                    parent.setAdmin(true);
                    parent.setDate(new java.sql.Date(1234));
                    parent.setTime(new Date());
                    parent.setEmail(i + "_@qq.com");
                    parentList.add(parent);
                }

                long start = System.currentTimeMillis();
                for (Parent parent : parentList) {
                    try {
                        db.save(parent);
                    } catch (DbException ex) {
                        ex.printStackTrace();
                    }
                }
                result += "插入1000条数据:" + (System.currentTimeMillis() - start) + "ms\n";

                start = System.currentTimeMillis();
                try {
                    parentList = db.selector(Parent.class).orderBy("id", true).limit(1000).findAll();
                } catch (DbException ex) {
                    ex.printStackTrace();
                }
                result += "查找1000条数据:" + (System.currentTimeMillis() - start) + "ms\n";

                start = System.currentTimeMillis();
                try {
                    db.delete(parentList);
                } catch (DbException ex) {
                    ex.printStackTrace();
                }
                result += "删除1000条数据:" + (System.currentTimeMillis() - start) + "ms\n";

                // 批量插入
                parentList = new ArrayList<Parent>();
                for (int i = 0; i < 1000; i++) {
                    Parent parent = new Parent();
                    parent.setAdmin(true);
                    parent.setDate(new java.sql.Date(1234));
                    parent.setTime(new Date());
                    parent.setEmail(i + "_@qq.com");
                    parentList.add(parent);
                }

                start = System.currentTimeMillis();
                try {
                    db.save(parentList);
                } catch (DbException ex) {
                    ex.printStackTrace();
                }
                result += "批量插入1000条数据:" + (System.currentTimeMillis() - start) + "ms\n";

                try {
                    parentList = db.selector(Parent.class).orderBy("id", true).limit(1000).findAll();
                    db.delete(parentList);
                } catch (DbException ex) {
                    ex.printStackTrace();
                }

                final String finalResult = result;
                x.task().post(new Runnable() { // UI同步执行
                    @Override
                    public void run() {
                        ToastUtil.show(getApplicationContext(),finalResult);
                    }
                });
            }
        });
    }

    private void testHttp()
    {
        new UserServiceImpl().getBusinessInfo(AppConfig.getUid(preference), new DefaultResponseListener<Response<String>>() {
            @Override
            public void onSuccess(Response<String> response) {
                Log.d("responseresponse", "" + response.getData());
                if (response.getCode() == 0) {
//                    UserBusinessInfo userBusinessInfo = response.getData();
//                    if (userBusinessInfo != null) {
////                        AppConfig.businessInfo = userBusinessInfo;
////                        AppConfig.setPreferenceTo(preference,"business_status",userBusinessInfo.getStatus());
////
////                        Intent intent = new Intent();
////                        intent.setAction("com.byread.imglogo");
////                        intent.putExtra("type", "businessInfo");
////                        sendBroadcast(intent);
////                        initRongCloud(userBusinessInfo.getName(), userBusinessInfo.getAvatar(), userBusinessInfo.getUid());
//                    }
                } else {
                    ToastUtil.show(getApplicationContext(), response.getMsg());
                }
            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }
}
