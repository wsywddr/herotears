package com.wsywddr.herotears.fragment;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.wsywddr.herotears.R;
import com.wsywddr.herotears.base.BaseFragment;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;

/**
 * 订单
 * Created by fengxiang on 2016/3/15.
 */
@EFragment(R.layout.fragment_push)
public class PushFragment extends BaseFragment {
    @ViewById
    ListView list01;
    List<PhotoInfo> mPhotoList=new ArrayList<PhotoInfo>();
    Myadapter adapter;

    int REQUEST_CODE_CAMERA=0;
    int REQUEST_CODE_GALLERY=1;

    @AfterViews
    void afterViews() {
        adapter = new Myadapter(getActivity(), mPhotoList);
        list01.setAdapter(adapter);
    }

    @Click(R.id.btn01)
    void btn01Click(){
        //带配置
        //配置功能
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setMutiSelectMaxSize(8)
                .setEnableCamera(false)
                .setEnableEdit(false)
                .setEnableCrop(false)
                .setEnableRotate(true)
                .setCropSquare(true)
                .setEnablePreview(true)
        .build();
//        GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY, functionConfig, mOnHanlderResultCallback);

        GalleryFinal.openGalleryMuti(REQUEST_CODE_GALLERY, functionConfig, mOnHanlderResultCallback);
    }

    @Click(R.id.btn02)
    void btn02Click(){
        GalleryFinal.openCamera(REQUEST_CODE_CAMERA, mOnHanlderResultCallback);
    }

    private GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback = new GalleryFinal.OnHanlderResultCallback() {
        @Override
        public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
            if (resultList != null) {
                mPhotoList.addAll(resultList);
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onHanlderFailure(int requestCode, String errorMsg) {

        }
    };

    public class Myadapter extends BaseAdapter{
        private LayoutInflater mInflater;

        public Myadapter(Context pContext, List<PhotoInfo> pList) {
            mInflater = LayoutInflater.from(pContext);
        }

        @Override
        public int getCount() {
            return mPhotoList.size();
        }

        @Override
        public Object getItem(int i) {
            return mPhotoList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.photos_list_item, null);
                holder = new ViewHolder();
                holder.img01 = (ImageView) convertView.findViewById(R.id.img01);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            ImageLoader.getInstance().displayImage("file://"+mPhotoList.get(i).getPhotoPath(),holder.img01);

            return convertView;
        }
    }
    //st ViewHolder
    private static class ViewHolder {
        private ImageView img01;
    }

}
