package com.example.qzl.coordinatordemo.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义behavior
 * 做到控件的出现时删除
 * Created by Qzl on 2016-08-29.
 */
public class MyBehavior extends CoordinatorLayout.Behavior {

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    /**
     * 开始滚动事件，返回值表示你是否关心这一滚动事件
     * @param coordinatorLayout
     * @param child
     * @param directTargetChild
     * @param target
     * @param nestedScrollAxes
     * @return
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    /**
     * 滚动
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dx
     * @param dy
     * @param consumed
     */
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if (dy < 0){
            //向下滚动
            ViewCompat.animate(child).scaleX(1).scaleY(1).start();//显示
        }else {
            //向上滚动
            ViewCompat.animate(child).scaleX(0).scaleY(0).start();//显示
        }
    }
}
