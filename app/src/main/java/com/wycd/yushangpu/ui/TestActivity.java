package com.wycd.yushangpu.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.BasePageRes;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpShopHome;
import com.wycd.yushangpu.tools.NullUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends BaseActivity {
    @BindView(R.id.goods_list)
    RecyclerView goodsList;
    @BindView(R.id.aaa)
    TextView aaa;
    @BindView(R.id.bbb)
    TextView bbb;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_activity);
        ButterKnife.bind(this);
        GridLayoutManager glm = new GridLayoutManager(this, 3);
        glm.setAutoMeasureEnabled(false);
        goodsList.setLayoutManager(glm);
        adapter = new Adapter();
        goodsList.setAdapter(adapter);
        obtainHomeShop("");
        aaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtainHomeShop("");
            }
        });
        bbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtainHomeShop("combo");
            }
        });
    }

    public void obtainHomeShop(String gid) {
        ImpShopHome shopHome = new ImpShopHome();
        shopHome.shoplist(1, 100, gid, "", new InterfaceBack<BasePageRes>() {
            @Override
            public void onResponse(BasePageRes response) {
                Type listType = new TypeToken<List<ShopMsg>>() {
                }.getType();
                List<ShopMsg> sllist = response.getData(listType);

                adapter.getShopMsgList().clear();
                adapter.addShopMsgList(sllist);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onErrorResponse(Object msg) {
            }
        });
    }

    class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        List<ShopMsg> shopMsgList = new ArrayList<>();

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_home_rightshop, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ShopMsg ts = shopMsgList.get(position);
            ts.init();
            Holder myHolser = (Holder) holder;
            myHolser.mTvName.setText(NullUtils.noNullHandle(ts.getPM_Name()).toString());
        }

        public List<ShopMsg> getShopMsgList() {
            return shopMsgList;
        }

        public void addShopMsgList(List<ShopMsg> shopMsgList) {
            this.shopMsgList.addAll(shopMsgList);
        }

        @Override
        public int getItemCount() {
            return shopMsgList.size();
        }
    }

    class Holder extends RecyclerView.ViewHolder {

        View rootView;
        @BindView(R.id.tv_name)
        TextView mTvName;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            rootView = itemView;
        }
    }
}
