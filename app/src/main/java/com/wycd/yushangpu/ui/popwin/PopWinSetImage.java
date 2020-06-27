package com.wycd.yushangpu.ui.popwin;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.blankj.utilcode.util.CacheDoubleUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.google.gson.reflect.TypeToken;
import com.gt.photopicker.SelectModel;
import com.gt.photopicker.intent.PhotoPickerIntent;
import com.gt.utils.GsonUtils;
import com.gt.utils.PermissionUtils;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.tools.GlideTransform;
import com.wycd.yushangpu.ui.BaseActivity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PopWinSetImage {

    Context context;
    MyAdapter adapter;

    public void show(BaseActivity context, View v) {
        this.context = context;
        View contentView = LayoutInflater.from(context).inflate(R.layout.popwin_set_image, null);
        PopupWindow popupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, true);
        popupWindow.setClippingEnabled(false);
        popupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);

        RecyclerView recyclerView = contentView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        recyclerView.setAdapter(adapter = new MyAdapter());

        contentView.findViewById(R.id.background).setOnClickListener(v1 -> {
            popupWindow.dismiss();
        });
        contentView.findViewById(R.id.bgTextView1).setOnClickListener(v1 -> {
            popupWindow.dismiss();
        });
        contentView.findViewById(R.id.bgTextView2).setOnClickListener(v1 -> {
            CacheDoubleUtils.getInstance().put("setImages", GsonUtils.getGson().toJson(adapter.data));
            context.guestShowPresentation.reload();
            popupWindow.dismiss();
        });
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

        public ArrayList<String> data;

        public MyAdapter() {
            String dataStr = CacheDoubleUtils.getInstance().getString("setImages");
            Type type = new TypeToken<List<String>>() {
            }.getType();
            data = GsonUtils.getGson().fromJson(dataStr, type);
            if (data == null) {
                data = new ArrayList<>();
            }
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(context).inflate(R.layout.item_set_image, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            if (position < data.size()) {
                holder.closeView.setVisibility(View.VISIBLE);
                Glide.with(context).load(data.get(position))
                        .placeholder(R.mipmap.member_head_nohead)
                        .transform(new CenterCrop(context), new GlideTransform.GlideCornersTransform(context, 5))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(holder.imageView);
                holder.closeView.setOnClickListener(v -> {
                    data.remove(position);
                    notifyDataSetChanged();
                });
            } else {
                holder.closeView.setVisibility(View.GONE);
                Glide.with(context).load(R.mipmap.member_head_nohead)
                        .placeholder(R.mipmap.member_head_nohead)
                        .transform(new CenterCrop(context), new GlideTransform.GlideCornersTransform(context, 5))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(holder.imageView);
                holder.itemView.setOnClickListener(v -> {
                    PermissionUtils.requestPermission(context, PermissionUtils.READ_EXTERNAL_STORAGE,
                            new PermissionUtils.PermissionGrant() {
                                @Override
                                public void onPermissionGranted(int... requestCode) {
                                    PhotoPickerIntent intent = new PhotoPickerIntent(context);
                                    intent.setSelectModel(SelectModel.MULTI);
                                    intent.setMaxTotal(9);
                                    intent.setSelectedPaths(data);
                                    intent.gotoPhotoPickerActivity(context, resultList -> {
                                        data.addAll(resultList);
                                        notifyDataSetChanged();
                                    });
                                }
                            });
                });
            }
        }

        @Override
        public int getItemCount() {
            return data.size() + 1;
        }

        class Holder extends RecyclerView.ViewHolder {

            @BindView(R.id.imageView)
            ImageView imageView;
            @BindView(R.id.closeView)
            ImageView closeView;

            public Holder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}
