// Generated code from Butter Knife. Do not modify!
package com.wycd.yushangpu.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ShopRightAdapter$ViewHolder$$ViewBinder<T extends com.wycd.yushangpu.adapter.ShopRightAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755215, "field 'mIvShop'");
    target.mIvShop = finder.castView(view, 2131755215, "field 'mIvShop'");
    view = finder.findRequiredView(source, 2131755515, "field 'mIvState'");
    target.mIvState = finder.castView(view, 2131755515, "field 'mIvState'");
    view = finder.findRequiredView(source, 2131755332, "field 'mTvName'");
    target.mTvName = finder.castView(view, 2131755332, "field 'mTvName'");
    view = finder.findRequiredView(source, 2131755516, "field 'mTvXinghao'");
    target.mTvXinghao = finder.castView(view, 2131755516, "field 'mTvXinghao'");
    view = finder.findRequiredView(source, 2131755517, "field 'mTvSanprice'");
    target.mTvSanprice = finder.castView(view, 2131755517, "field 'mTvSanprice'");
    view = finder.findRequiredView(source, 2131755511, "field 'mTvVipprice'");
    target.mTvVipprice = finder.castView(view, 2131755511, "field 'mTvVipprice'");
    view = finder.findRequiredView(source, 2131755519, "field 'mIvKu'");
    target.mIvKu = finder.castView(view, 2131755519, "field 'mIvKu'");
    view = finder.findRequiredView(source, 2131755520, "field 'mTvKunum'");
    target.mTvKunum = finder.castView(view, 2131755520, "field 'mTvKunum'");
    view = finder.findRequiredView(source, 2131755518, "field 'llKucun'");
    target.llKucun = finder.castView(view, 2131755518, "field 'llKucun'");
  }

  @Override public void unbind(T target) {
    target.mIvShop = null;
    target.mIvState = null;
    target.mTvName = null;
    target.mTvXinghao = null;
    target.mTvSanprice = null;
    target.mTvVipprice = null;
    target.mIvKu = null;
    target.mTvKunum = null;
    target.llKucun = null;
  }
}
