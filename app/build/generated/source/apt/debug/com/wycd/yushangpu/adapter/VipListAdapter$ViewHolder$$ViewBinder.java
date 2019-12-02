// Generated code from Butter Knife. Do not modify!
package com.wycd.yushangpu.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class VipListAdapter$ViewHolder$$ViewBinder<T extends com.wycd.yushangpu.adapter.VipListAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755360, "field 'mTvVipcard'");
    target.mTvVipcard = finder.castView(view, 2131755360, "field 'mTvVipcard'");
    view = finder.findRequiredView(source, 2131755236, "field 'mTvVipname'");
    target.mTvVipname = finder.castView(view, 2131755236, "field 'mTvVipname'");
    view = finder.findRequiredView(source, 2131755361, "field 'mTvVipdnegji'");
    target.mTvVipdnegji = finder.castView(view, 2131755361, "field 'mTvVipdnegji'");
    view = finder.findRequiredView(source, 2131755362, "field 'mTvVipyue'");
    target.mTvVipyue = finder.castView(view, 2131755362, "field 'mTvVipyue'");
    view = finder.findRequiredView(source, 2131755363, "field 'mTvVipjifen'");
    target.mTvVipjifen = finder.castView(view, 2131755363, "field 'mTvVipjifen'");
    view = finder.findRequiredView(source, 2131755364, "field 'mTvVipnum'");
    target.mTvVipnum = finder.castView(view, 2131755364, "field 'mTvVipnum'");
  }

  @Override public void unbind(T target) {
    target.mTvVipcard = null;
    target.mTvVipname = null;
    target.mTvVipdnegji = null;
    target.mTvVipyue = null;
    target.mTvVipjifen = null;
    target.mTvVipnum = null;
  }
}
