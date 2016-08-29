package com.example.qzl.coordinatordemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.qzl.coordinatordemo.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SwipeDismissBehavior.OnDismissListener {

    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = (TextView) findViewById(R.id.main_text);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler);

        List<String> list = getDataList();
        recyclerView.setAdapter(new MyAdapter(this,list));

//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mText.getLayoutParams();
        //设置behavior
        // 第一种 ：控件的行为 : 滑动删除
//        SwipeDismissBehavior<TextView> behavior = new SwipeDismissBehavior<>();
//        behavior.setListener(this);
//        params.setBehavior(behavior);

//        MyBehavior myBehavior = new MyBehavior();
//        params.setBehavior(myBehavior);


    }

    @NonNull
    private List<String> getDataList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.format(Locale.CHINA,"第%02d条数据",i));
        }
        return list;
    }

    /**
     * 当他消失的时候
     * @param view
     */
    @Override
    public void onDismiss(final View view) {
        //将控件就删除了
        view.setVisibility(View.GONE);
        Snackbar.make(view,"删除了一个控件",Snackbar.LENGTH_LONG)
                .setAction("撤销", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mText.setVisibility(View.VISIBLE);
                        //将alpha变为1
                        ViewCompat.animate(mText).alpha(1).start();
                    }
                }).show();
    }

    /**
     * 滑动的状态改变的时候
     * @param state
     */
    @Override
    public void onDragStateChanged(int state) {

    }
}
