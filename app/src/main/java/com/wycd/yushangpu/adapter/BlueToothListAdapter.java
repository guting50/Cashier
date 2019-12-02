package com.wycd.yushangpu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wycd.yushangpu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 蓝牙列表适配器
 * iauthor：Cheng
 * date: 2017/5/23 10:11
 * email：jasoncheng9111@gmail.com
 */
public class BlueToothListAdapter extends BaseAdapter
{
    private Context mContext;
    private List<String> list_device_name = new ArrayList<>();

    public BlueToothListAdapter(Context context, List<String> deviceName_list)
    {
        mContext = context;
        this.list_device_name = deviceName_list;
    }

    @Override
    public int getCount()
    {
        return list_device_name.size();
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ViewHolder viewHolder = null;
        if (view == null)
        {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_bluetooth, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.iv_bluetooth_logo = (ImageView) view.findViewById(R.id.iv_bluetooth_logo);
            viewHolder.tv_bluetooth_name = (TextView) view.findViewById(R.id.tv_bluetooth_name);
            viewHolder.tv_connect_state = (TextView) view.findViewById(R.id.tv_connect_state);
            viewHolder.iv_bluetooth_connect = (ImageView) view.findViewById(R.id.iv_bluetooth_connect);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }

        if (list_device_name.size() != 0 & list_device_name.get(i)!=null)
        {
            if (!list_device_name.get(i).equals(""))
            {
                viewHolder.tv_bluetooth_name.setText(list_device_name.get(i));
            }
        }
        return view;
    }

    class ViewHolder
    {
        ImageView iv_bluetooth_logo;
        TextView tv_bluetooth_name;
        TextView tv_connect_state;
        ImageView iv_bluetooth_connect;
    }
}
