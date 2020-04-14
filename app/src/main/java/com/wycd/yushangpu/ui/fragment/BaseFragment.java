package com.wycd.yushangpu.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wycd.yushangpu.ui.HomeActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    HomeActivity homeActivity;
    View rootView;
    private boolean isInit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getContentView(), null);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, rootView);
        homeActivity = (HomeActivity) getActivity();
        onCreated();
    }

    public void onCreated() {

    }

    public abstract int getContentView();

    @Override
    public void onResume() {
        super.onResume();
        if (!isInit)
            updateData();
        isInit = true;
    }

    protected void setData() {
        if (isInit) {
            updateData();
        }
    }

    protected void updateData() {
    }
}
