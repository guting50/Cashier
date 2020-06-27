package com.wycd.yushangpu.ui.Presentation;

import android.app.Activity;
import android.app.Presentation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.CacheDoubleUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.reflect.TypeToken;
import com.gt.utils.GsonUtils;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.tools.NullUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class GuestShowPresentation extends Presentation {
    @BindView(R.id.bgImage)
    ImageView bgImage;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.countView)
    TextView countView;
    @BindView(R.id.priceView)
    TextView priceView;
    @BindView(R.id.billLayout)
    LinearLayout billLayout;

    MyAdapter adapter;
    Timer timer;

    public GuestShowPresentation(Activity outerContext, Display display) {
        super(outerContext, display);
        setOwnerActivity(outerContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation_guest_show);
        ButterKnife.bind(this);

        reload();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter = new MyAdapter());
    }

    public void reload() {
        String showBillStr = CacheDoubleUtils.getInstance().getString("showBill");
        String guestShowStr = CacheDoubleUtils.getInstance().getString("guestShow");
        String showVoiceStr = CacheDoubleUtils.getInstance().getString("showVoice");
        String timeStr = CacheDoubleUtils.getInstance().getString("timeInterval");
        int timeInterval = Integer.parseInt(timeStr == null ? "3" : timeStr);
        String dataStr = CacheDoubleUtils.getInstance().getString("setImages");
        Type type = new TypeToken<List<String>>() {
        }.getType();
        List<String> data = GsonUtils.getGson().fromJson(dataStr, type);

        billLayout.setVisibility(View.GONE);
        if (TextUtils.equals("true", showBillStr)) {
            billLayout.setVisibility(View.VISIBLE);
        }

        if (timer != null) {
            timer.cancel();
        }
        if (data != null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                int i = 0;

                @Override
                public void run() {
                    getOwnerActivity().runOnUiThread(() -> {
                        Glide.with(getContext()).load(data.get(i))
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(bgImage);
                        i++;
                        if (i >= data.size()) {
                            i = 0;
                        }
                    });
                }
            }, timeInterval * 1000, timeInterval * 1000);
        }
    }

    public void loadData(List<ShopMsg> data, String allmoney) {
        priceView.setText(allmoney);
        countView.setText("共" + data.size() + "件商品");
        adapter.setData(data);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
        List<ShopMsg> data = new ArrayList<>();

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_guest_goods, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            ShopMsg item = data.get(position);
            holder.countView.setText("x " + item.getNum() + "");
            holder.goodsNameView.setText(NullUtils.noNullHandle(item.getPM_Name()).toString() + "  " + NullUtils.noNullHandle(item.getPM_Modle()).toString());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public void setData(List<ShopMsg> data) {
            this.data = data;
            notifyDataSetChanged();
        }

        class MyHolder extends RecyclerView.ViewHolder { 

            @BindView(R.id.imageView)
            ImageView imageView;
            @BindView(R.id.goodsNameView)
            TextView goodsNameView;
            @BindView(R.id.priceView)
            TextView priceView;
            @BindView(R.id.countView)
            TextView countView;

            public MyHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}
