package com.wycd.yushangpu.tools;

import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private FragmentManager fm;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fm = fm;
    }


    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    public void addItem(Fragment fragment, String title) {
        fragments.add(fragment);
        titles.add(title);
    }

    @Override
    public Fragment instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container,
                position);
        fm.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // super.destroyItem(container, position, object);
        Fragment fragment = fragments.get(position);
        fm.beginTransaction().hide(fragment).commit();
    }
}
