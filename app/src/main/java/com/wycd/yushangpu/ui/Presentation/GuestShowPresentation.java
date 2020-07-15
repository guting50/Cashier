package com.wycd.yushangpu.ui.Presentation;

import android.app.Activity;
import android.app.Presentation;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
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
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.google.gson.reflect.TypeToken;
import com.gt.utils.GsonUtils;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.tools.GlideTransform;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;

import java.io.IOException;
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

    public static GuestShowPresentation guestShowPresentation;

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

    public static void reload() {
        if (guestShowPresentation == null) {
            return;
        }
        String showBillStr = CacheDoubleUtils.getInstance().getString("showBill");
        String guestShowStr = CacheDoubleUtils.getInstance().getString("guestShow");
        String timeStr = CacheDoubleUtils.getInstance().getString("timeInterval");
        int timeInterval = Integer.parseInt(timeStr == null ? "3" : timeStr.split(" ")[0]);
        String dataStr = CacheDoubleUtils.getInstance().getString("setImages");
        Type type = new TypeToken<List<String>>() {
        }.getType();
        List<String> data = GsonUtils.getGson().fromJson(dataStr, type);


        if (guestShowPresentation.timer != null) {
            guestShowPresentation.timer.cancel();
        }
        guestShowPresentation.bgImage.setImageResource(R.drawable.presentation_bg);
        if (TextUtils.equals("true", guestShowStr)) {
            if (data != null && data.size() > 0) {
                guestShowPresentation.timer = new Timer();
                guestShowPresentation.timer.schedule(new TimerTask() {
                    int i = 0;

                    @Override
                    public void run() {
                        guestShowPresentation.getOwnerActivity().runOnUiThread(() -> {
                            Glide.with(guestShowPresentation.getContext()).load(data.get(i))
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .into(guestShowPresentation.bgImage);
                            i++;
                            if (i >= data.size()) {
                                i = 0;
                            }
                        });
                    }
                }, timeInterval * 1000, timeInterval * 1000);
            }
        }
        guestShowPresentation.billLayout.setVisibility(View.GONE);
        if (TextUtils.equals("true", showBillStr)) {
            guestShowPresentation.billLayout.setVisibility(View.VISIBLE);
        }
    }

    public static void loadData(List<ShopMsg> data, String allmoney) {
        if (guestShowPresentation == null) {
            return;
        }
        guestShowPresentation.priceView.setText(allmoney);
        guestShowPresentation.countView.setText("共" + data.size() + "件商品");
        guestShowPresentation.adapter.setData(data);
    }

    public static void playAudio() {
        if (guestShowPresentation == null) {
            return;
        }
        String showVoiceStr = CacheDoubleUtils.getInstance().getString("showVoice");
        if (TextUtils.equals("true", showVoiceStr)) {
            AssetManager assetManager;
            MediaPlayer player = new MediaPlayer();
            assetManager = guestShowPresentation.getResources().getAssets();
            try {
                AssetFileDescriptor fileDescriptor = assetManager.openFd("9586.mp3");
                player.setDataSource(fileDescriptor.getFileDescriptor(), fileDescriptor.getStartOffset(), fileDescriptor.getStartOffset());
                player.prepare();
                player.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
            Glide.with(getContext()).load(ImgUrlTools.obtainUrl(NullUtils.noNullHandle(item.getPM_BigImg()).toString()))
                    .placeholder(R.mipmap.messge_nourl)
                    .transform(new CenterCrop(getContext()), new GlideTransform.GlideCornersTransform(getContext(), 4))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.imageView);
            holder.countView.setText("x " + item.getNum() + "");
            holder.goodsNameView.setText(NullUtils.noNullHandle(item.getPM_Name()).toString() + "  " + NullUtils.noNullHandle(item.getPM_Modle()).toString());
            holder.priceView.setText("￥" + StringUtil.twoNum(item.getAllprice() + ""));
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
