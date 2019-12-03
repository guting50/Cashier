package com.wycd.yushangpu.tools;

import android.widget.GridView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ZPH on 2019-06-19.
 */

public class RecycleViewUtiles {

    /**
     * RecyclerView 移动到当前位置，
     *
     * @param manager       设置RecyclerView对应的manager
     * @param mRecyclerView 当前的RecyclerView
     * @param n             要跳转的位置
     */
    public static void MoveToPosition(LinearLayoutManager manager, RecyclerView mRecyclerView, int n, boolean isleft) {
        int firstItem = manager.findFirstVisibleItemPosition();
        int lastItem = manager.findLastVisibleItemPosition();

        int rcWidth = mRecyclerView.getWidth();
        int total = 0;


        if (isleft) {
            int position = 0;

            for (int i = 0; i < mRecyclerView.getChildCount(); i++) {
                if (i > 0) {
                    total += mRecyclerView.getChildAt(i).getWidth();
                } else {
                    total += mRecyclerView.getChildAt(i).getWidth() * 0.5;
                }
            }

            if (firstItem >= 0) {
                if (rcWidth >= total) {
                    position = rcWidth - mRecyclerView.getChildAt(0).getWidth();
                } else {
                    position = rcWidth - mRecyclerView.getChildAt(1).getWidth();
                }
                mRecyclerView.scrollBy(-position, 0);
            } else {
                mRecyclerView.smoothScrollToPosition(0);
            }

        } else {
            int position = 0;
            for (int i = 0; i < mRecyclerView.getChildCount(); i++) {
                if (i < mRecyclerView.getChildCount() - 1) {
                    total += mRecyclerView.getChildAt(i).getWidth();
                } else {
                    total += mRecyclerView.getChildAt(i).getWidth() * 0.5;
                }
            }
            if (lastItem < n) {
                if (rcWidth >= total) {
                    position = mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1).getLeft();
                } else {
                    position = mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 2).getLeft();
                }
                mRecyclerView.scrollBy(position, 0);
            } else {
                mRecyclerView.smoothScrollToPosition(n);
            }


        }
//        mRecyclerView.scrollToPosition(0);//滚动
//        recyclerView.smoothScrollToPosition(position);//滑动
    }


    private int numGrid(GridView v) {
        v.getWidth();
        return 0;
    }
}
