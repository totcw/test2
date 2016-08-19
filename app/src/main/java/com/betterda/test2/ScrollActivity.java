package com.betterda.test2;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/29.
 */
public class ScrollActivity extends Activity {
    private  MyScrollView scrollView;
    MyListview listView;
    private List<Bean.AddressEntity> mainList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        scrollView = (MyScrollView) findViewById(R.id.scrollView);
        scrollView.post(new Runnable() {
            //让scrollview跳转到顶部，必须放在runnable()方法中
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });
        initModle();
        listView = (MyListview) findViewById(R.id.listview);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return mainList.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = View.inflate(ScrollActivity.this, R.layout.item_pp_main_sort, null);
                return view;
            }
        });



    }

    /**
     * 初始化二级联动的数据
     */
    private void initModle() {
        mainList = new ArrayList<Bean.AddressEntity>();
        for (int i = 0; i < 30; i++) {
            Bean.AddressEntity b = new Bean.AddressEntity();
            b.setName("tete"+i);
            mainList.add(b);
        }

    }

}
