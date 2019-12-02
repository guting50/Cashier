// Generated code from Butter Knife. Do not modify!
package com.wycd.yushangpu.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class YuangongAdapter$ViewHolder$$ViewBinder<T extends com.wycd.yushangpu.adapter.YuangongAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755491, "field 'tv_ygname'");
    target.tv_ygname = finder.castView(view, 2131755491, "field 'tv_ygname'");
    view = finder.findRequiredView(source, 2131755492, "field 'tv_ygcode'");
    target.tv_ygcode = finder.castView(view, 2131755492, "field 'tv_ygcode'");
    view = finder.findRequiredView(source, 2131755493, "field 'tv_ygsex'");
    target.tv_ygsex = finder.castView(view, 2131755493, "field 'tv_ygsex'");
    view = finder.findRequiredView(source, 2131755504, "field 'iv_chose'");
    target.iv_chose = finder.castView(view, 2131755504, "field 'iv_chose'");
  }

  @Override public void unbind(T target) {
    target.tv_ygname = null;
    target.tv_ygcode = null;
    target.tv_ygsex = null;
    target.iv_chose = null;
  }
}
